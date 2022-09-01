package com.xue.test;

import java.util.Random;

public class RandomTest {


    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 1; i < 10; i++)
            for (int j = 1; j < 10; j++)
                System.out.println(r.nextInt(i));
    }
}
