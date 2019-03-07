package com.wins.dataStruct;

public class LinkedList<E> {

    /**
     * 尾节点
     */
    Node<E> tail;

    /**
     * 头结点
     */
    Node<E> head;

    private int size;

    private int modCount;

    /**
     * 添加头节点
     */
    public void linkedFirst(E ele) {
        if (ele == null) {
            throw new NullPointerException("ele is null");
        }
        Node<E> f = head;
        Node<E> node = new Node<E>(ele, null, f);
        head = node;
        if (f == null) {
            tail = node;
        } else {
            f.pre = node;
        }
        size++;
        modCount++;
    }

    /**
     * 添加尾节点
     * @param ele
     */
    public void linkedLast(E ele) {
        Node<E> t = tail;
        Node<E> node = new Node<E>(ele, t, null);
        tail = node;
        if (t == null) {
            head = node;
        } else {
            t.next = node;
        }
        size++;
        modCount++;
    }


    public E unLink(Node<E> e) {
        Node<E> pre = e.pre;
        Node<E> next = e.next;
        E obj = e.ele;
        pre.next = next;
        next.pre = pre;

        e.next=null;
        e.pre=null;

        return obj;
    }

    /**
     * 获取索引对象
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        return  node(index).ele;
    }

    public int indexOf(Object e) {
        int index = 0;
        if (e == null) {
            for (Node<E> node = head; node != null; node = node.next) {
                if (node.ele == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> node = head; node != null; node = node.next) {
                if (e.equals(node.ele)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    public Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> node = head;
            //从前面遍历
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            //从后面遍历
            Node<E> node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.pre;
            }
            return node;
        }
    }

    /**
     * 反转链表
     */
    public static <E> LinkedList<E> reverseLinkedList(LinkedList<E> list) {

        Node<E> pre = null;

        for (Node<E> now = list.head; now != null;){
            //下一节点
            Node<E> next = now.next;
            now.next = pre;
            pre = now;
            now = next;

        }

        list.head = pre;
        return list;
    }


    public void diplay() {

        StringBuilder sb = new StringBuilder();
        for (Node<E> node = head; node != null; ){
            sb.append(node.ele);
            node=node.next;
            if (node != null) {
                sb.append("---->");
            }
        }
        System.out.println(sb.toString());

    }










    /**
     * 节点
     */
    private static class Node<E>{

        E ele;

        Node<E> pre;

        Node<E> next;

        public Node(E value, Node<E> pre, Node<E> next) {
            this.ele = value;
            this.pre = pre;
            this.next = next;
        }
    }

}
