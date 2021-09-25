package basic;

import java.time.LocalDate;
import static java.lang.Math.*; // import에 static 붙여 Math.함수 사용대신 바로 사용가능하게 함

public class _7_Static {
    static String date;

    static { // 클래스 로딩시 단 한번만 실행이 되는 영역
        LocalDate nDate = LocalDate.now();
        date = nDate.toString(); // .toString() 문자열로 바꿔주는 메소드
    }

    public static void main(String[] args) {
        System.out.println(date);
        System.out.println(PI); // 원래는 Math.PI가 사용해야하지만 import에 static이 붙어 그냥 사용
    }
}
