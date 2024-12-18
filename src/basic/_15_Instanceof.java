package basic;

class T {
    public void show() {
        System.out.println("T출력");
    }
}

class TT extends T {
    public void show2() {
        System.out.println("TT출력");
    }
}

class TTT extends TT {
    public void show3() {
        System.out.println("TTT출력");
    }
}

public class _15_Instanceof {
    public static void main(String[] args) {
        T t1 = new T();
        TT t2 = new TT();
        TTT t3 = new TTT();

        showT(t1);
        showT(t2);
        showT(t3);
    }

    public static void showT(T var) { // 부모 거점으로 입력
        if (var instanceof TTT) { // 이 참조 변수가 참조하는 ttt가 t의 상속자이면 true반환
            ((TTT) var).show3(); // ttt로 강제 형변환
        } else if (var instanceof TT) {
            ((TT) var).show2();
        } else {
            var.show();
        }
    }
}
