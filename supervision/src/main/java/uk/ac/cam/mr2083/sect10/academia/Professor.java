package uk.ac.cam.mr2083.sect10.academia;

import java.time.Instant;
import java.util.Date;

public class Professor implements ConcreteAcademicRank {
    private static final int BASE_PAY_RATE = 250;
    private Date professorSince = Date.from(Instant.now());
    private int payRate = BASE_PAY_RATE;

    public Professor() {}

    public Professor(int payRate) {
        this.payRate = payRate;
    }

    public Professor(Date professorSince, int payRate) {
        this.professorSince = professorSince;
        this.payRate = payRate;
    }

    public Date getProfessorSince() {
        return this.professorSince;
    }

    @Override
    public int getPayRate() {
        return this.payRate;
    }

    public void setPayRate(int payRate) {
        if (payRate < 0) {
            throw new IllegalArgumentException("Pay rate cannot be negative.");
        }
        this.payRate = payRate;
    }

    @Override
    public void lecture() {
        System.out.println("Exhaling a textbook of information...");
    }

    @Override
    public void research() {
        System.out.println("Prodding lecturers to write papers...");
    }

    @Override
    public AcademicRank asImmutable() {
        return new ProfessorRecord(this);
    }
}

