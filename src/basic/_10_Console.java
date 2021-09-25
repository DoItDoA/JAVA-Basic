package basic;

import java.util.Scanner;

class Camera {
    private String str;

    Camera(String str) {
        this.str = str;
    }

    public String toString() {
        return str;
    }
}

public class _10_Console {
    public static void main(String[] args) {
        Camera camera = new Camera("box");
        System.out.println(camera); // 클래스내부에 문자열 반환 함수가 있어 참조변수만 적어도 출력이 된다

        Scanner sc = new Scanner(System.in); // System.in 대신 "1 2"이렇게 넣어 입력을 하드코딩으로 줄수 있다

        System.out.println("문자열 입력 : ");
        String str = sc.nextLine();

        System.out.println("숫자 입력 : ");
        int num = sc.nextInt();

        System.out.println("소수 입력 : ");
        double num2 = sc.nextDouble();

        System.out.println("출력 " + str + " " + num + " " + num2);
    }
}
