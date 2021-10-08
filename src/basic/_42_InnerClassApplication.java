package basic;

interface Printable {
    void print();
}

class Papers {
    private String paper;

    Papers(String paper) {
        this.paper = paper;
    }

    // 이너 클래스
    public Printable innerPrint() {
        return new Anything(); // Printable A = new Anything(); (다형성)
    }

    private class Anything implements Printable { // innerPrint()로 인스턴스 생성하여 메인에서는 이름을 알 수가 없다. 즉 클래스명 아무거나해도 된다.
        @Override
        public void print() {
            System.out.println(paper);
        }

        public void noUse() { // 메인에서 부모에서 자식으로 참조하기 때문에 이 메소드는 사용할 수 없는 메소드이다. 즉 오버라이딩만 하는 메소드만 사용가능
            System.out.println();
        }
    }

    // 로컬 클래스
    public Printable localPrint() { // 메소드 안에 클래스가 들어있다.
        class Anything2 implements Printable { // 메소드 안에 아무 이름의 클래스를 만들어놓고 반환시 이 클래스의 새 인스턴스를 반환
            @Override
            public void print() {
                System.out.println(paper);
            }

        }
        return new Anything2(); // 반환시 해당클래스를 새 인스턴스로 반환
    }

    // 익명 클래스
    public Printable anonymousPrint() {
        return new Printable() { // 아무 이름을 하기 때문에 이름 제거하고 구현하고 있는 인터페이스를 새 인스턴스로 반환한다. Printable A = new Printable();
            // 오버라이딩만 하는 메소드만 사용 가능하기 때문에 위 처럼 선언해도 무방하다
            @Override
            public void print() {
                System.out.println(paper);
            }
        };
    }
}

public class _42_InnerClassApplication {
    public static void main(String[] args) {
        Papers p = new Papers("서류");
        Printable innerPrn = p.innerPrint(); // 함수를 호출하면서 이너클래스 내의 어떠한 인스턴스를 생성한다.
        innerPrn.print(); // 생성된 인스턴스의 함수를 호출

        Printable localPrn = p.localPrint(); // 함수를 호출하면서 로컬클래스 내의 어떠한 인스턴스를 생성한다.
        localPrn.print();

        Printable anonymousPrn = p.localPrint();  // 함수를 호출하면서 익명클래스 내의 어떠한 인스턴스를 생성한다.
        anonymousPrn.print();

    }
}
