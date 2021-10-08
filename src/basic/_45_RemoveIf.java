package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class _45_RemoveIf {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(-3, -2, -1, 0, 1, 2, 3);
        list1 = new ArrayList<>(list1);
        List<Double> list2 = Arrays.asList(-3.3, -2.2, -1.1, 0.0, 1.1, 2.2, 3.3);
        list2 = new ArrayList<>(list2);

        Predicate<Number> p = n -> n.doubleValue() < 0; // 0보다 작으면 true 반환
        // default boolean removeIf(Predicate<? super E> filter)
        list1.removeIf(p); // removeIf에 Predicate<Number>를 넣고 test 함수가 true 반환되는 인스턴스는 삭제를 한다.
        list2.removeIf(p);
        System.out.println(list1);
        System.out.println(list2);
    }
}
