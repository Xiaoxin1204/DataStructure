package com.xiaoxin;


import com.xiaoxin.printer.BinaryTreeInfo;

import java.util.Comparator;

public class BinaryHeap<E> extends AbstractHeap<E> implements BinaryTreeInfo {
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public BinaryHeap(Comparator<E> comparator) {
        this(null, comparator);
    }

    public BinaryHeap() {
        this(null, null);
    }

    public BinaryHeap(E[] elements, Comparator<E> comparator) {
        super(comparator);
        if (elements == null || elements.length == 0) {
            this.elements = (E[]) new Object[DEFAULT_CAPACITY];
        } else {
            size = elements.length;
            int capacity = Math.max(elements.length,DEFAULT_CAPACITY);
            this.elements = (E[]) new Object[capacity];
            System.arraycopy(elements, 0, this.elements, 0, elements.length);
            heapify();
        }
    }

    private void heapify() {
        //自上而下的上滤（效率低）

        //自下而上的下滤
        for (int i = (size >> 1) - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    public BinaryHeap(E[] elements) {
        this(elements, null);
    }

    @Override
    public void clean() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public void add(E element) {
        elementNotNullCheck(element);
        ensureCapacity(size + 1);
        elements[size++] = element;
        siftUp(size - 1);

    }

    private void siftUp(int index) {
//        E e = elements[index];
//        while (index > 0) {
//            int pindex = (index - 1) >> 1;
//            E p = elements[pindex];
//            if (compare(e, p) <= 0) return;
//            E tmp = elements[index];
//            elements[index] = elements[pindex];
//            elements[pindex] = tmp;
//            index = pindex;
//        }
        E e = elements[index];
        while (index > 0) {
            int pindex = (index - 1) >> 1;
            E p = elements[pindex];
            if (compare(e, p) <= 0) break;
            elements[index] = p;
            index = pindex;
        }
        elements[index] = e;
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    @Override
    public E get() {
        emptyCheck();
        return elements[0];
    }

    private void emptyCheck() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("Heap is empty");
        }
    }

    @Override
    public E remove() {
        E root = elements[0];
        elements[0] = elements[size - 1];
        elements[size - 1] = null;
        size--;
        siftDown(0);
        return root;
    }

    private void siftDown(int index) {
        E element = elements[index];
        int half = size >> 1;
        while (index < half) {
            //默认与左子节点比较
            int childIndex = (index << 1) + 1;
            E child = elements[childIndex];
            //右子节点
            int rightIndex = childIndex + 1;
            //选出左右子节点最大的那个
            if (rightIndex < size && compare(elements[rightIndex], child) > 0) {
                childIndex = rightIndex;
                child = elements[rightIndex];
            }
            if (compare(element, child) >= 0) break;
            //将子节点放到index位置
            elements[index] = child;
            //重新设置index
            index = childIndex;
        }
        elements[index] = element;
    }

    @Override
    public E replace(E element) {
        elementNotNullCheck(element);
        E root = null;
        if (size == 0) {
            elements[0] = element;
            size++;
        } else {
            root = elements[0];
            elements[0] = element;
            siftDown(0);
        }
        return root;
    }


    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity > capacity) return;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        if (size >= 0) System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    @Override
    public Object root() {
        return 0;
    }

    @Override
    public Object left(Object node) {
        Integer index = (Integer) node;
        index = (index << 1) + 1;
        return index >= size ? null : index;
    }

    @Override
    public Object right(Object node) {
        Integer index = (Integer) node;
        index = (index << 1) + 2;
        return index >= size ? null : index;
    }

    @Override
    public Object string(Object node) {
        Integer index = (Integer) node;
        return elements[index];
    }
}
