package basic;

abstract class Pokemon { // abstract도 인터페이스와 마찬가지로 오버라이딩 양식 구현한다
    String name;

    abstract void attack(); // 메소드 앞에 abstract가 붙은 것만 양식으로 한다

    public String getName() { // 일반 메소드는 상속된다
        return this.name;
    }
}

class Pikachu extends Pokemon {
    Pikachu() {
        this.name = "피카츄"; // 부모 변수에 저장
    }

    @Override
    void attack() {
        System.out.println("전기쇼크");
    }
}

public class _17_Abstract {
    public static void main(String[] args) {
        Pokemon pikachu1 = new Pikachu();
        System.out.println(pikachu1.getName());
        pikachu1.attack();
    }
}
/*
 --출력화면--
피카츄
전기쇼크
*/