package basic;

class bbb {
    static void show() { // static 메소드 생성
        System.out.println("출력");
    }

    int num = 0; // 인스턴스 영역

    static void add() {
        // num += 2; -> static 메소드는 일반 변수(num)와 할당영역이 달라서 static 메소드내에 사용 불가능하다
    }
}

public class _06_StaticMethod {
    public static void main(String[] args) {
        bbb.show(); // static 메소드도 어디서나 접근 가능하여 클래스명.메소드명으로 접근이 가능
    }
}
