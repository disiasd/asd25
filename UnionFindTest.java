/* ************************************************
 * Classe per testare le UnionFind.
 *
 * Esempio di esecuzione:
 *
 * java UnionFindTest fileIn
 *
 * dove "fileIn" è il nome di un file di testo che in 
 * ogni riga contiene due interi separati da un TAB;
 * gli interi rappresentano incroci e due interi sulla
 * stessa riga rappresentano due incroci collegati da una
 * strada
 *
 * Il test legge il file, crea un nodo in una struttura
 * union-find e effettua delle union sugli insiemi a cui
 * appartengono due incroci collegati da una strada.
 * Dopo aver effettuato le union legge coppie di incroci 
 * e comunica se tali incroci sono collegati (direttamente 
 * o indirettamente).
 *
 * Come file di esempio, si può utilizzare la rappresentazione
 * delle strade del texas roadNet-TX.txt. E' interessante notare
 * che esistono coppie di incroci non collegati, ad esempio
 * 1393132 è collegato solo a 1393133
 * *************************************************/

import java.io.*;
import java.util.*;

import datastructure.unionfind.*;

public class UnionFindTest {
	
	/*
	* Main per leggere un file che descrive strade come collegamenti fra due incroci,
	* e successivamente risponde a quesiti relativamente alla connessione di due incroci
	*/	
		
	public static void main( String[] args ) {
			
		try {
			
			// Legge il file di input con la descrizione della strade
			
			long start_t, end_t, elapsed, min;
			double sec;
			
			File file = new File(args[0]);
			
			// Inserisce le strade inserendo gli incroci sorgenti e gli incroci destinazione
			// delle strade negli ArrayList src e dst
						
			BufferedReader br = new BufferedReader(new FileReader(file));
			ArrayList<Integer> src = new ArrayList<Integer>();
			ArrayList<Integer> dst = new ArrayList<Integer>();
			String st;
			int max=0,s,d,v;
			while ((st = br.readLine()) != null) {
				v = st.indexOf("\t");
				s = Integer.valueOf(st.substring(0,v));
				d = Integer.valueOf(st.substring(v+1));
				if (s>max) max=s;
				if (d>max) max=d;
				src.add(s);
				dst.add(d);
			}
			
			// Crea una struttura Union Find inserendo tutti gli incroci, unendoli successivamente
			// in base alle strade presenti
						
			ArrayList<UnionFindNode<Integer>> elems = new ArrayList<UnionFindNode<Integer>>();
			UnionFind<Integer> uf = new QuickFindSize<Integer>();
			for (int i=0; i <= max; i++) elems.add(uf.makeSet(i));
			
			start_t = System.currentTimeMillis();

			for (int i = 0; i < src.size(); i++) {
				uf.union(uf.find(elems.get(src.get(i))),uf.find(elems.get(dst.get(i))));	 
			}
			
			end_t = System.currentTimeMillis();
			elapsed = (end_t - start_t);
			min = elapsed / (60*1000);
			sec = (elapsed - min*60*1000)/1000.0;
			System.out.println("Elaborazione collegamenti: "+min+" min "+sec+" sec");

			System.out.println(uf);

			// Richiede coppie di incroci e risponde dicendo se tali incroci sono collegati
			// (direttamente o indirettamente)
			
			Scanner scanner = new Scanner(System.in);
			int u1,u2;
			boolean connected;
			do {
				System.out.println("Inserisci due punti (-1 per terminare):");
				u1 = scanner.nextInt();
				if (u1 == -1) break;
				u2 = scanner.nextInt();
				start_t = System.currentTimeMillis();
				connected = (uf.find(elems.get(u1)) == uf.find(elems.get(u2)));
				end_t = System.currentTimeMillis();
				elapsed = (end_t - start_t);
				min = elapsed / (60*1000);
				sec = (elapsed - min*60*1000)/1000.0;
				System.out.println("Controllo connessione: "+min+" min "+sec+" sec");
				if (connected)
					System.out.println("collegati");
				else
					System.out.println("scollegati");
			} while (u1 != -1);
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
 
 
