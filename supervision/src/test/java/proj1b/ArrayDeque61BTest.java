package proj1b;

import uk.ac.cam.mr2083.proj.proj1b.ArrayDeque61B;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

public class ArrayDeque61BTest {
    @Test
    public void addTest1() {
        ArrayDeque61B<Integer> arrDeq = new ArrayDeque61B<>();
        assertThat(arrDeq.isEmpty()).isTrue();
        assertThat(arrDeq.size()).isEqualTo(0);

        arrDeq.addFirst(1);
        assertThat(arrDeq.toList()).containsExactly(1).inOrder();
        assertThat(arrDeq.isEmpty()).isFalse();
        assertThat(arrDeq.size()).isEqualTo(1);

        arrDeq.addFirst(2);
        assertThat(arrDeq.toList()).containsExactly(2, 1).inOrder();
        assertThat(arrDeq.size()).isEqualTo(2);

        arrDeq.addLast(3);
        assertThat(arrDeq.toList()).containsExactly(2, 1, 3).inOrder();
        assertThat(arrDeq.size()).isEqualTo(3);
    }

    @Test
    public void addTest2() {
        ArrayDeque61B<Integer> arrDeq = new ArrayDeque61B<>();
        assertThat(arrDeq.isEmpty()).isTrue();
        assertThat(arrDeq.size()).isEqualTo(0);

        arrDeq.addLast(1);
        assertThat(arrDeq.toList()).containsExactly(1).inOrder();
        assertThat(arrDeq.isEmpty()).isFalse();
        assertThat(arrDeq.size()).isEqualTo(1);

        arrDeq.addLast(2);
        assertThat(arrDeq.toList()).containsExactly(1, 2).inOrder();
        assertThat(arrDeq.size()).isEqualTo(2);

        arrDeq.addFirst(3);
        assertThat(arrDeq.toList()).containsExactly(3, 1, 2).inOrder();
        assertThat(arrDeq.size()).isEqualTo(3);
    }

    @Test
    public void addRemoveTest1() {
        ArrayDeque61B<Integer> arrDeq = new ArrayDeque61B<>();
        assertThat(arrDeq.isEmpty()).isTrue();
        assertThat(arrDeq.toList()).isEmpty();

        arrDeq.addFirst(1);
        assertThat(arrDeq.toList()).containsExactly(1).inOrder();
        assertThat(arrDeq.isEmpty()).isFalse();

        assertThat(arrDeq.removeFirst()).isEqualTo(1);
        assertThat(arrDeq.isEmpty()).isTrue();

        arrDeq.addLast(2);
        arrDeq.addFirst(4);
        arrDeq.addFirst(3);
        assertThat(arrDeq.toList()).containsExactly(3, 4, 2).inOrder();
        assertThat(arrDeq.isEmpty()).isFalse();

        assertThat(arrDeq.removeLast()).isEqualTo(2);
        assertThat(arrDeq.removeLast()).isEqualTo(4);
        assertThat(arrDeq.removeLast()).isEqualTo(3);

        arrDeq.addFirst(-1);
        arrDeq.addLast(-2);
        arrDeq.addFirst(-3);

        assertThat(arrDeq.toList()).containsExactly(-3, -1, -2).inOrder();
        assertThat(arrDeq.removeLast()).isEqualTo(-2);
        assertThat(arrDeq.removeFirst()).isEqualTo(-3);
        assertThat(arrDeq.removeFirst()).isEqualTo(-1);
        assertThat(arrDeq.removeFirst()).isNull();
    }

    @Test
    public void getTest() {
        ArrayDeque61B<Integer> arrDeq = new ArrayDeque61B<>();
        arrDeq.addFirst(1);
        arrDeq.addLast(2);
        arrDeq.addFirst(3);
        arrDeq.addLast(4);
        arrDeq.addFirst(5);
        arrDeq.addLast(6);

        assertThat(arrDeq.toList()).containsExactly(5, 3, 1, 2, 4, 6).inOrder();

        assertThat(arrDeq.get(0)).isEqualTo(5);
        assertThat(arrDeq.get(-1)).isNull();
        assertThat(arrDeq.get(3)).isEqualTo(2);
        assertThat(arrDeq.get(7)).isNull();

        assertThat(arrDeq.removeFirst()).isEqualTo(5);
        assertThat(arrDeq.get(0)).isEqualTo(3);
        assertThat(arrDeq.removeLast()).isEqualTo(6);
        assertThat(arrDeq.get(3)).isEqualTo(4);
    }

    @Test
    public void resizeTest1() {
        ArrayDeque61B<Integer> arrDeq = new ArrayDeque61B<>();

        for (int i = 0; i < 250; i++) {
            arrDeq.addFirst(i);
        }
        System.out.println(arrDeq);

        for (int i = 0; i < 250; i++) {
            assertThat(arrDeq.get(i)).isEqualTo(250 - i - 1);
        }

        for (int i = 0; i < 225; i++) {
            assertThat(arrDeq.removeLast()).isEqualTo(i);
        }
    }

    @Test
    public void resizeTest2() {
        ArrayDeque61B<Integer> arrDeq = new ArrayDeque61B<>();

        for (int i = 0; i < 500; i++) {
            arrDeq.addLast(i);
        }

        System.out.println(arrDeq);

        for (int i = 0; i < 500; i++) {
            assertThat(arrDeq.get(i)).isEqualTo(i);
        }

        for (int i = 0; i < 225; i++) {
            assertThat(arrDeq.removeFirst()).isEqualTo(i);
        }
    }

    @Test
    public void iteratorTest1() {
        ArrayDeque61B<String> arrDeq = new ArrayDeque61B<>();
        arrDeq.addFirst("Aardvark");
        arrDeq.addLast("Bear");
        arrDeq.addFirst("Creature");

        // this test works because Truth uses iterator under the hood
        assertThat(arrDeq).containsExactly("Creature", "Aardvark", "Bear").inOrder();
    }

    @Test
    public void equalsAndToStringTest() {
        ArrayDeque61B<Integer> arrDeq1 = new ArrayDeque61B<>();
        assertThat(arrDeq1.toString()).isEqualTo("[]");

        ArrayDeque61B<Integer> arrDeq2 = new ArrayDeque61B<>();
        assertThat(arrDeq2).isEqualTo(arrDeq1);

        arrDeq1.addFirst(1);
        assertThat(arrDeq1.toString()).isEqualTo("[1]");
        assertThat(arrDeq2).isNotEqualTo(arrDeq1);

        arrDeq2.addLast(1);
        assertThat(arrDeq2.toString()).isEqualTo("[1]");
        assertThat(arrDeq2).isEqualTo(arrDeq1);

        arrDeq2.addFirst(3);
        arrDeq2.addLast(2);
        assertThat(arrDeq2).isNotEqualTo(arrDeq1);
        assertThat(arrDeq2.toString()).isEqualTo("[3, 1, 2]");
    }
}
