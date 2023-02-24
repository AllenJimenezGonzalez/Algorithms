package BitManipulationChapter;

public class BinaryToString {

    public static String toString(double num) {
        if (num >= 1 || num <= 0) return "ERROR";
        StringBuilder binary = new StringBuilder();
        binary.append(".");

        while (num > 0) {
            // if (binary.length() >= 32) return "ERROR";
            double r = num * 2;
            if (r >= 1) {
                binary.append(1);
                num = r - 1;
            } else {
                binary.append(0);
                num = r;
            }
        }


        return binary.toString();
    }

    public static String toStringMul(double num) {
        if (num >= 1 || num <= 0) return "ERROR";
        StringBuilder binary = new StringBuilder();

        num = num * 100;
        System.out.println(num);
        while (num > 0) {
            //if (binary.length() >= 32) return "ERROR";
            int r = (int) (num % 2);
            binary.append(r);

            num = Math.floor(num / 2);
            System.out.println(num);
        }
        binary.append(".");
        return binary.reverse().toString();
    }

    public static void main(String[] args) {
        double val = 0.72;
        System.out.println(toString(val));
        System.out.println(toStringMul(val));
    }


}
