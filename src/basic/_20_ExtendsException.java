package basic;

import java.util.Scanner;

class AgeError extends Exception {
    public AgeError() {
        super("유효하지 않은 나이"); // e.getMessage()로 호출된다
        System.out.println("에러");
    }
}

public class _20_ExtendsException {
    public static void main(String[] args) {
        System.out.println("나이 입력 : ");
        try {
            Scanner kb = new Scanner(System.in);
            int age = kb.nextInt();
            if (age < 0) { // 음수 입력시
                throw new AgeError(); // throw 선언을 하면 예외가 발생된다. println("에러")만 호출
            }
        } catch (AgeError e) {
            System.out.println(e.getMessage());
        }
    }
}
