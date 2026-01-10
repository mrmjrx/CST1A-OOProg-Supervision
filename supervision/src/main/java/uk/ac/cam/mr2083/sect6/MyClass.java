package uk.ac.cam.mr2083.sect6;

import java.util.Arrays;

public class MyClass implements Cloneable {
    private String mName;
    private int[] mData;

    // Copy constructor
    public MyClass ( MyClass toCopy ) {
        this.mName = toCopy.mName;
        this.mData = toCopy.mData.clone();
    }

    public MyClass( String name, int[] data) {
        this.mName = name;
        this.mData = data;
    }

    @Override
    public MyClass clone() {
        try {
            MyClass clone = (MyClass) super.clone();

            clone.mData = Arrays.copyOf(this.mData, this.mData.length);
            return clone;
        } catch (CloneNotSupportedException ignored) {
            throw new RuntimeException("MyClass parent not Cloneable");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof MyClass other)) return false;

        return other.mName.equals(this.mName) && Arrays.equals(other.mData, this.mData);
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int[] getmData() {
        return mData;
    }

    public void setmData(int[] mData) {
        this.mData = mData;
    }
}
