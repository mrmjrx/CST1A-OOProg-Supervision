package uk.ac.cam.mr2083.sect1;

public final class LowestCommon {
    public static byte lowestCommon(long a, long b) {
        for (byte i = 0; i < 64; i++) {
            // only interested in set bits
            if (a == 0 || b == 0) {
                break;
            }

            // if the current LSB is equal, then a and b are both odd or both even
            if (a % 2 == b % 2) {
                return i;
            }

            // Binary shift a and b 1 to the right
            a >>= 1;
            b >>= 1;
        }

        return -1;
    }
}
