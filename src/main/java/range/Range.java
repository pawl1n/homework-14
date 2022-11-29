package range;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Range implements Iterable<Integer> {
    private final int start;
    private final int end;

    public Range(int start, int end) {
        if (start > end) throw new IllegalArgumentException("The start cannot be higher than the end");

        this.start = start;
        this.end = end;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RangeIterator();
    }

    private class RangeIterator implements Iterator<Integer> {
        private int current;

        private RangeIterator() {
            current = start;
        }

        public boolean hasNext() {
            return current != end;
        }

        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();

            return current++;
        }
    }
}
