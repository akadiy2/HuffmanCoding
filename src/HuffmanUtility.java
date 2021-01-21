import java.io.File;
import java.util.Scanner;

public class HuffmanUtility {

    public static File promptInput(String[] args) {
        File f;

        if (args.length == 0) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter the full path to the file: ");
            f = new File(sc.nextLine());

        } else {
            f = new File(args[0]);
        }

        return f;
    }
}
