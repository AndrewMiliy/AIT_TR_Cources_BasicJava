package Lesson_30_HW_01;

import java.util.Arrays;

public class ElasticArray<T> {
    private Object[] elements;
    private int size;

    public ElasticArray() {
        elements = new Object[10];
        size = 0;
    }

    // Add an element
    public void add(T element) {
        if (size == elements.length) {
            increaseSize();
        }
        elements[size++] = element;
    }

    // Get an element by index
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) elements[index];
    }

    // Remove an element by index
    public T remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T element = (T) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;

        return element;
    }

    // Get the size of the array
    public int size() {
        return size;
    }

    // Private method to increase the size of the array when needed
    private void increaseSize() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
}


