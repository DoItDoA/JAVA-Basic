package basic;

class C {
    void a() {
        System.out.println("A출력");
    }
}

class CC extends C {
    void b() {
        System.out.println("B출력");
    }
}

class Animal {
    void breath() {
        System.out.println("숨쉬기");
    }
}

class Lion extends Animal {
    public String toString() {
        return "사자";
    }
}

class Tiger extends Animal {
    public String toString() {
        return "호랑이";
    }
}

class Zookeeper {
    void feed(Animal animal) { // 부모요소를 거점으로 하기
        System.out.println(animal + "에게 먹이주기");
    }
}

public class _13_Polymorphism {
    public static void main(String[] args) {
        C obj = new CC(); // 부모가 자식 인스턴스를 참조한다(다형성)
        obj.a(); // 부모 함수는 호출이 가능하다.
        // obj.b(); 자식함수는 참조함에도 불구하고 호출이 불가능하다.

        // 다형성의 활용
        Animal lion = new Lion(); // 다형성으로 사자 참조
        Animal tiger = new Tiger();
        Zookeeper man = new Zookeeper();
        man.feed(lion); // 거점이 부모이기 때문에 만약 따로 먹이 주려면 feed(Lion lion) feed(Tiger tiger) 이렇게 따로 함수를 만들어야하는 불편함을 감수할 수 있다
        man.feed(tiger);
    }
}
/*
 --출력화면--
A출력
사자에게 먹이주기
호랑이에게 먹이주기
*/