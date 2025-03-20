import java.lang.IllegalArgumentException;
import java.util.HashMap;
import java.util.Random;

import datastructure.dictionary.AVLDictionary;
import datastructure.dictionary.HashTable;

public class DictionarySpeedTest {

    public static String randomString(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        Random rand  = new Random();
        String str    = "";
        for(int i = 0; i < length; i++)
            str = str + chars.charAt(rand.nextInt(chars.length()));
        return str; 
    }

    public static void main(String args[]) {
        if(args.length != 1) {
            System.err.println("Usage: DictionarySpeedTest <int>");
            System.exit(0);         
        }   

        Integer[] keys = null;
        String[]  data = null;

        try {
            int n = Integer.valueOf(args[0]);   
            if(n <= 0)
                throw new IllegalArgumentException("Input number sould be > 0");

            Random rand = new Random();
            keys        = new Integer[n];
            data        = new String[n];
            for(int i = 0; i < n; i++) {
                keys[i] = Math.abs(rand.nextInt());
                data[i] = randomString(3);
                //System.out.println(keys[i] + ":" + data[i]);  
            }
            
        } catch(Exception e) {
            System.out.println(e);
            System.exit(1);
        }

        long start, end;
        HashMap<Integer,String>       H = new HashMap<>();
        HashTable<Integer,String>     T = new HashTable<>();
        AVLDictionary<Integer,String> A = new AVLDictionary<>();

        System.gc();
        System.out.println("***** Insert Speed Test *****");
        start = System.currentTimeMillis();
        for(int i = 0; i < keys.length; i++)
            H.put(keys[i],data[i]);
        end  = System.currentTimeMillis();
        System.out.println("Insert with HashMap:       " + (end-start)/1000.0 +  "s ");
    
        System.gc();
        start = System.currentTimeMillis();
        for(int i = 0; i < keys.length; i++)
            T.insert(keys[i],data[i]);
        end  = System.currentTimeMillis();
        System.out.println("Insert with HashTable:     " + (end-start)/1000.0 +  "s ");

        System.gc();
        start = System.currentTimeMillis();
        for(int i = 0; i < keys.length; i++)
            A.insert(keys[i],data[i]);
        end  = System.currentTimeMillis();
        System.out.println("Insert with AVLDictionary: " + (end-start)/1000.0 +  "s ");

        System.gc();
        System.out.println("\n***** Search Speed Test *****");
        start = System.currentTimeMillis();
        for(int i = 0; i < keys.length; i++)
            H.get(keys[i]);
        end  = System.currentTimeMillis();
        System.out.println("Search with HashMap:       " + (end-start)/1000.0 +  "s ");

        System.gc();  
        start = System.currentTimeMillis();
        for(int i = 0; i < keys.length; i++)
            T.search(keys[i]);
        end  = System.currentTimeMillis();
        System.out.println("Search with HashTable:     " + (end-start)/1000.0 +  "s ");
        
        System.gc();
        start = System.currentTimeMillis();
        for(int i = 0; i < keys.length; i++)
            A.search(keys[i]);
        end  = System.currentTimeMillis();
        System.out.println("Search with AVLDictionary: " + (end-start)/1000.0 +  "s ");
        
        System.gc();
        System.out.println("\n***** Delete Speed Test *****");
        start = System.currentTimeMillis();
        for(int i = 0; i < keys.length; i++)
            H.remove(keys[i]);
        end  = System.currentTimeMillis();
        System.out.println("Delete with HashMap:       " + (end-start)/1000.0 +  "s ");

        System.gc();
        start = System.currentTimeMillis();
        for(int i = 0; i < keys.length; i++)
            T.delete(keys[i]);
        end  = System.currentTimeMillis();
        System.out.println("Delete with HashTable:     " + (end-start)/1000.0 +  "s ");
    
        System.gc();
        start = System.currentTimeMillis();
        for(int i = 0; i < keys.length; i++)
            A.delete(keys[i]);
        end  = System.currentTimeMillis();
        System.out.println("Delete with AVLDictionary: " + (end-start)/1000.0 +  "s "); 
    }
}
