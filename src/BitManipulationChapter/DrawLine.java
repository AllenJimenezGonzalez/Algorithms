package BitManipulationChapter;

import java.util.Arrays;

public class DrawLine {

    public static byte[] drawLine(byte[] screen, int width, int x1, int x2, int y) {
        int startOffset = x1 % 8;
        int firstFullByte = x1 / 8;
        if (startOffset != 0) {
            firstFullByte++;
        }

        int endOffset = x2 % 8;
        int lastFullByte = x2 / 8;
        if (endOffset != 7) {
            lastFullByte--;
        }

        for (int b = firstFullByte; b <= lastFullByte; b++) {
            screen[(width / 8) * y + b] = (byte) 0xFF;
        }

        byte startMask = (byte) (0xFF >> startOffset);
        byte endMask = (byte) (0xFF >> (endOffset + 1));

        if ((x1 / 8) == (x2 / 8)) {
            byte mask = (byte) (startMask & endMask);
            screen[(width / 8) * y + (x1 / 8)] |= mask;
        } else {
            if (startOffset != 0) {
                int byteNumber = (width / 8) * y + firstFullByte - 1;
                screen[byteNumber] |= startMask;
            }
            if (endOffset != 7) {
                int byteNumber = (width / 8) * y + lastFullByte + 1;
                screen[byteNumber] |= endMask;
            }
        }
        System.out.println(Arrays.toString(screen));
        return screen;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(drawLine(new byte[]{10, 10, 10, 10}, 10, 3, 7, 3)));
    }
}
