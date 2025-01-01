package record;

public record RecordSample2(int x, String y) {

    // record의 생성자는 입력 인자가 필요 없다.
    public RecordSample2 {
        x = x + 5;
        y = y + " plus";
    }
}
