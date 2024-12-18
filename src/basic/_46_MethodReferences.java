package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ToIntBiFunction;

class JustSort {
    public void sort(List<?> list) {
        Collections.reverse(list);
    }
}

class IBox {
    private int n;

    public IBox(int n) {
        this.n = n;
    }

    public int larger(IBox b) {
        if (n > b.n)
            return n;
        else
            return b.n;
    }
}

public class _46_MethodReferences {
    public static void main(String[] args) {
        // static 메소드의 참조*********************
        List<Integer> list = Arrays.asList(1, 3, 5, 7, 9);
        list = new ArrayList<>(list);

        // Consumer<List<Integer>> c = (ls) -> Collections.reverse(ls); 가 아래로 변경가능 
        Consumer<List<Integer>> c = Collections::reverse; // accept에 전달되는 입력인자(list)가 accept내 reverse에 쓰이므로, 입력인자 생략하고 ::사용 
        c.accept(list); // accept(List<Integer> list) { Collections.reverse(list) };
        System.out.println(list);

        // 인스턴스 메소드의 참조*********************
        list = Arrays.asList(1, 3, 5, 7, 9);
        list = new ArrayList<>(list);
        JustSort js = new JustSort(); // 클래스 인스턴스 생성

        // Consumer<List<Integer>> jsc = e -> js.sort(e); 가 아래로 변경가능
        Consumer<List<Integer>> jsc = js::sort; // 외부 클래스의 메소드 참조, 입력 인자는 accept에 똑같이 쓰이므로 생략하고 :: 사용
        jsc.accept(list); // accept(List<Integer> list) { js.sort(list) };
        System.out.println(list);

        // forEach 메소드***************************
        // list.forEach(s -> System.out.print(s)); 가 아래로 변경 가능
        list.forEach(System.out::print); // 컬렉션 인스턴스 대상으로 각 요소마다(ex)List의 1,2,3,4) print 적용
        System.out.println();

        // 2개의 인스턴스 메소드 참조*******************
        IBox ib1 = new IBox(5);
        IBox ib2 = new IBox(7);

        // ToIntBiFunction<IBox, IBox> bf = (b1, b2) -> b1.larger(b2); 가 아래로 변경가능
        ToIntBiFunction<IBox, IBox> bf = IBox::larger; // 이렇게 바뀌는 건 일종의 약속, ToIntBiFunction<T, U>    int applyAsInt(T t, U u)
        int bigNum = bf.applyAsInt(ib1, ib2); // int applyAsInt(IBox ib1, IBox ib2) { return ib1.larger(ib2) };
        System.out.println(bigNum);

        // 생성자 참조********************************
        char[] src = {'R', 'O', 'B', 'O', 'T'};
        // Function<char[], String> f = ar -> new String(ar); 가 아래로 변경가능
        Function<char[], String> f = String::new; // new는 이렇게 표현하기로 일종의 약속
        String str = f.apply(src); // String apply(char[] src) { return new String(src) };, 배열 char를 이용하여 String으로 변경
        System.out.println(str);
    }
}
/*
 --출력화면--
[9, 7, 5, 3, 1]
[9, 7, 5, 3, 1]
97531
7
ROBOT
*/