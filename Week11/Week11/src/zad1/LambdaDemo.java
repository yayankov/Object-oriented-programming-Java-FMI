package zad1;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

class LambdaDemo
{
    public static void main(String[] args)
    {
        Predicate<Salesperson> predicate1; // да се инициализира
        Predicate<Salesperson> predicate2; // да се инициализира
        Predicate<Salesperson> predicate ; // да се инициализира
        Consumer<Salesperson> consumer1; // да се инициализира
        Consumer<Salesperson> consumer2; // да се инициализира
        Comparator<Salesperson> comparator1; // да се инициализира
        Comparator<Salesperson> comparator2; // да се инициализира

        //initialize
        predicate1 = x -> x.getNumSales() < 1200;
        //predicate1 = (Salesperson x) -> x.getNumSales() < 1200;
        predicate2 = x -> x.getNumSales() > 900;
        /*
        predicate2 = x -> {
            if(x.getNumSales() > 900)
                return true;
            else return false;
        };
         */

        predicate = predicate1.and(predicate2);
        //predicate = predicate1.or(predicate2);

        consumer1 = x -> System.out.println("Salary up by 5%: " + x.getSalary() * 1.05);
        //x.setSalary

        consumer2 = x -> {
            if (predicate1.test(x)) {
                //x.setSalary
                x.setSalary(x.getSalary() * 1.02);
            } else {
                x.setSalary(x.getSalary() * 0.98);
            }
            System.out.println(x.toString());
        };

        comparator1 = (x, y) -> (int) (y.getSalary() - x.getSalary()); //descending order

        comparator2 = (x, y) -> x.getSalary() == y.getSalary()?
                x.getNumSales() - y.getNumSales() :
                comparator1.compare(x, y);

        Random random = new Random();
        Salesperson[] salespersons =
                {
                        new Salesperson("John Doe", 2000, 949),
                        new Salesperson("Jane Doe", 3900, 1500),
                        new Salesperson("Jane Doe",
                                1000 + random.nextInt(501), 500 + random.nextInt(1001)),
                        new Salesperson("Jane Doe",
                                1000 + random.nextInt(501), 500 + random.nextInt(1001)),
                        new Salesperson("Jane Doe",
                                1000 + random.nextInt(501), 500 + random.nextInt(1001)),
                        new Salesperson("Jane Doe",
                                1000 + random.nextInt(501), 500 + random.nextInt(1001)),
                        new Salesperson("Jane Doe",
                                1000 + random.nextInt(501), 500 + random.nextInt(1001)),
                        new Salesperson("Jane Doe",
                                1000 + random.nextInt(501), 500 + random.nextInt(1001)),
                        new Salesperson("Jane Doe",
                                1000 + random.nextInt(501), 500 + random.nextInt(1001)),
                        new Salesperson("Jane Doe",
                                1000 + random.nextInt(501), 500 + random.nextInt(1001)),

                        // да се добавят  още 10 обекти от тип Salesperson
                        // или да се инициализират с Random стойности

                };

        List<Salesperson> listOfSalespersons = new ArrayList<>();
        //listOfSalespersons = Arrays.asList(salespersons.clone());
        // обектите на salespersons да се запишат в listOfSalespersons
        for (int i = 0; i < salespersons.length; i++) {
            listOfSalespersons.add(salespersons[i]);
        }

        for (Salesperson salesperson: salespersons)
        {
            applyBonus(salesperson, predicate1,   consumer1);
            System.out.println(salesperson);
            salesperson.printNumSales(salesperson);
        }
        for (Salesperson salesperson: salespersons)
        {
            applyBonus(salesperson, predicate2,  consumer2);
            System.out.println(salesperson);
        }
        sort(listOfSalespersons, comparator1);
        System.out.println(listOfSalespersons);

        sort(listOfSalespersons, comparator2);
        System.out.println(listOfSalespersons);

    }
    public static void applyBonus(Salesperson salesperson,
                                  Predicate<Salesperson> predicate,
                                  Consumer<Salesperson> consumer)    {
        // Напишете if  команда, където използвайте predicate
        //    за да определите дали да изпълните consumer
        // Изпълнете consumer, когато условието на if  командата е изпълнено
        if (predicate.test(salesperson)){
            consumer.accept(salesperson);
        }
    }
    public static void applyBonus(List<Salesperson> salespersons,
                                  Predicate<Salesperson> predicate,
                                  Consumer<Salesperson> consumer)    {
        // Напишете if  команда, където използвайте predicate
        //    за да определите дали да изпълните consumer
        // Изпълнете consumer, когато условието на if  командата е изпълнено

        for (Salesperson s: salespersons) {
            if (predicate.test(s)){
                consumer.accept(s);
            }
        }
    }
    public static void sort(List<Salesperson> salespersons,
                            Comparator<Salesperson> comparator)
    {
        // Сортирайте  salespersons като използвате  comparator
        Collections.sort(salespersons, comparator);
    }
    public static void group(List<Salesperson> salespersons)
    {
        // Групирайте имената на salespersons по първата буква в името изведете отделните групи на стандартен изход
    }

}


