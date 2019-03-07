package com.wins.dataStruct;

public class DataStructTest {

    public static void main(String[] args) {

        LinkedList<String> data = new LinkedList<String>();

        data.linkedFirst("9");
        data.linkedFirst("8");
        data.linkedFirst("7");
        data.linkedFirst("6");
        data.linkedFirst("5");
        data.linkedFirst("4");
        data.linkedFirst("3");
        data.linkedFirst("2");
        data.linkedFirst("1");




//        System.out.println(data.get(4));
//        data.diplay();

//        data.unLink(data.node(3));

        LinkedList.reverseLinkedList(data);

        data.diplay();

    }
}
