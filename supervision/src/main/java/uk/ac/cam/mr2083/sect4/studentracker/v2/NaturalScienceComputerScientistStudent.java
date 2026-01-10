package uk.ac.cam.mr2083.sect4.studentracker.v2;

public class NaturalScienceComputerScientistStudent extends Student {
    public NaturalScienceComputerScientistStudent(int ticksPassed) {
        super(ticksPassed);
    }

    @Override
    public boolean pass() {
        return this.getTicksPassed() >= 10;
    }
}
