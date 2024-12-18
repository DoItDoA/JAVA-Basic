package basic;

enum Person { // enum은 값의 열거를 나타내는 역할을 한다.
    MAN(29), WOMAN(25); // MAN과 WOMAN은 생산자를 대변하기 때문에 생산자 양식에 맞춰서 쓴다.
    int age;

    private Person(int age) { // 열거형의 생성자는 반드시 private를 붙여야한다.
        System.out.println("Constructor");
        this.age = age;
    }

    @Override
    public String toString() {
        return "I am " + age + " years old";
    }
}

public class _39_Enum {
    public static void main(String[] args) {
        // 출력시 "Constructor"가 두 번 출력되고 나이가 출력이 되는데 열거형 값이 존재하기 이전에 생성자 호출이 두 번 이뤄진다.
        System.out.println(Person.MAN);
        System.out.println(Person.WOMAN);
    }
}
/*
 --출력화면--
Constructor
Constructor
I am 29 years old
I am 25 years old
*/