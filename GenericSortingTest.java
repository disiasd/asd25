/* ************************************************
 * Classe per testare gli algoritmi di ordinamento
 * su tipi generici.
 *
 * Esempio di esecuzione::
 *
 * java GenericSortingTest file selectionsort
 *
 * dove "file" è il nome di un file contenente interi
 * e selectionsort è uno degli algoritmi di ordinamento
 * fornini dalla classe Sorting.
 *
 * *************************************************/

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;


import java.util.Comparator;

import algorithm.sorting.Sorting;


public class GenericSortingTest {

    private static Integer[] readarray(String filename) throws FileNotFoundException {
        ArrayList<Integer> L = new ArrayList<Integer>();
        Scanner input        = new Scanner(new File(filename));
        while(input.hasNext()) 
            L.add(input.nextInt());
        
        
        return L.toArray(new Integer[L.size()]);
    }

    private static Integer[] savesorted(Integer A[]) {
        Integer[] B = A.clone();
        Comparator<Integer> comparator = Integer::compare;
        Arrays.sort(B,comparator);
        return B;
    } 

    private static boolean issorted(Integer A[], Integer B[]) {
        for(int i = 0; i < A.length-1; i++)
            if(A[i].intValue() != B[i].intValue()) {
                System.out.println("\nDIFF at " + i + " " + A[i] + " " + B[i]);
                System.out.println(Arrays.toString(A));
                System.out.println(Arrays.toString(B));             
                System.exit(0);
                return false;
            }
        return true;
    }

    public static void main(String args[]) {
    Integer A[] = null;
        Integer B[] = null;
        Integer C[] = null;
        long start, end;

        
        if(args.length != 1) {
            System.err.println("Usage: GenericSortingTest <filename>");
            System.exit(0);
        }

        try {
            A = readarray(args[0]);
            B = savesorted(A);
            C = Arrays.copyOf(A,A.length);
        } catch(Exception e) {
            System.out.println(e.toString());
            System.exit(1);
        }

        try {
			
			
            // Selectionsort
            System.out.print("Algorithm: selectionsort ");
            start = System.currentTimeMillis();
            Sorting.selectionsort(A);
            end  = System.currentTimeMillis();
            System.out.println("Time: " + (end-start)/1000.0 +  " sec " + (issorted(A,B) ? "[SORTED]" : "[UNSORTED]"));

            // Insertionsort
            System.out.print("Algorithm: insertionsort ");
            A = Arrays.copyOf(C,C.length);
            start = System.currentTimeMillis();
            Sorting.insertionsort(A);
            end  = System.currentTimeMillis();
            System.out.println("Time: " + (end-start)/1000.0 +  " sec " + (issorted(A,B) ? "[SORTED]" : "[UNSORTED]"));

            // Mergesort
            System.out.print("Algorithm: mergesort     ");
            A = Arrays.copyOf(C,C.length);
            start = System.currentTimeMillis();
            Sorting.mergesort(A);
            end  = System.currentTimeMillis();
            System.out.println("Time: " + (end-start)/1000.0 +  " sec " + (issorted(A,B) ? "[SORTED]" : "[UNSORTED]"));

            // Quicksort
            System.out.print("Algorithm: quicksort     ");
            A = Arrays.copyOf(C,C.length);
            start = System.currentTimeMillis();
            Sorting.quicksort(A);
            end  = System.currentTimeMillis();
            System.out.println("Time: " + (end-start)/1000.0 +  " sec " + (issorted(A,B) ? "[SORTED]" : "[UNSORTED]")); 
			
				
			// Heapsort
			System.out.print("Algorithm: heapsort      ");
			A = Arrays.copyOf(C,C.length);
			start = System.currentTimeMillis();
			Sorting.heapsort(A);
			end  = System.currentTimeMillis();
			System.out.println("Time: " + (end-start)/1000.0 +  " sec " + (issorted(A,B) ? "[SORTED]" : "[UNSORTED]"));		
			    
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }   
}
