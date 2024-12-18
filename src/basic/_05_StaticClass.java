package basic;

class AAA {
    static int num = 0; // static 변수 선언

    AAA() {
        System.out.println("생성자 호출");
        num++;
    }
}

public class _05_StaticClass {
    public static void main(String[] args) {
        AAA way = new AAA(); // 여기서 생성자가 1증가 시킴
        way.num++; // 생성된 인스턴스로 1증가
        AAA.num++; // static변수는 어디서든 접근이 가능하여 클래스명.변수로 접근 가능
        System.out.println(AAA.num);
    }
}
/*
 --출력화면--
생성자 호출
3
*/