package core.basesyntax;

import java.util.Arrays;
import java.util.Objects;

public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int size;

    public ArrayList () {
        this.elementData = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public void add(T value) {
        if (elementData.length > size) {
            elementData[size++] = value;
        } else if (elementData.length == size) {
            growIfFull();
            elementData[size] = value;
            this.size++;
        }
    }

    @Override
    public void add(T value, int index) {
        if (index < 0 || index > size) {
            throw new ArrayListIndexOutOfBoundsException("The index passed to any of the methods " +
                    "is invalid.");
        }

        if (size == elementData.length) {
            growIfFull();
        }

        System.arraycopy(elementData, index, elementData, index + 1, size - index);

        elementData[index] = value;
        this.size++;
    }

    @Override
    public void addAll(List<T> list) {
        if (list == null) { throw new NullPointerException(); }
        int n = list.size();
        if (n == 0) {
            return;
        }
        while (elementData.length < size + n) {
            growIfFull();
        }
        for (int i = 0; i < n; i++) { elementData[size + i] = list.get(i); }
        size += n;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayListIndexOutOfBoundsException("The index passed to any of the methods " +
                    "is invalid.");
        }
        return (T) this.elementData[index];
    }

    @Override
    public void set(T value, int index) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public T remove(T element) {
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    private void growIfFull() {
        this.elementData = Arrays.copyOf(this.elementData, this.elementData.length
                + (this.elementData.length >> 1));
    }
}
