package basic;

public class SBox implements java.io.Serializable { // 인스턴스 기반의 스트림에서 입출력 대상이 되는 클래스는 java.io.Serializable를 구현해야한다
    String s; // 인스턴스 저장시 인스턴스 변수가 참조하는 인스턴스도 저장이 된다.

    // transient String s; -> 참조하는 인스턴스의 저장을 원치않을 때는 transient 선언한다. 읽을 때에 null로 읽힌다. int는 0오로 읽힌다.
    public SBox(String s) {
        this.s = s;
    }

    public String get() {
        return s;
    }
}
