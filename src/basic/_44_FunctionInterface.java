package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class _44_FunctionInterface {
    // Predicate 기능 사용
    public static int usePredicate(Predicate<Integer> p, List<Integer> list) {
        // Predicate<T>안에는 boolean test(T t) 추상함수가 내장되어 있다.
        // IntPredicate         boolean test(int value) -> 이 기능들은 Predicate가 자동 언박싱하는 것을 미리하여 성능이 더 좋게 한다.
        // DoublePredicate      boolean test(double value) -> Int, Double 외에도 더 있다.
        // BiPredicate<T, U>    boolean test(T t, U u)
        int s = 0;
        for (int i : list) {
            if (p.test(i)) // test 함수 기능은 i % 2 == 0이다
                s += i;
        }
        return s;
    }

    // Supplier 기능 사용
    public static List<Integer> useSupplier(Supplier<Integer> s, int n) {
        // Supplier<T>안에는 T get() 추상함수가 내장되어 있다.
        // IntSupplier       int getAsInt()
        // LongSupplier      long getAsLong()
        // BooleanSupplier   boolean getAsBoolean()

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(s.get()); // get 함수 안에 Random rand = new Random(); return rand.nextInt(50); 가 들어있다.

        return list;
    }

    public static void main(String[] args) {
        // 1. Predicate 사용
        List<Integer> list = Arrays.asList(1, 4, 7, 9, 11, 12);
        int s = usePredicate(n -> n % 2 == 0, list); // test함수에 n % 2 == 0인 함수 오버라이딩
        System.out.println("짝수 합 : " + s);

        // 2. Supplier 사용
        Supplier<Integer> spr = () -> { // Supplier의 get()은 입력인자가 없고 반환값만 있어 return은 꼭 해야한다.
            Random rand = new Random();
            return rand.nextInt(50);
        };
        list = useSupplier(spr, 5);
        System.out.println(list);

        // 3. Consumer 사용
        // Consumer<T>안에는 void accept(T t) 추상함수가 내장되어 있다.
        // IntConsumer           void accept(int value)
        // ObjIntConsumer<T>     void accept(T t, int value)
        // LongConsumer          void accept(long value)
        // ObjLongConsumer<T>    void accept(T t, long value)
        // BiConsumer<T,U>       void accept(T t, U u)
        Consumer<String> c = ss -> System.out.println(ss); // Consumer는 입력 기능만 있어 보통 이렇게 println처럼 출력 함수를 쓴다.
        c.accept("Consumer"); // accpet 함수 안에 System.out.println가 들어있다.

        // 4. Function 사용
        // Function<T,R>안에는 R apply(T t) 추상함수가 내장되어 있다.
        // IntToDoubleFunction      double applyAsDouble(int value)
        // DoubleUnaryOperator      double applyAsDouble(double value)
        // BiFunction<T,U,R>        R apply(T t,U u)
        Function<String, Integer> f = ff -> ff.length();
        System.out.println(f.apply("Robot"));
    }
}
