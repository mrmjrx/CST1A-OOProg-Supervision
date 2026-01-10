package uk.ac.cam.mr2083.sect4;

import uk.ac.cam.mr2083.sect4.packagepriv.MultipliableIntBox;

public class PackagePrivTest extends MultipliableIntBox {
    public void mod(int m) {
        /* The following would not compile due to the package-private modifier:
        val %= m;
         */
    }

    public static boolean isEven(MultipliableIntBox m) {
        /* The following would not
        return ((m.val & 1) == 0);
         */
        return false;
    }
}
