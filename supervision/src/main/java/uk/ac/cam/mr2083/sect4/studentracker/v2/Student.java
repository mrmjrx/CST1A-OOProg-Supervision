package uk.ac.cam.mr2083.sect4.studentracker.v2;

public abstract class Student {
    private int ticksPassed;

    public Student(int ticksPassed) {
        this.ticksPassed = ticksPassed;
    }

    public int getTicksPassed() {
        return ticksPassed;
    }

    public abstract boolean pass();
}
