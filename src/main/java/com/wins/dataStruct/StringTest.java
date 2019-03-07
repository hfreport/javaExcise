package com.wins.dataStruct;

public class StringTest {

    public static void main(String[] args) {

        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;
        String e = d + 2;

        String a1 = "h";

        a1 += "e" + "l" +"l";

        System.out.println(a1);

        System.out.println((a == c));
        System.out.println((a == e));

        System.out.println(e);
    }
}
