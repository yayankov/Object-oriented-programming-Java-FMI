package zad1;

public class MySort {

    private Sortable order; //callback

    public MySort(Sortable order) {
        this.order = order;
    }

    public MySort() {
        order = new Sortable() {
            @Override
            public boolean greater(int a, int b) {
                return a > b; //ascending
            }
        };
    }

    public Sortable getOrder() {
        return order;
    }

    public void setOrder(Sortable order) {
        this.order = order;
    }

    public void sort(int[] numbers){
        int swap;
        if(order == null) return;

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {
                if (order.greater(numbers[j], numbers[j+1])){
                    swap = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = swap;
                }
            }

        }
    }
}
