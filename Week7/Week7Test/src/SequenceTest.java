import iterator.SelectorBackward;
import iterator.SelectorForward;
import iterator.Sequence;

import java.util.Random;

public class SequenceTest {
    public static void main(String[] args) {
        // (1)създайте Sequence последователност от 8 елемента

        Sequence sequence = new Sequence(8);
// (2)инициализирайте Sequence елементите
// със случайни цели числа от интервала [10, 100]

        Random random = new Random();
        for (int i = 0; i < 5; i++) { // to check next
            sequence.add(random.nextInt(91) + 10);//10;100 -> 0; 90 + 10
        }
// (3)използвайте метода getSelectorForward(),за да разпечатате
// тези числа на конзолата
// от първия до последния елемент на последователността

        SelectorForward selectorForward = sequence.getSelectorForward();
        System.out.println("Forward:");

        while (!selectorForward.end()){
            System.out.println(selectorForward.current());
            selectorForward.next();
        }
// (4)използвайте метода getSelectorBackward(),за да разпечатате
// на конзолата тези числа
// от последния елемент до първия на последователността

        SelectorBackward selectorBackward = sequence.getSelectorBackward();
        System.out.println("Backward:");

        while (!selectorBackward.begin()){
            System.out.println(selectorBackward.current());
            selectorBackward.previous();
        }
    }
}
