import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.io.IOException;

import datastructure.list.Queue;
import datastructure.list.ArrayQueue;
import datastructure.list.DoubleEndedList;
import java.util.NoSuchElementException;

public class QueueTest {

    private static List<String> readCommands(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename), Charset.defaultCharset());

        // Parsing file format
        for(String line: lines) {
            String[] cmd = line.split(" ");
            if(!cmd[0].equals("ENQUEUE") && !cmd[0].equals("DEQUEUE") && !cmd[0].equals("FIRST"))
                throw new IOException("Invalid command in line: " + line);
            if((cmd[0].equals("ENQUEUE") && cmd.length != 2) || (!cmd[0].equals("ENQUEUE") && cmd.length != 1)) 
                throw new IOException("Invalid file format: " + line);
            if(cmd[0].equals("ENQUEUE")) {
                try {
                    Integer.parseInt(cmd[1]);
                } catch(Exception e) {
                    throw new IOException("Invalid key format: " + line);
                }
            }
        }
        return lines;
    } 

    public static void main(String args[]) {
        List<String> lines = null;

        if(args.length != 1) {
            System.err.println("Usage: QueueTest <filename>\n");
            System.exit(0);
        }

        
        try {
            lines = readCommands(args[0]);
        } catch(Exception e) {
            System.err.println(e);
            System.exit(0);
        }

        //Queue<Integer> Q = new ArrayQueue<>();
        Queue<Integer> Q = new DoubleEndedList<>();

        for(String l: lines) {
            String[] cmd = l.split(" ");
            Integer data;

            switch(cmd[0]) {
                case "ENQUEUE":
                    data = Integer.parseInt(cmd[1]);
                    Q.enqueue(data);
                    System.out.println("Enqueuing " + data + "\n");
                    break;
                case "DEQUEUE":
                    try {
                        data = Q.dequeue();
                        System.out.println("Dequeuing -> " + data + "\n");
                    } catch (NoSuchElementException e) {
                        System.out.println("Dequeuing -> Empty queue\n");
                    }
                    break;
                case "FIRST": 
                    try {
                        data = Q.first();
                        System.out.println("First -> " + data + "\n");
                    } catch (NoSuchElementException e) {
                        System.out.println("First -> Empty queue\n");
                    }
                    break;
            }
            System.out.println("Number of elements: " + Q.size());
            System.out.println(Q);
            System.out.println("****************\n");
        }

    
    }
}
