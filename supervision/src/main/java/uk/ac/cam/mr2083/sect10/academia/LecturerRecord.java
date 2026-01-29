package uk.ac.cam.mr2083.sect10.academia;

public class LecturerRecord implements AcademicRank {
    private final Lecturer lecturer;

    public LecturerRecord(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    @Override
    public int getPayRate() {
        return this.lecturer.getPayRate();
    }

    @Override
    public void lecture() {
        this.lecturer.lecture();
    }

    @Override
    public void research() {
        this.lecturer.research();
    }
}
