public class HuffmanNode implements Comparable{
    int frequency;
    char character;

    HuffmanNode right;
    HuffmanNode left;

    public HuffmanNode(char character, int frequency, HuffmanNode right, HuffmanNode left) {
        this.frequency = frequency;
        this.character = character;
        this.right = right;
        this.left = left;
    }

    @Override
    public int compareTo(Object o) {
        return this.frequency - ((HuffmanNode) o).frequency;
    }

    @Override
    public boolean equals(Object o) {
        return this.compareTo(o) == 0;
    }
}
