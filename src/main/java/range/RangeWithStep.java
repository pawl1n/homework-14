package range;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RangeWithStep implements Iterable<Integer> {
    private final int start;
    private final int end;
    private final int step;

    public RangeWithStep(int start, int end, int step) {
        if (start > end) throw new IllegalArgumentException("The start cannot be higher than the end");
        if (step < 1) throw new IllegalArgumentException("The step cannot be less than 1");

        this.start = start;
        this.end = end;
        this.step = step;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new RangeWithStepIterator();
    }

    private class RangeWithStepIterator implements Iterator<Integer> {
        private int current;

        private RangeWithStepIterator() {
            current = start;
        }

        @Override
        public boolean hasNext() {
            return current < end;
        }

        @Override
        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();

            int i = current;
            current += step;
            return i;
        }
    }
}
