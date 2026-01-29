package uk.ac.cam.mr2083.sect10.academia;

public class Lecturer implements PromotableAcademicRank {
    private static final int BASE_PAY_RATE = 5;

    private int payRate = BASE_PAY_RATE;

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
        System.out.println("Exhaling slightly less information...");
    }

    @Override
    public void research() {
        System.out.println("Researching instead of sleeping...");
    }

    @Override
    public AcademicRank asImmutable() {
        return new LecturerRecord(this);
    }

    @Override
    public ConcreteAcademicRank promote() {
        return new Professor(this.payRate * 10);
    }
}
