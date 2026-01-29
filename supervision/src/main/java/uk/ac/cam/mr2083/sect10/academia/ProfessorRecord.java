package uk.ac.cam.mr2083.sect10.academia;

public class ProfessorRecord implements AcademicRank {
    private final Professor professor;

    public ProfessorRecord(Professor professor) {
        this.professor = professor;
    }

    @Override
    public int getPayRate() {
        return this.professor.getPayRate();
    }

    @Override
    public void lecture() {
        this.professor.lecture();
    }

    @Override
    public void research() {
        this.professor.research();
    }
}
