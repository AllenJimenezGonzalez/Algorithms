package BitManipulationChapter;

public class Insertion {


    public static int insert(int n, int m, int j, int i) {
        if (i > j || i < 0 || j >= 32) return 0;
        int allOnes = ~0;
        int leftMaskSide = j < 31 ? (allOnes << (j + 1)) : 0;
        int rightMaskSide = ((1 << i) - 1);
        int mask = n & (rightMaskSide | leftMaskSide);
        int insertBits = m << i;
        return mask | insertBits;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(insert(0B10000000000, 0B10011, 6, 2)));
    }
}
