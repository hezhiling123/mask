package cn.hezhiling.core.utils;

import java.util.UUID;

public class UUIDGenerator {
    private UUIDGenerator() {
    }

    public static String getUUID() {
        String s = UUID.randomUUID().toString();
        return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
    }

    public static String[] getUUID(int number) {
        if (number < 1) {
            return null;
        }
        String[] ss = new String[number];
        for (int i = 0; i < number; i++) {
            ss[i] = getUUID();
        }
        return ss;
    }

    public static String getSerialId() {
        String s = UUID.randomUUID().toString();
        return s.substring(0, 16);
    }

    public static void main(String args[]) {
        System.out.println(getUUID());
    }
}   