package record;

public class Main {
    public static void main(String[] args) {
        RecordSample r = new RecordSample(1, "card");
        RecordSample rAnother = new RecordSample(1, "card");
        RecordSample2 r2 = new RecordSample2(1, "card");

        System.out.println(r);
        System.out.println(r.equals(rAnother));
        System.out.println(r2);
    }
}
