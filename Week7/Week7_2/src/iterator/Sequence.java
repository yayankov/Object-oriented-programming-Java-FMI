package iterator;

import java.util.Random;

public class Sequence { // outer class
// Holds a sequence of Objects.

    private Object[] obs;
    private int next = 0; // current number of elements

    public Sequence(int size) {
        obs = new Object[size];
    }

    public void add(Object x) {
        if (next < obs.length) {
            obs[next] = x;
            next++;
        }
    }

    private class SSelectorForward implements SelectorForward{
        // inner class манипулира преместване от първия към последния
        private int i = 0;
        @Override
        public boolean end() {
            return i == next; //until last initialized element
        }

        @Override
        public void next() {
            if(i < next) i++;
        }

        @Override
        public Object current() {
            return obs[i];
        }
    }// end inner class

    public SelectorForward getSelectorForward(){
        return new SSelectorForward();
    }

    private class SSelectorBackward implements SelectorBackward{

        private int i = next - 1; //from last initialized element
        @Override
        public boolean begin() {
            return i == -1;
        }

        @Override
        public void previous() {
            if(i >= 0) i--;
        }

        @Override
        public Object current() {
            return obs[i];
        }
    }//end inner class

    public SelectorBackward getSelectorBackward(){
        return new SSelectorBackward();
    }
}
