import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.io.IOException;

import datastructure.tree.BinarySearchTree;
import datastructure.tree.AVLTree;
import datastructure.dictionary.AVLDictionary;

public class TreeTest {

    private static List<String> readCommands(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename), Charset.defaultCharset());

        // Parsing file formant
        for(String line: lines) {
            String[] cmd = line.split(" ");
            if(!cmd[0].equals("INSERT") && !cmd[0].equals("DELETE") && !cmd[0].equals("SEARCH"))
                throw new IOException("Invalid command in line: " + line);
            if((cmd.length != 2 && cmd.length != 3) || (!cmd[0].equals("INSERT") && cmd.length == 3)) 
                throw new IOException("Invalid file format: " + line);
            try {
                Integer.parseInt(cmd[1]);
            } catch(Exception e) {
                throw new IOException("Invalid key format: " + line);
            }
        }
        return lines;
    } 

    private static void printkeys(datastructure.list.List<Integer> L) {
        for(Integer key: L)
            System.out.print(key.toString() + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        List<String> lines = null;

        if(args.length != 1) {
            System.err.println("Usage: TreeTest <filename>\n");
            System.exit(0);
        }

        
        try {
            lines = readCommands(args[0]);
        } catch(Exception e) {
            System.err.println(e);
            System.exit(0);
        }

        BinarySearchTree<Integer,String> T = new BinarySearchTree<>();
        //AVLTree<Integer,String> T = new AVLTree<>();  

        for(String l: lines) {
            String[] cmd = l.split(" ");
            Integer key  = Integer.parseInt(cmd[1]); 
            String  data;

            switch(cmd[0]) {
                case "INSERT":
                    data = cmd.length == 3 ? cmd[2] : null;
                    T.insert(key,data);
                    System.out.println("Inserting (" + key + "," + (data == null ? "null" : data) + ")\n");
                    break;
                case "SEARCH": 
                    data = T.search(key);
                    System.out.println("Searching " + key + " -> " + (data == null ? "null" : data) + "\n");
                    break;
                case "DELETE":
                    data = T.delete(key);
                    System.out.println("Deleting " + key +  " -> " + (data == null ? "null" : data) + "\n");
                    break;
            }
            System.out.println("Number of elements: " + T.size() + "\n");
            System.out.print(T);
            System.out.print("\n Preorder traversal: ");
            printkeys(T.getPreorderKeys());
            System.out.print("Postorder traversal: ");
            printkeys(T.getPostorderKeys());
            System.out.print("  Inorder traversal: ");
            printkeys(T.getInorderKeys());
            System.out.print("      BFS traversal: ");
            printkeys(T.getBFSKeys());
            System.out.println("****************\n");
        }
    
    }
}
