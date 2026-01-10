package uk.ac.cam.mr2083.sect4.studentracker.v1;

public class Student {
    private int ticksPassed;

    public Student(int ticksPassed) {
        this.ticksPassed = ticksPassed;
    }

    public int getTicksPassed() {
        return ticksPassed;
    }

    public boolean pass() {
        return this.ticksPassed >= 20;
    }
}
