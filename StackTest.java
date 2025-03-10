import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.io.IOException;

import datastructure.list.Stack;
import datastructure.list.ArrayStack;
import datastructure.list.DoubleEndedList;
import java.util.NoSuchElementException;

public class StackTest {

    private static List<String> readCommands(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename), Charset.defaultCharset());

        // Parsing file formant
        for(String line: lines) {
            String[] cmd = line.split(" ");
            if(!cmd[0].equals("PUSH") && !cmd[0].equals("POP") && !cmd[0].equals("TOP"))
                throw new IOException("Invalid command in line: " + line);
            if((cmd[0].equals("PUSH") && cmd.length != 2) || (!cmd[0].equals("PUSH") && cmd.length != 1)) 
                throw new IOException("Invalid file format: " + line);
            if(cmd[0].equals("PUSH")) {
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
            System.err.println("Usage: StackTest <filename>\n");
            System.exit(0);
        }

        
        try {
            lines = readCommands(args[0]);
        } catch(Exception e) {
            System.err.println(e);
            System.exit(0);
        }

        //Stack<Integer> S = new ArrayStack<>();
        Stack<Integer> S = new DoubleEndedList<>();

        for(String l: lines) {
            String[] cmd = l.split(" ");
            Integer data;

            switch(cmd[0]) {
                case "PUSH":
                    data = Integer.parseInt(cmd[1]);
                    S.push(data);
                    System.out.println("Pushing " + data + "\n");
                    break;
                case "POP":
                    try {
                        data = S.pop();
                        System.out.println("Popping -> " + data + "\n");
                    } catch (NoSuchElementException e) {
                        System.out.println("Popping -> Empty stack\n");
                    }
                    break;
                case "TOP": 
                    try {
                        data = S.top();
                        System.out.println("Top -> " + data + "\n");
                    } catch (NoSuchElementException e) {
                        System.out.println("Top -> Empty stack\n");
                    }
                    break;
            }
            System.out.println("Number of elements: " + S.size());
            System.out.println(S);
            System.out.println("****************\n");
        }

    
    }
}
