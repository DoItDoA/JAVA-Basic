package basic;

class S {
    static int count = 0; // 클래스 변수와 메소드는 s 인스턴스내에 존재하지않기 때문에 상속의 대상이 아니다
    
    public S() {
        System.out.println("parents");
    }

    public S(int i) {
        System.out.println("parents(int i)");
    }

    public S(int i, int j) {
        System.out.println("parents(int i, int j)");
    }
}

class SS extends S {
    public SS() { // 부모클래스의 생성자가 입력 인자 필요 없은 경우 생략해도 자동으로 상속된다
        System.out.println("children");
    }

    public SS(int i) {
        super(i, 0); // 부모클래스의 입력인자가 2개인 생성자 호출. 만약 super가 없으면 입력인자가 없는 생성자가 상속됨
        System.out.println("children(int i)");
    }
}

public class _12_Inherit {
    public static void main(String[] args) {
        new SS(); // 참조변수없이 그냥 실행 시킬 때 하면 된다
        new SS(1);
    }
}
