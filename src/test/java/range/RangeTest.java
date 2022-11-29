package range;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class RangeTest {

    @Test
    void shouldHaveNext() {
        // given
        int start = 0;
        int end = 1;

        // when
        Range range = new Range(start, end);

        // then
        assertThat(range.iterator().hasNext()).isTrue();
    }

    @Test
    void shouldNotHaveNext() {
        // given
        int start = 0;
        int end = 0;

        // when
        Range range = new Range(start, end);

        // then
        assertThat(range.iterator().hasNext()).isFalse();
    }

    @Test
    void shouldContainNumbers() {
        // given
        Range range = new Range(1, 10);

        // when
        List<Integer> list = new ArrayList<>();
        range.iterator().forEachRemaining(list::add);

        // then
        assertThat(list).containsExactly(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    void shouldNotContainNumbers() {
        // given
        Range range = new Range(1, 1);

        // when
        List<Integer> list = new ArrayList<>();
        range.iterator().forEachRemaining(list::add);

        // then
        assertThat(list).isEmpty();
    }

    @Test
    void shouldThrowIllegalArgumentException() {
        // given
        int start = 1;
        int end = 0;

        // when
        Throwable thrown = catchThrowable(() -> new Range(start, end));

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The start cannot be higher than the end");
    }

    @Test
    void shouldThrowNoSuchElementException() {
        // given
        Range range = new Range(0, 0);

        // when
        Throwable thrown = catchThrowable(() -> range.iterator().next());

        // then
        assertThat(thrown).isInstanceOf(NoSuchElementException.class);
    }
}