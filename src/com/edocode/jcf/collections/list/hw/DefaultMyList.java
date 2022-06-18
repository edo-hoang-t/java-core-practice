package com.edocode.jcf.collections.list.hw;

import javax.management.NotificationEmitter;
import javax.print.attribute.standard.JobKOctets;
import java.util.Objects;

public class DefaultMyList implements MyList {

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
}
