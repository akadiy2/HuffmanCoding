import java.util.Arrays;

public class RecursionPractice {

    public static void main (String [] args) {
        //String s = "20EE:FGb8:85a3:0:0:8A2E:0370:7334";
    //System.out.println(Arrays.toString(s.split(":")));
        //System.out.println(new RecursionPractice().validIPAddress(s));
        //System.out.println(new RecursionPractice().getTriNum(5));
        MyBinarySearchTree t = new MyBinarySearchTree();
        t.insert(45);
        t.insert(10);
        t.insert(7);
        t.insert(12);
        t.insert(90);
        t.insert(50);

        t.inorder();
        t.postorder();
    }

    public String validIPAddress(String IP) {

        if (isIPV4Address(IP)) {
            return "IPv4";
        }

        if (isIPV6Address(IP)) {
            return "IPv6";
        }

        return "Neither";

    }

    private boolean isIPV4Address(String IP) {
        String [] tokenizedIP = IP.split("\\.");

        if (IP.endsWith(".")) {
            return false;
        }


        if (tokenizedIP.length < 1) {
            return false;
        }

        for (String s : tokenizedIP) {

            int i = convertStringToInt(s);

            if (i < 0 || i > 255) {
                return false;
            }


            if (i < 10 && s.length() > 1) {
                return false;
            }


        }

        return true;

    }

    private boolean isIPV6Address(String IP) {
        String [] tokenizedIP = IP.split(":");

        if (IP.endsWith(":")) {
            return false;
        }

        if (tokenizedIP.length == 1) {
            return false;
        }

        for (String s : tokenizedIP) {

            if (s.length() < 1 || s.length() > 4) {
                return false;
            }

            for (Character c : s.toCharArray()) {
                if (!validHexadecimalCharacter(c)) {
                    return false;
                }
            }

        }

        return true;
    }

    private boolean validHexadecimalCharacter(char c) {
        System.out.println(c);
        return (c >= 97 && c <= 122) || (c >= 65 && c <= 90) || (c >= 48 && c <= 57);
    }

    private int convertStringToInt(String section) {
        int result = -1;

        try {
            result = Integer.parseInt(section);
        } catch (Exception e) {
            result = -1;
        }

        return result;
    }

    private int getTriNum(int i) {
        if (i == 1) {
            return 1;
        }

        return i + getTriNum(i - 1);
    }
}
