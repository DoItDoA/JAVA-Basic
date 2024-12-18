package basic;


public class _22_WrapperClass {
    public static void showData(Object obj) { // Object는 모든 자료형을 아우르기 때문에 자바스크립트처럼 모든 자료형 받아들임
        System.out.println(obj);
    }

    public static void main(String[] args) {
        /*
            기본자료형            Wrapper 인스턴스
            byte        -       Byte
            short       -       Short
            int         -       Integer
            float       -       Float
            double      -       Double
                  Boxing->
                       <-Unboxing
        */
        Integer i = new Integer(3); // 박싱
        int num = i.intValue(); // 언박싱. int값으로 반환
        showData(i);
        showData(num);
        showData(new Double(7.12));
    }
}
/*
 --출력화면--
3
3
7.12
*/