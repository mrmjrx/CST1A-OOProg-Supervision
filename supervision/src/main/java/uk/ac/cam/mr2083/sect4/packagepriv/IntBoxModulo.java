package uk.ac.cam.mr2083.sect4.packagepriv;

public class IntBoxModulo {
    public static IntBox mod(IntBox box, int m) {
        IntBox newBox = new IntBox();
        newBox.val = box.val % m;
        return newBox;
    }
}
