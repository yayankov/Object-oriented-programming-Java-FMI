package zad1;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTest {
    public static <E extends Comparable<E>> E max(E[][] list){
        if (list == null || list.length == 0 || list[0].length == 0)
            return null;

        E max = list[0][0];
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                if(max.compareTo(list[i][j]) < 0){
                    max = list[i][j];
                }
            }
        }
        return max;
    }

    public static <E> void shuffle(ArrayList<E> list){
        if (list == null) return;
        Collections.shuffle(list);
    }

    public static <E extends Comparable<E>> E max(ArrayList<E> list){
        return Collections.max(list);
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
        if (list == null) return null;
        ArrayList<E> noDuplicates = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (!noDuplicates.contains(list.get(i))){
                noDuplicates.add(list.get(i));
            }
        }
        return noDuplicates;
    }

    public static <E> ArrayList<E> onlyOnce(ArrayList<E> list){
        if (list == null) return null;
        ArrayList<E> onlyOnce = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (Collections.frequency(list, list.get(i)) == 1){
                onlyOnce.add(list.get(i));
            }
        }
        return onlyOnce;
    }

    public static void main(String[] args) {
        Double[][] numbers = new Double[][]{
                {3.7, 3.9, 10.1, -1.5},
                {2.0, 7.3, 7.9},
                {1.8, 1.9, 10.02}
        };

        System.out.printf("Max: %.2f\n", max(numbers));

        ArrayList<Integer> toShuffle = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            toShuffle.add(i);
        }
        shuffle(toShuffle);
        System.out.println("Shuffled list: " + toShuffle);

        System.out.printf("Max: %d\n", max(toShuffle));
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("model1", 2000));
        cars.add(new Car("model1", 1998));
        cars.add(new Car("model1", 2005));
        cars.add(new Car("model1", 2010));
        cars.add(new Car("model1", 2013));
        System.out.printf("Max: %s\n", max(cars).toString());

        ArrayList<String> duplicates = new ArrayList<>();
        duplicates.add("str");
        duplicates.add("str");
        duplicates.add("str3");
        duplicates.add("str4");
        duplicates.add("str");

        System.out.println("Removed duplicates: " +
                removeDuplicates(duplicates));
        System.out.println("Non-duplicate elements: " +
                onlyOnce(duplicates));
    }
}
