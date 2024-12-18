package basic;

import static java.lang.Math.*; // import에 static 붙여 Math.함수 사용대신 바로 사용가능하게 함


class InnerClass {
    static int data = 0;

    static { // 클래스 로딩시 단 한번만 실행이 되는 영역
        System.out.println("호출됨");
        data++;
    }

    public static int take() {
        return data;
    }

}

public class _07_Static {
    public static void main(String[] args) {
        System.out.println(PI); // 원래는 Math.PI가 사용해야하지만 import에 static이 붙어 그냥 사용

        // 객체 생성, 필드 호출, 메서드 호출 등 해당 클래스에 대해서 단 한번만 호출됨
        // 생성자는 객체 생성마다 호출
        InnerClass innerClass = new InnerClass(); // static{} 호출
        System.out.println(InnerClass.data);
        System.out.println(InnerClass.take());
    }
}
/*
 --출력화면--
 3.141592653589793
 호출됨
 1
 1
*/