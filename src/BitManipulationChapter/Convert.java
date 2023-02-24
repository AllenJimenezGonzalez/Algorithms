package BitManipulationChapter;

public class Convert {

    public static int bitCounter(int num1, int num2) {
        int counter = 0;
        String bin1 = Integer.toBinaryString(num1);
        String bin2 = Integer.toBinaryString(num2);
        if (bin2.length() > bin1.length()) {
            int dif = bin2.length() - bin1.length();
            counter += dif;
            bin2 = bin2.substring(dif);
        }

        if (bin1.length() > bin2.length()) {
            int dif = bin1.length() - bin2.length();
            counter += dif;
            bin1 = bin1.substring(dif);
        }

        for (int i = 0; i < bin1.length(); i++) {
            if (bin1.charAt(i) != bin2.charAt(i)) counter++;
        }

        return counter;
    }

    public static int bitCounterXor(int a, int b) {
        int count = 0;
        int c = a ^ b;

        while (c != 0) {
            count += c & 1;
            c >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(bitCounter(29, 15));
        System.out.println(bitCounterXor(29, 15));
    }

}
