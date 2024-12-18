package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.*;

public class _51_StreamTerminal {
    public static void main(String[] args) {
        // 3. 최종 연산
        List<String> list = Arrays.asList("Box", "Simple", "Complex");

        // reduce
        BinaryOperator<String> lc = (s1, s2) -> { // BinaryOperator는 reduce의 두번째 요소이다, 제네릭은 입력,출력 모두 다 같아야한다.
            if (s1.length() > s2.length())
                return s1;
            else
                return s2;
        };
        String str = list.stream()
                .reduce("", lc); // 첫번째 요소는 스트림이 빈 경우 출력. 반환형은  BinaryOperator의 제네릭에 결정된다.
        /*
            reduce는 BinaryOperator를 이용하여 각각의 스트림("Box", "Simple", "Complex")을 비교해서 최종적으로 하나를 출력한다.
            첫번째 요소는 가상의 스트림으로 ""가 아닌 "Empty Stream"입력시, 첫번째 요소도 다같이 비교하기 때문에 가장 이 중 가장 긴 문자열로서
            스트림이 비지 않아도 "Empty Stream"가 출력된다. 그래서 조건을 충족하는 데이터가 스트림에 없을 때, 이를 대신할 데이터로 지정한다.
        */
        System.out.println(str);

        /*
            병렬 스트림은 컴퓨터의 CPU코어 수에 따라서 나눠서 처리한다. 예로 코어가 2개면 ("Box", "Simple"), ("Complex",빈문자열)
            이렇게 둘로 나눠 동시에 처리하는 방식이다. 코어 수가 많을 수록 성능이 좋지만 병렬 스트림은 스트림 내용이 많거나 복잡할 때
            사용하는 것이 좋다. 단순할 때 사용하면 오히려 느려진다.

            Stream<String> ss = list.stream(); -> 스트림 생성
            String strp = ss.parallel() -> 일반 스트림을 병렬 스트림으로 변경으로 가능하다.
                            .reduce("",lc);
        */
        String strp = list.parallelStream() // 병렬 스트림의 생성
                .reduce("", lc);
        System.out.println(strp);

        // sum, count, average, min, max
        double sum = IntStream.of(1, 3, 5, 7, 9).sum(); // sum의 반환형은  int 또는 double 이다.
        System.out.println("sum = " + sum);

        long count = IntStream.of(1, 3, 5, 7, 9).count(); // count의 반환형은 long이다.
        System.out.println("count = " + count);

        IntStream.of(1, 3, 5, 7, 9)
                .average() // 최종 연산 average의 반환형은 OptionalDouble이므로 ifPresent 쓰는 게 좋다
                .ifPresent(avg -> System.out.println("avg = " + avg));

        IntStream.of(1, 3, 5, 7, 9)
                .min() // 최종 연산 min과 max의 반환형은 OptionalInt 또는 OptionalDouble이므로 ifPresent 쓰는 게 좋다
                .ifPresent(min -> System.out.println("min = " + min));

        // allMatch, anyMatch, noneMatch
        boolean b = IntStream.of(1, 2, 3, 4, 5).allMatch(n -> n % 2 == 0); // 모두 다 짝수이면 true 반환, 아니면 false 반환
        System.out.println(b);
        b = IntStream.of(1, 2, 3, 4, 5).anyMatch(n -> n % 2 == 0); // 하나라도 짝수가 있으면 true 반환, 없으면 false 반환
        System.out.println(b);
        b = IntStream.of(1, 3, 5).noneMatch(n -> n % 2 == 0); // 짝수가 하나도 없으면 true 반환, 있으면 false 반환
        System.out.println(b);

        // collect (마지막에 원하는 형태로 변환해주는 역할)
        String[] words = {"Box", "Toy", "Robot"};
        Stream<String> ssc = Arrays.stream(words);

        List<String> listCollect = ssc.filter(s -> s.length() < 5)
                .collect(() -> new ArrayList<>(), // collect의 첫번째 인자는 중간 연산으로 빠져나온 데이터를 저장할 저장소 생성
                        (c, s) -> c.add(s), // c는 첫번째 인자를 통해서 생성된 인스턴스이고, s는 스트림 데이터, 저장소에 데이터 저장함
                        (list1, list2) -> list1.addAll(list2)); // 여기서는 세번째인자는 의미가 없다.
        System.out.println(listCollect);

        // 병렬 스트림에서의 collect
        ssc = Arrays.stream(words);
        List<String> listParallel = ssc.parallel() // 일반 스트림에서 병렬 스트림으로 변환
                .collect(() -> new ArrayList<>(), // CPU코어에 따라 다수의 저장소 생성. 예로 ("Box", "Toy")는 저장소1로 지정, ("Robot")은 저장소2로 지정
                        (c, s) -> c.add(s), // 각 저장소마다 데이터 삽입
                        (list1, list2) -> list1.addAll(list2)); // 각 저장소에 담긴 데이터들을 하나로 묶음 list2가 저장하고 있는 모든 데이터가 list1에 담김
        System.out.println(listParallel);
    }
}
/*
 --출력화면--
Complex
Complex
sum = 25.0
count = 5
avg = 5.0
min = 1
false
true
true
[Box, Toy]
[Box, Toy, Robot]
*/