package BitManipulationChapter;

public class FlipBitToWin {

    public static int getLongestBitChain(int number) {
        String chain = Integer.toBinaryString(number);
        System.out.println(chain);
        char[] bits = chain.toCharArray();

        int actualCount = 0;
        int longestCount = 0;
        int savedOnesFromLastZero = 1;
        boolean inUseCredit = false;

        for (int index = 0; index < bits.length; index++) {
            if (bits[index] == '1') {
                actualCount++;
                if (inUseCredit) savedOnesFromLastZero++;
            }

            if (bits[index] == '0') {
                if (index + 1 < bits.length) {
                    if (bits[index + 1] == '1') {
                        if (inUseCredit) {
                            longestCount = Math.max(longestCount, actualCount);
                            actualCount = savedOnesFromLastZero;
                            savedOnesFromLastZero = 1;
                        } else {
                            actualCount++;
                            inUseCredit = true;
                        }
                    } else {
                        savedOnesFromLastZero = 1;
                        inUseCredit = false;
                        longestCount = Math.max(longestCount, actualCount);
                        actualCount = 0;
                    }
                }
            }

        }

        longestCount = Math.max(longestCount, actualCount);

        return longestCount;
    }

    public static void main(String[] args) {
        System.out.println(getLongestBitChain(1775)); //8
        System.out.println(getLongestBitChain(1000)); //7
        System.out.println(getLongestBitChain(43535)); //5
        System.out.println(getLongestBitChain(64839)); //8
        System.out.println(getLongestBitChain(0B0011111101101111001111011111)); //10
        System.out.println(getLongestBitChain(0B0011110110111110111101)); //10
        System.out.println(getLongestBitChain(0B0011110111101111110101)); //11
    }
}
