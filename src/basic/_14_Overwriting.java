package basic;

class B {
    public void show() {
        System.out.println("B출력");
    }

    public void show2() {
        System.out.println("B2출력");
    }

    public final void show3() { // 해당 메소드에 final이 붙으면 오버라이딩을 할 수 없다
        System.out.println("B3출력");
    }
}

class BB extends B {
    @Override // 오버라이딩을 한다는 의미이며 만약 오버라이딩이 잘못됐으면 알려준다
    public void show() {
        System.out.println("BB출력");
    }

    @Override
    public void show2() {
        super.show2(); // super는 부모 클래스(b)를 의미함
        System.out.println("BB2출력");
    }
}

public class _14_Overwriting { // 참고로 변수와 클래스변수, 클래스 메소드는 오버라이딩이 되지 않는다
    public static void main(String[] args) {
        B b1 = new B();
        B b2 = new BB();
        BB b3 = new BB();

        b1.show(); // b1은 부모만 인스턴스 생성이므로 부모의 메소드가 출력된다
        b2.show(); // b2는 자식 인스턴트스를 참조하였으므로 자식이 부모의 메소드를 덮어 씌운다
        b3.show(); // b3도 자식만 인스턴스 생성이지만 부모를 상속하고 있어 자식이 부모 메소드를 떺어 씌운다.

        b2.show2();
        b3.show2();
    }
}
/*
 --출력화면--
B출력
BB출력
BB출력
B2출력
BB2출력
B2출력
BB2출력
*/