/* ************************************************
 * Classe per testare gli algoritmi di ordinamento.
 *
 * Esempio di esecuzione::
 *
 * java SortingTest file selectionsort
 *
 * dove "file" è il nome di un file contenente interi
 * e selectionsort è uno degli algoritmi di ordinamento
 * fornini dalla classe Sorting.
 *
 * Attenzione: l'algoritmo quicksort potrebbe causare
 * stack overflow. In tal caso, modificare la dimensione
 * dello stack della JVM con il seguente comando:
 *
 * java -Xss20m SortingTest file quicksort
 *
 * *************************************************/

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;


import algorithm.sorting.Sorting;


public class SortingTest {

	private static int[] readarray(String filename) throws FileNotFoundException {
		ArrayList<Integer> L = new ArrayList<Integer>();
		Scanner input        = new Scanner(new File(filename));
		while(input.hasNext()) 
			L.add(input.nextInt());
		
		
		return L.stream().mapToInt(Integer::intValue).toArray();
	}

	private static int[] savesorted(int A[]) {
		int[] B = A.clone();
		Arrays.sort(B);
		return B;
	} 

	private static boolean issorted(int A[], int B[]) {
		for(int i = 0; i < A.length-1; i++)
			if(A[i] != B[i])
				return false;
		return true;
	}

	public static void main(String args[]) {
		Sorting S   = new Sorting();
        Method  M   = null;
        int     A[] = null;
		int     B[] = null;

		
		if(args.length != 2) {
			
			System.err.println("Usage: SortingTest <filename> <sorting algorithm>\n");
			System.err.println("Sorting algorithms:");
			for (Method m : S.getClass().getMethods()) {
  				if (m.getDeclaringClass() == S.getClass() && m.getParameterTypes()[0].equals(int[].class))
    				System.err.println("- " + m.getName());
			}
			System.exit(0);
		}

		try {
			M = S.getClass().getDeclaredMethod(args[1],int[].class);
    } catch(Exception e) {
			System.out.println(e.toString());
			System.exit(1);
		}

		try {
			A = readarray(args[0]);
			B = savesorted(A);
		} catch(Exception e) {
			System.out.println(e.toString());
			System.exit(1);
		}

		try {
			long start = System.currentTimeMillis();
			M.invoke(S,A);
			long end  = System.currentTimeMillis();
			System.out.println(Arrays.toString(A));
			System.out.println("Algorithm: " + args[1] + "    \tTime: " + (end-start)/1000.0 +  "s " + (issorted(A,B) ? "[SORTED]" : "[UNSORTED]"));
		} catch(Exception e) {
            e.printStackTrace();
			System.exit(1);
		}

	}
	
}
