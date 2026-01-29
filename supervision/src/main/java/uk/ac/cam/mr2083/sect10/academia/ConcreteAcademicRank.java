package uk.ac.cam.mr2083.sect10.academia;

public interface ConcreteAcademicRank extends AcademicRank {
    void setPayRate(int payRate);

    AcademicRank asImmutable();
}
