package zad1;

public class SortOrder {
    private class AscendingOrder implements Sortable{

        @Override
        public boolean greater(int a, int b) {
            return a > b;
        }
    }

    public Sortable getAscendingOrder(){
        return new AscendingOrder();
    }

    private class DescendingOrder implements Sortable{

        @Override
        public boolean greater(int a, int b) {
            return a < b;
        }
    }

    public Sortable getDescendingOrder(){
        return new DescendingOrder();
    }
}
