package basic;

class aaa{
    static int num = 0; // static 변수 선언

    aaa(){
        num++;
    }
}

public class _05_StaticClass {
    public static void main(String[] args) {
        aaa way = new aaa(); // 여기서 생성자가 1증가 시킴
        way.num++; // 생성된 인스턴스로 1증가
        aaa.num++; // static변수는 어디서든 접근이 가능하여 클래스명.변수로 접근 가능
        System.out.println(aaa.num);
    }
}
