package proj1b;

import uk.ac.cam.mr2083.proj.proj1b.Maximizer61B;
import uk.ac.cam.mr2083.proj.proj1b.ArrayDeque61B;

import org.junit.jupiter.api.*;

import java.util.Comparator;

import static com.google.common.truth.Truth.assertThat;

public class Maximizer61BTest {
    @Test
    public void maximiserTest() {
        Comparator<String> lengthComparator = Comparator.comparingInt(String::length);

        ArrayDeque61B<String> arrDeq = new ArrayDeque61B<>();
        assertThat(Maximizer61B.max(arrDeq, lengthComparator)).isNull();

        arrDeq.addFirst("Bart");
        arrDeq.addFirst("Artsy");
        arrDeq.addFirst("Max");
        arrDeq.addFirst("Min");
        assertThat(Maximizer61B.max(arrDeq, lengthComparator)).isEqualTo("Artsy");
        assertThat(Maximizer61B.max(arrDeq)).isEqualTo("Min");
    }

}
