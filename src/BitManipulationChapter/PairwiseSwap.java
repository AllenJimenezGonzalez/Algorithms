package BitManipulationChapter;

public class PairwiseSwap {

    static int swap(int entry) {
        return (((entry & 0Xaaaaaaaa) >>> 1) | ((entry & 0X55555555) << 1));
    }

    public static void main(String[] args) {
        int entry = 99;
        System.out.println(0Xaaaaaaaa + " bin " + Integer.toBinaryString(0Xaaaaaaaa));
        System.out.println(0X55555555 + " bin " + Integer.toBinaryString(0X55555555));
        System.out.println(Integer.toBinaryString(entry));
        System.out.println(Integer.toBinaryString(swap(entry)));
    }
}
