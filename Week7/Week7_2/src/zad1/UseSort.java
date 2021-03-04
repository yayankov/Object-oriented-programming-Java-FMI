package zad1;

import java.util.Random;

public class UseSort {
    public static void print(int[] numbers){
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }

    public static void main(String[] args) {
        SortOrder sortOrder = new SortOrder();
        Sortable asc = sortOrder.getAscendingOrder();
        Sortable dsc = sortOrder.getDescendingOrder();
        MySort mySort = new MySort();

        Random rand = new Random();
        int[] numbers = new int[20];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(91) + 15; //15; 105 -> 0; 90
        }

        System.out.println("Numbers unsorted:");
        print(numbers);

        mySort.sort(numbers);
        System.out.println("\nNumbers ascending sorted:");
        print(numbers);

        mySort.setOrder(dsc);
        mySort.sort(numbers);
        System.out.println("\nNumbers descending sorted:");
        print(numbers);

        MySort mySort1 = new MySort(asc);
        mySort1.sort(numbers);
        System.out.println("\nNumbers ascending sorted:");
        print(numbers);
    }
}
