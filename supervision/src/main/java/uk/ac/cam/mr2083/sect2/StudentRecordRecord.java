package uk.ac.cam.mr2083.sect2;

public record StudentRecordRecord(
        String name, int age, String college
) {
    public void print() {
        System.out.println(name + " (" + age + ") - " + college);
    }
}

