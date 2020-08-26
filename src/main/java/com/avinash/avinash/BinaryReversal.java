package com.avinash.avinash;

public class BinaryReversal {

    public static void main(String[] args) {
        new BinaryReversal().reverseBinary(47);
    }

    public int reverseBinary(int n) {
        StringBuilder binary = new StringBuilder();
        while (n != 0) {
            int x = n % 2;
            binary.insert(0, x);
            n = n / 2;
        }
        if (binary.length() < 8) {
            int pad = 8 - binary.length();
            for (int i = 0; i < pad; i++) {
                binary.insert(0, "0");
            }
        }

        binary = binary.reverse();

        int res = 0;
        for (int i = (binary.length() - 1); i >= 0; i--) {
            int y = (int) (binary.charAt(i)) - '0';
            res += y * Math.pow(2, (7 - i));
        }

        System.out.println(res);
        return res;
    }
}
