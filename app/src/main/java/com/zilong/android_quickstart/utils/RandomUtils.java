package com.zilong.android_quickstart.utils;

import java.util.Random;

/**
 * Created by steven.wang on 21/10/16.
 */
public class RandomUtils {

    private static final Random r = new Random();

    public static float nextFloat(float min, float max){
        return min + r.nextFloat() * (max - min);
    }

    public static double nextDouble(double min, double max){
        return min + r.nextFloat() * (max - min);
    }

    public static String chars(int length) {
        StringBuilder sb = new StringBuilder();
        int data;
        for (int i = 0; i < length; i++) {
            int index = r.nextInt(2);
            switch (index) {
                case 0:
                    data = r.nextInt(26) + 65;
                    sb.append((char) data);
                    break;

                case 1:
                    data = r.nextInt(26) + 97;
                    sb.append((char) data);
                    break;
            }
        }
        return sb.toString();
    }
}