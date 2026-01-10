package uk.ac.cam.mr2083.sect6;

public class MyClass implements Cloneable {
    private String mName;
    private int[] mData;

    // Copy constructor
    public MyClass ( MyClass toCopy ) {
        this.mName = toCopy.mName;
        this.mData = toCopy.mData.clone();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        super.clone();
        return new MyClass(this);
    }
}
