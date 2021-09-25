package basic;

/*
    제네릭 이름 규칙
    대문자로 한글자 쓴다.
    E - Element
    K - Key
    N - Number
    T - Type
    V - Value
*/

// 제네릭은 클래스에서 들어오는 입력인자의 타입을 정한다
class Person1<T, N extends Number> { // 다중 매개변수 설정시, 또한 상속을 이용하여 이 클래스에 대해서만 사용의 제한을 줄 수 있다. (Number이하 클래스 말고는 다른 것은 안됨)
    private T name;
    private N age;

    public void set(T name, N age) { // 클래스 제네릭 설정식 보통 생성자사용
        this.name = name;
        this.age = age;
    }

    public int toIntValue() {
        return age.intValue(); // N이 Number로 제한되어 있어 Number클래스의 intValue사용 가능, 제한 되어있지않으면 사용불가
    }
}

// ---------------------------------------------------------------------------------------------------------------

interface Eatable<String> { // 인터페이스도 제네릭으로 설정 가능. <T>로도 표현이 가능하다
    public String eat();
}

class Apple implements Eatable<String> {
    @Override
    public String eat() {
        return "eat";
    }
}

class AppleBox<T extends Apple & Eatable<String>> { // 동시에 여러개 제한시 & 이용. 원래는 Eatable만 제한해도 무방
    private T obj;

    public void setObj(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        System.out.println(obj.eat()); // Eatable로 제한했기 때문에 Eatable내 메소드 사용 가능. Eatable은 Apple에 오버라이딩 되어서 "eat"이 출력된다
        return obj;
    }
}

public class _26_Generics {
    public static void main(String[] args) {
        Person1<String, Integer> man = new Person1<>(); // 인스턴스 생성시 타입을 정하며(기본형 int등은 사용불가 오로지 클래스만) 왼쪽이 정해졌으면 오른쪽은 생략해도 무방하다
        man.set("Hee", 25);

        //----------------------------------------------------------------------------------------------------

        AppleBox<Apple> box = new AppleBox<>(); // Box에 Apple클래스로 입력 타입 정함
        box.setObj(new Apple());

        Apple apple = box.getObj();
    }
}
