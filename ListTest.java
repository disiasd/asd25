import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.io.IOException;

import datastructure.list.ArrayList;
import datastructure.list.DoubleEndedList;

public class ListTest {

    private static List<String> readCommands(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename), Charset.defaultCharset());

        // Parsing file formant
        for(String line: lines) {
            String[] cmd = line.split(" ");
            if(!cmd[0].equals("INSERT") && !cmd[0].equals("APPEND") && !cmd[0].equals("SEARCH") && 
               !cmd[0].equals("DELETE") && !cmd[0].equals("SET") && !cmd[0].equals("GET"))
                throw new IOException("Invalid command in line: " + line);
            if(cmd.length != 2) 
                throw new IOException("Invalid file format: " + line);
            try {
                Integer.parseInt(cmd[1]);
            } catch(Exception e) {
                throw new IOException("Invalid key format: " + line);
            }
        }
        return lines;
    } 

    public static void main(String args[]) {
        List<String> lines = null;

        if(args.length != 1) {
            System.err.println("Usage: ListTest <filename>\n");
            System.exit(0);
        }

        
        try {
            lines = readCommands(args[0]);
        } catch(Exception e) {
            System.err.println(e);
            System.exit(0);
        }

        //ArrayList<Integer> L = new ArrayList<>();
        DoubleEndedList<Integer> L = new DoubleEndedList<>();

        for(String l: lines) {
            String[] cmd = l.split(" ");
            Integer data = Integer.parseInt(cmd[1]); 

            switch(cmd[0]) {
                case "INSERT":
                    L.insert(data);
                    System.out.println("Inserting " + data + "\n");
                    break;
                case "APPEND":
                    L.append(data);
                    System.out.println("Appending " + data + "\n");
                    break;
                case "SEARCH": 
                    boolean bool = L.search(data);
                    System.out.println("Searching " + data + " -> " + bool + "\n");
                    break;
                case "DELETE":
                    L.delete(data);
                    System.out.println("Deleting " + data + "\n");
                    break;
            }
            System.out.println("Number of elements: " + L.size());
            System.out.println(L);
            System.out.println("****************\n");
        }

    
    }
}
