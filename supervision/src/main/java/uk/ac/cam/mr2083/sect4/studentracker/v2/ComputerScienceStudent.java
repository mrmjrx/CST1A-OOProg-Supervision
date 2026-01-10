package uk.ac.cam.mr2083.sect4.studentracker.v2;

public class ComputerScienceStudent extends Student {
    public ComputerScienceStudent(int ticksPassed) {
        super(ticksPassed);
    }

    @Override
    public boolean pass() {
        return this.getTicksPassed() >= 20;
    }
}
