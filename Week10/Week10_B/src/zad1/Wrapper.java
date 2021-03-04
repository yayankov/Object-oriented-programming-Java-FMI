package zad1;

import java.util.Random;

public class Wrapper {

    private int size; // size of char array

    public Wrapper(int size) {
        setSize(size);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if ( size >= 0 ) {
            this.size = size;
        } else {
            this.size = 0;
        }
    }

    private class FixedRandom implements Cipherable{

        @Override
        public char[] getSecretChars(int seed) {
            char[] result = new char[size];

            Random random = new Random(seed);

            for (int i = 0; i < result.length; i++) {
                result[i] = (char)
                        ('A' + random.nextInt(26));
            }

            return result;
        }
    }

    public Cipherable makeFixedSelection(){
        return new FixedRandom();
    }

    private class FixedSelection implements Cipherable{

        @Override
        public char[] getSecretChars(int seed) {
            char[] result = new char[size];
            char[] alphabet = new char[seed];

            Random random = new Random();
            for (int i = 0; i < alphabet.length; i++) {
                alphabet[i] = (char) ('A' + random.nextInt(26));
            }

            for (int i = 0; i < result.length; i++) {
                result[i] = alphabet[random.nextInt(seed)];
            }

            return result;
        }
    }

    public Cipherable makeFixedRandom(){
        return new FixedSelection();
    }
}
