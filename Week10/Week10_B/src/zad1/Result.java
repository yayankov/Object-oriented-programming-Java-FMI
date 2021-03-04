package zad1;

import java.util.Arrays;

public class Result {

    private char[] chars;
    private int data;

    public Result(char[] chars, int data) {
        setData(data);
        setChars(chars);
    }

    public char[] getChars() {
        char[] copy = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            copy[i] = chars[i];
        }
        return copy;
    }

    public void setChars(char[] chars) {
        if (chars == null) {
            this.chars = new char[0];
        } else {
            this.chars = new char[chars.length];
            for (int i = 0; i < chars.length; i++) {
                this.chars[i] = chars[i];
            }
        }
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        /*
        if (data >= 0) {
            this.data = data;
        } else {
            this.data = 0;
        }
        */

        this.data = data >= 0? data : 0;
    }

    @Override
    public String toString() {
        return String.format("Chars: %s\nResult: %d",
                Arrays.toString(chars), data);
    }
}
