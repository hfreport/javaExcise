package com.wins.leetcode;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 */
public class MinStack {

    private Node[] eData;

    private int initCap = 10;

    private int size;

    /** initialize your data structure here. */
    public MinStack() {
        this.eData = new Node[initCap];
    }

    public void push(int x) {
        grow(size+1);
        int minV;
        int maxV;
        int min;
        if (size > 0) {
            Node pre = eData[size-1];
            minV = pre.getMinValue();
            maxV = pre.getValue();
            min = minV;
            if (x < min) {
                min = x;
            }
            if (maxV < min) {
                min = maxV;
            }
        } else {
            min = x;
        }
        eData[size++] = new Node(x, min);
    }

    public void pop() {
        eData[size-1] = null;
        size--;
    }

    public int top() {
        Node n = eData[size-1];
        return null != n?n.getValue():0;
    }

    public int getMin() {
        Node n = eData[size-1];
        return n.getMinValue();
    }

    private void grow(int minCap) {
        if (minCap - eData.length > 0) {
            //grow
            int oldCap = eData.length;
            int newCap = oldCap + oldCap;
            Node[] newObj = new Node[newCap];
            for (int i = 0; i < eData.length; i++) {
                newObj[i] = eData[i];
            }
            this.eData = newObj;
        }
    }

    class Node {

        private int value;

        private int minValue;

        public Node(int value, int minValue) {
            this.value = value;
            this.minValue = minValue;
        }

        private int getMinValue () {
            return this.minValue;
        }
        private void setMinValue (int minValue) {
            this.minValue = minValue;
        }
        private int getValue () {
            return this.value;
        }
        private void setValue (int value) {
            this.value = value;
        }
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }
}
