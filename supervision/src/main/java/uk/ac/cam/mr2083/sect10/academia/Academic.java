package uk.ac.cam.mr2083.sect10.academia;

import java.time.Instant;
import java.util.Date;

public class Academic {
    private String name;
    private ConcreteAcademicRank rank;
    private Date dateEmployed;

    public Academic(String name, ConcreteAcademicRank rank) {
        this.name = name;
        this.rank = rank;
        this.dateEmployed = Date.from(Instant.now());
    }

    public Academic(String name, ConcreteAcademicRank rank, Date dateEmployed) {
        this.name = name;
        this.rank = rank;
        this.dateEmployed = dateEmployed;
    }

    public String getName() {
        return this.name;
    }

    public AcademicRank getRank() {
        return this.rank.asImmutable();
    }

    public int calculatePay(int hours) {
        return hours * this.rank.getPayRate();
    }

    public void lecture() {
        this.rank.lecture();
    }

    public void research() {
        this.rank.research();
    }

    public void promote() {
        if (!(this.rank instanceof PromotableAcademicRank promotable)) return;

        this.rank = promotable.promote();
    }
}
