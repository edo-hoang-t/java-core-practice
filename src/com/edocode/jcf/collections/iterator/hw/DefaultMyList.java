package com.edocode.jcf.collections.iterator.hw;

import com.edocode.jcf.collections.list.hw.MyList;
import com.edocode.jcf.collections.iterator.hw.ListIterable;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DefaultMyList implements MyList, ListIterable {

    private static class Node {
        Object data;
        Node prev;
        Node next;

        Node(Object data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

        Node(Node prev, Object data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    private Node first;
    private Node last;
    private int size;

    {
        first = null;
        last = null;
        size = 0;
    }

    private Object unlink(Node cur) {
        Node prev = cur.prev;
        Node next = cur.next;
        Object data = cur.data;

        if (prev == null) { // cur is first node
            first = next;
        } else {
            prev.next = next;
            cur.prev = null;
        }

        if (next == null) { // cur is last node
            last = prev;
        } else {
            next.prev = prev;
            cur.next = null;
        }

        cur.data = null;
        size--;
        return data;
    }

    @Override
    public void add(Object e) {
        Node lastNode = last;
        Node newNode = new Node(lastNode, e, null);

        if (lastNode != null) lastNode.next = newNode;
        else first = newNode;

        last = newNode;
    }

    @Override
    public void clear() {
        for (Node cur = first; cur != null; ) {
            Node next = cur.next;
            cur.prev = null;
            cur.data = null;
            cur.next = null;
            cur = next;
        }
        first = null;
        last = null;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) return false;

        for (Node cur = first; cur != null; cur = cur.next) {
            if (cur.data.equals(o)) {
                unlink(cur);
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] res = new Object[size];
        int i = 0;

        for (Node cur = first; cur != null; cur = cur.next) {
            res[i++] = cur.data;
        }
        return res;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) return false;
        for (Node cur = first; cur != null; cur = cur.next) {
            if (cur.data.equals(o)) return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(MyList c) {
        Object[] objs = c.toArray();

        for (Object obj : objs) {
            if (!contains(obj)) return false;
        }
        return true;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {
        Node cur = first;
        boolean nextCalled = false;

        public boolean hasNext() {
            return cur != null;
        }

        public Object next() {
            if (cur == null) throw new NoSuchElementException();

            Object res = cur.data;
            cur = cur.next;
            nextCalled = true;
            return res;
        }

        public void remove() {
            if (!nextCalled) throw new IllegalStateException();

            Node target = cur.prev;
            DefaultMyList.this.unlink(target);
            nextCalled = false;
        }
    }

    public ListIterator listIterator() {
        return new ListIteratorImpl();
    }

    private class ListIteratorImpl extends IteratorImpl implements ListIterator {
        Node reversedCur = last;
        boolean prevCalled = false;

        @Override
        public boolean hasPrevious() {
            return reversedCur != null;
        }

        @Override
        public Object previous() {
            if (reversedCur == null) throw new NoSuchElementException();
            Object res = reversedCur.data;
            reversedCur = reversedCur.prev;
            nextCalled = false;
            prevCalled = true;
            return res;
        }

        @Override
        public Object next() {
            if (cur == null) throw new NoSuchElementException();

            Object res = cur.data;
            cur = cur.next;
            prevCalled = false;
            nextCalled = true;
            return res;
        }

        @Override
        public void set(Object e) {
            if (!nextCalled && !prevCalled) throw new IllegalStateException();

            Node target;
            if (nextCalled) target = cur.prev;
            else target = cur.next;
            target.data = e;
            nextCalled = false;
            prevCalled = false;
        }

        @Override
        public void remove() {
            if (!nextCalled && !prevCalled) throw new IllegalStateException();

            Node target;
            if (nextCalled) target = cur.prev;
            else target = cur.next;
            DefaultMyList.this.unlink(target);
            nextCalled = false;
            prevCalled = false;
        }
    }


}
