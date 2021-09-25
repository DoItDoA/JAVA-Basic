package basic;

public class _18_ExceptionHandling {
    public static void md2(int n1, int n2) {
        int r = n1 / n2; // 제일 먼저 여기서 예외 발생, 예외 처리를 못했으므로 위로(md1) 예외 떠넘김
    }

    public static void md1(int n) {
        md2(n, 0); // 넘겨받은 예외 처리를 못하므로 위로(main) 예외 떠넘김
    }

    public static void main(String[] args) {
        try {
            md1(3); // 넘겨받은 예외를 catch로 넘긴다.
        } catch (Throwable e) { // Throwable은 최상위 예외 클래스이다. 최상위 예외 클래스를 상속하는 Exception을 써도 된다
            e.printStackTrace(); // 오류 경로 추적
        }
        System.out.println("end"); // try catch문이 없으면 예외 처리 못하므로 가상머신이 예외처리하고 종료한다. 즉 "end"가 출력인 안됨
    }
}
