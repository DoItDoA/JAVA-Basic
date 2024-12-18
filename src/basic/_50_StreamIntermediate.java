package basic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class ReportCard {
    private int kor;
    private int eng;

    public ReportCard(int kor, int eng) {
        this.kor = kor;
        this.eng = eng;
    }

    public int getKor() {
        return kor;
    }

    public int getEng() {
        return eng;
    }
}

public class _50_StreamIntermediate {
    public static void main(String[] args) {
        // 2. 중간 연산
        List<String> list = Arrays.asList("Toy", "Robot", "Box");

        // 2번 이상의 중간연산
        list.stream()
                .filter(s -> s.length() == 3) // 중간 연산
                .map(s -> s.toUpperCase()) // 중간 연산
                .forEach(s -> System.out.print(s + "\t"));
        System.out.println();

        // mapToInt, mapToLong, mapToDouble
        list.stream()
                .mapToInt(s -> s.length()) // 불필요한 언박싱 피함
                .forEach(s -> System.out.print(s + "\t"));
        System.out.println();

        // flatMap
        ReportCard[] cards = {
                new ReportCard(70, 80),
                new ReportCard(90, 40)
        }; // 클래스 배열 생성

        Arrays.stream(cards)
                .flatMapToInt(r -> IntStream.of(r.getKor(), r.getEng())) // flatMap은 안에서 자체 스트림 생성하여 kor,eng를 다중으로 받아서 처리 가능, 'map(r -> r.getKor(), r.getEng())'은 불가능하다
                .average(). // 반환형이 OptionalDouble이다. 그래서 average().getAsDouble()을 하거나 ifPresent 사용
                ifPresent(avg -> System.out.println(avg));

        // 정렬
        Stream.of("Box", "Apple", "Rabbit")
                .sorted((s1, s2) -> s1.length() - s2.length()) // 안에 람다식 이용하여 정렬 기준 정함, 빈값이면 오름차순 표현
                .forEach(s -> System.out.print(s + "\t"));
        System.out.println();

        // peek
        IntStream.of(1, 3, 5)
                .peek(p -> System.out.print(p + "\t")) // forEach와 같은 기능이지만 중간 연산의 역할이라 최종 연산 없이는 출력이 안된다.
                .sum(); // 여기서 sum은 실행 결과에 아무런 영향을 주지 않는다. 따라서 중간연산이 출력된다.
    }
}
/*
 --출력화면--
TOY	BOX
3	5	3
70.0
Box	Apple	Rabbit
1	3	5
*/