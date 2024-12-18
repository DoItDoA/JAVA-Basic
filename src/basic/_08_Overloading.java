package basic;

class CCC {
    private int num1;
    private int num2;

    CCC(int book, int sing) { // 일반 메소드도 가능하지만 생성자도 오버로딩이 가능하다
        num1 = book;
        num2 = sing;
    }

    CCC(int call) { // 매개변수형 또는 매개변수 갯수가 다르면 이름이 같아도 사용이 가능하다. 이것을 오버로딩이라 부른다.
        this(call, 0); // 이 this는 다른 메소드(첫번째 생성자 CCC)를 호출하여 사용한다
    }

    void show() {
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
    }
}

public class _08_Overloading {
    public static void main(String[] args) {
        CCC me = new CCC(123, 456);
        CCC you = new CCC(789);
        me.show();
        you.show();
    }
}
