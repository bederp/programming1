package pl.beder;

import java.util.Arrays;

public class StaticTable implements Table {

    private long[] holder = new long[1_000_000];
    private int size = 0;

    @Override
    public long size() {
        return size;
    }

    @Override
    public long get(int index) {
        return holder[index];
    }

    @Override
    public int firstIndexWith(long value) {
        int index = -1;

        for (int i = 0; i < size ; i++) {
            if (holder[i] == value) {
                return i;
            }
        }

        return index;
    }

    @Override
    public int firstIndexWithGivenOrHigherValue(long value) {
        int index = firstIndexWith(value);

        if (index != -1) {
            return index;
        }

        for (int i = 0; i < size ; i++) {
            if (holder[i] > value) {
                return i;
            }
        }

        return size;
    }

    @Override
    public void insertAt(int index, long value) {

        //TODO - check if we have space to insert this element

        for (int i = size - 1; i >= index ; i--) {
            holder[i + 1] = holder[i];
        }
        holder[index] = value;
        size++;
    }

    @Override
    public void insertSorted(long value) {
        int index = firstIndexWithGivenOrHigherValue(value);
        insertAt(index, value);
    }

    long[] getHolderView() {
        return Arrays.copyOfRange(holder, 0, size);
    }
}
