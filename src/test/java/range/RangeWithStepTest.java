package range;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class RangeWithStepTest {

    @Test
    void shouldHaveNext() {
        // given
        int start = 0;
        int end = 1;
        int step = 1;

        // when
        RangeWithStep range = new RangeWithStep(start, end, step);

        // then
        assertThat(range.iterator().hasNext()).isTrue();
    }

    @Test
    void shouldNotHaveNext() {
        // given
        int start = 0;
        int end = 0;
        int step = 1;

        // when
        RangeWithStep range = new RangeWithStep(start, end, step);

        // then
        assertThat(range.iterator().hasNext()).isFalse();
    }

    @Test
    void shouldContainNumbers() {
        // given
        RangeWithStep range = new RangeWithStep(1, 10, 2);

        // when
        List<Integer> list = new ArrayList<>();
        range.iterator().forEachRemaining(list::add);

        // then
        assertThat(list).containsExactly(1, 3, 5, 7, 9);
    }

    @Test
    void shouldNotContainNumbers() {
        // given
        RangeWithStep range = new RangeWithStep(1, 1, 1);

        // when
        List<Integer> list = new ArrayList<>();
        range.iterator().forEachRemaining(list::add);

        // then
        assertThat(list).isEmpty();
    }

    @Test
    void shouldThrowIllegalArgumentException_WhenRangeIsInvalid() {
        // given
        int start = 1;
        int end = 0;
        int step = 1;

        // when
        Throwable thrown = catchThrowable(() -> new RangeWithStep(start, end, step));

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The start cannot be higher than the end");
    }

    @Test
    void shouldThrowIllegalArgumentException_WhenStepIsInvalid() {
        // given
        int start = 1;
        int end = 2;
        int step = 0;

        // when
        Throwable thrown = catchThrowable(() -> new RangeWithStep(start, end, step));

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The step cannot be less than 1");
    }

    @Test
    void shouldThrowNoSuchElementException() {
        // given
        RangeWithStep range = new RangeWithStep(0, 0, 10);

        // when
        Throwable thrown = catchThrowable(() -> range.iterator().next());

        // then
        assertThat(thrown).isInstanceOf(NoSuchElementException.class);
    }
}