package basic;

public class _01_PresentMethod {
    public static void main(String[] args) {
        final int MAX_SIZE = 100; // 상수설정은 final, 상수설정은 대문자로 이룬다
        System.out.println(MAX_SIZE);

        System.out.println("---------------------------");
        int oct = 0123; // 8진수 123표현 (10진수 값은 83)
        int hex = 0x123; // 16진수 123표현 (10진수 값은 291)
        System.out.println(011 + 022 + 033); // 8진수 값 더하기 (값 54)
        System.out.println(0x11 + 0x22 + 0x33); // 16진수 값 더하기 (값 102)

        int num = 100_000_000; // 큰수는 구별하기 위해 중간에 언더바 넣을수 있다

        System.out.println("---------------------------");
        System.out.println(3.0004999D); // double형으로 표현된 실수
        System.out.println(3.0004999f); // float형으로 표현된 실수

        System.out.println("---------------------------");
        double pi = 3.1415;
        int intPi = (int) pi; // 강제 형 변환
        System.out.println(intPi);
    }
}
/*
 --출력화면--
100
---------------------------
54
102
---------------------------
3.0004999
3.0005
---------------------------
3
*/