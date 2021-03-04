package nowcoder;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 *
 * If you define many classes, but you must have a class named Main and a public property.
 * The Main class should be the only public class.
 * The Main class must contain a static method (function) named "main"
 * Do not add any package, like "package main"
 *
 * The TestCase is shown below
 * Input : 1 2
 * Output : 3
 */

/**
 * 运行时输出不能有其他内容
 */
public class ByteDanceDemo {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to online interview system of Acmcoder.");
        strings.add("This system is running Java 8.");

        for (String string : strings) {
            System.out.println(string);
        }

        int a, b;
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            a = in.nextInt();
            b = in.nextInt();
            System.out.printf("Your result is : %d\n", a + b);
        }
    }
}
