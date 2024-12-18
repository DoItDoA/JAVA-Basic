package basic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class _49_Stream {
    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 4, 5};
        /* 
            스트림의 기본표현
            IntStream stmInt1 = Arrays.stream(ar);
            IntStream stmInt2 = stmInt1.filter(n -> n % 2 == 0);
            int sum = stmInt2.sum();
            System.out.println(sum);
        */

        // 축약식
        int sum = Arrays.stream(ar) // 스트림 생성
                .filter(n -> n % 2 == 0) // 중간 연산
                .sum(); // 최종 연산 ( 반드시 최종연산해야 출력이 된다 )
        System.out.println(sum);

        // 1. 스트림 생성
        String[] names = {"yoon", "lee", "park"};
        /*
            Stream<String> stmStr = Arrays.stream(names); -> 배열 대상으로 스트림 생성
            stmStr.forEach(s -> System.out.print(s + "\t"));
        */
        Arrays.stream(names, 1, 3) // 1번째부터 3번째이전까지 생성
                .forEach(s -> System.out.print(s + "\t")); // 최종 연산
        System.out.println();

        // 자체 스트림 생성
        Stream.of(11, 22, 33, 44) // 스트림 생성에 데이터 직접전달
                .forEach(n -> System.out.print(n + "\t"));
        System.out.println();

        IntStream isr = IntStream.range(5, 8); // 5부터 8이전까지 스트림생성, IntStream은 Stream<T>와 달리 불필요한 언박싱 피함
        isr.forEach(s -> System.out.print(s + "\t"));
        System.out.println();

        IntStream isrc = IntStream.rangeClosed(5, 8); // 5부터 8까지 스트림생성
        isrc.forEach(s -> System.out.print(s + "\t"));

        // 컬렉션 인스턴스의 스트림 생성 차이
        List<String> list = Arrays.asList("Toy", "Robot", "Box"); // 컬렉션 인스턴스의 스트림 생성
        list.stream() // 리스트의 데이터 하나하나 스트림생성
                .forEach(s -> System.out.print(s + "\t"));
        System.out.println();

        Stream.of(list) // 컬렉션 리스트 그 자체로 스트림생성
                .forEach(s -> System.out.print(s + "\t")); // 출력시 "\t" 적용이 안되어있다
        System.out.println();

        // 스트림의 연결
        DoubleStream ds1 = DoubleStream.of(1.1, 2.2);
        DoubleStream ds2 = DoubleStream.of(3.3, 4.4);
        DoubleStream.concat(ds1, ds2) // 스트림 연결, 같은 타입으로 연결해야한다.
                .forEach(f -> System.out.print(f + "\t"));
    }
}
/*
 --출력화면--
6
lee	park
11	22	33	44
5	6	7
5	6	7	8	Toy	Robot	Box
[Toy, Robot, Box]
1.1	2.2	3.3	4.4
*/