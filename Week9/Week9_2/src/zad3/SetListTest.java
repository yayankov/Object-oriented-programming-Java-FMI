package zad3;

import java.util.*;

public class SetListTest {

    public static Set<Integer> union(Set<Integer> set,
                                     ArrayList<Integer> list){
        HashSet<Integer> newSet = new HashSet<>(set);
        newSet.addAll(list);
        return newSet;
    }

    public static Set<Integer> intersection(Set<Integer> set,
                                     ArrayList<Integer> list){
        HashSet<Integer> newSet = new HashSet<>(set);
        newSet.retainAll(list);
        return newSet;
    }

    public static Set<Integer> differenceSetList(Set<Integer> set,
                                     ArrayList<Integer> list){
        HashSet<Integer> newSet = new HashSet<>(set);
        newSet.removeAll(list);
        return newSet;
    }

    public static Set<Integer> differenceListSet(Set<Integer> set,
                                     ArrayList<Integer> list){
        ArrayList<Integer> copy = new ArrayList<>(list);
        copy.removeAll(set);
        return new HashSet<>(copy);
    }

    public static Set<Integer> sortDescending( Set<Integer> set){
        TreeSet<Integer> sortedDescending = new TreeSet<>
                (Comparator.reverseOrder());
        sortedDescending.addAll(set);
        return sortedDescending;
    }

    //2.2a
    public static ArrayList<String> sort(ArrayList<String>
                                                 list){
        list.sort(Comparator.reverseOrder());
        // null for ascending order
        return list;
    }

    public static void main(String[] args) {
        Set<Integer> s = new HashSet<>();
        Integer[] numbers =
                {7, 12, 15, 19, 53, 68, 3, 33, 57, 45, 25};
        for (int i = 0; i < numbers.length; i++) {
            s.add(numbers[i]);
        }

        ArrayList<Integer> t = new ArrayList<>();
        numbers = new Integer[]
                {22, 9, 15, 42, 53, 79, 3, 33, 97, 45, 25};
        for (int i = 0; i < numbers.length; i++) {
            t.add(numbers[i]);
        }

        System.out.println("Set: " + s);
        System.out.println("List: " + t);
        System.out.println("Union:");
        System.out.println(union(s,t));
        System.out.println("Intersection:");
        System.out.println(intersection(s,t));
        System.out.println("Difference s - t:");
        System.out.println(differenceSetList(s,t));
        System.out.println("Difference t - s:");
        System.out.println(differenceListSet(s,t));

        System.out.println("Sorted descending:");
        System.out.println(sortDescending(s));

        ArrayList<String> list = new ArrayList<>();
        list.add("str");
        list.add("asd");
        list.add("dsfsa");
        list.add("zcr");
        list.add("asdgaf");
        System.out.println("Sorted String list:");
        System.out.println(sort(list));
    }
}
