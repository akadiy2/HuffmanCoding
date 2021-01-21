import java.io.*;
import java.util.*;

public class CreateTree {
    private static String input = "";

    public static void main(String[] args) throws Exception {

        File f = HuffmanUtility.promptInput(args);

        BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
        StringBuilder sb = new StringBuilder();
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            sb.append(str);
        }

        input = sb.toString();

        createTree();
    }

    private static void createTree() throws IOException {
        Map<Character, Integer> charToFrequency = new HashMap<>();
        Set<Character> distinct = new HashSet<>();


        for (Character c : input.toCharArray()) {
            distinct.add(c);
            if (charToFrequency.containsKey(c)) {
                int count = charToFrequency.get(c);
                charToFrequency.put(c, ++count);
            } else {
                charToFrequency.put(c, 1);
            }
        }

        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>();

        for (Map.Entry<Character, Integer> entry : charToFrequency.entrySet()) {
            char c = entry.getKey();
            HuffmanNode node = new HuffmanNode(c, charToFrequency.get(c), null, null);
            queue.add(node);
        }

        while (queue.size() != 1) {
            HuffmanNode x = queue.poll();
            HuffmanNode y = queue.poll();

            assert (y != null);

            int frequency = x.frequency + y.frequency;
            HuffmanNode z = new HuffmanNode('\u0000', frequency, y, x);
            queue.add(z);

        }


        HuffmanNode n = queue.peek();
        System.out.println("Printing Tree InOrder");
        printTreeInOrder(n);
        System.out.println();


        System.out.println("Printing Tree PostOrder");
        printTreePostOrder(n);

        System.out.println();

        System.out.println("Printing Tree PreOrder");
        printTreePreOrder(n);

        System.out.println();

        for (Character c : distinct) {
            printCodes(n, "", c);
        }

    }


    private static void printTreeInOrder(HuffmanNode node) {

        if (node != null) {
            printTreeInOrder(node.left);
            System.out.print((node.character == '\u0000' ? "" : node.character) + "->" + node.frequency + " ");
            printTreeInOrder(node.right);

        }
    }

    private static void printTreePreOrder(HuffmanNode node) {

        if (node != null) {
            System.out.print((node.character == '\u0000' ? "" : node.character) + "->" + node.frequency + " ");
            printTreePreOrder(node.left);
            printTreePreOrder(node.right);
        }
    }

    private static void printTreePostOrder(HuffmanNode node) {

        if (node != null) {
            printTreePostOrder(node.left);
            printTreePostOrder(node.right);
            System.out.print((node.character == '\u0000' ? "" : node.character) + "->" + node.frequency + " ");
        }
    }

    private static void printCodes(HuffmanNode node, String str, char c) {
        if (node.left == null && node.right == null && Character.isLetter(node.character) && node.character == c) {
            System.out.println(c + ":" + str);
            return;
        }

        if (node.left != null) {
            printCodes(node.left, str + "0", c);
        }

        if (node.right != null) {
            printCodes(node.right, str + "1", c);
        }
    }
}
