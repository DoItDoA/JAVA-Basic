package basic;

interface I {
    int SIZE = 100; // 인터페이스의 변수는 public이면서 static, final이다

    void show(String str); // 메소드의 양식 설정. 인터페이스의 메소드는 public이 안적혀도 public선언이다.
}

interface II extends I { // 인터페이스끼리 상속할 때는 extends를 이용한다
    void show2(String str);

    default void show3(String str) {
    } // default를 추가하면 선택적으로 오버라이딩할 수 있다. 반드시 바디{ }를 쓴다
}

class Inter implements II { // 인터페이스는 implement를 이용하여 구현한다
    @Override // 인터페이스에 있는 모든 메소드는 다 오버라이딩해야 오류가 안생긴다
    public void show(String str) {
        System.out.println(str);
    }

    @Override
    public void show2(String str) {
        System.out.println(str.toUpperCase()); // 대문자로 변경
    }
}

public class _16_Interface {
    public static void main(String[] args) {
        String str = "this is interface";
        II ref = new Inter();
        ref.show(str);
        ref.show2(str);
    }
}
/*
 --출력화면--
this is interface
THIS IS INTERFACE
*/