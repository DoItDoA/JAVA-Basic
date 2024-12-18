package basic;

class Capsule {
    void aTake() {
        System.out.println("a출력");
    }

    void bTake() {
        System.out.println("b출력");
    }

    void take() { // 관련있는 함수들을 다 넣어서 사용. 이렇게하면 따로 함수호출할 필요가 없다.
        // 클래스도 마찬가지로 인스턴스 생성하고 각 클래스의 함수들을 다 넣어서 캡슐화할 수 있다
        aTake();
        bTake();
    }
}


class Patient {
    void take(Capsule cap) { // 클래스를 입력형태로 참조변수
        cap.take();
    }
}

public class _04_Encapsulation {
    public static void main(String[] args) {
        Patient man = new Patient();
        man.take(new Capsule()); // 새로 생성한 인스턴스를 입력인자로 사용. 굳이 Capsule cap = new Capsule() 선언하고 cap을 넣는 것보다 낫다
    }
}
/*
 --출력화면--
 a출력
 b출력
*/