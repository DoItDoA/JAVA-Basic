package basic;

class UFC<T> {
    protected T obj; // 제한범위 상속자까지

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}

class KO {
    public static <T extends String> UFC<T> makeU(T obj) { // <T>매개변수 타입을 알리고 UFC<T>가 반환형이다. 메소드도 제한이 가능하다 
        UFC<T> uuu = new UFC<>(); // 클래스 UFC 인스턴스 생성
        uuu.setObj(obj);
        return uuu;
    }
}
//----------------------------------------------------------------------------------------------------------

class KKK<T> extends UFC<T> { // 제네릭도 서로 상속이 가능하다
    public KKK(T obj) {
        this.obj = obj;
    }
}

public class _27_GenericMethod {
    public static void main(String[] args) {
        UFC<String> sss = KO.makeU("Sweet"); // 원래는 KO.<String>makeU이지만  UFC<String>를 보고 타입이 String이어서 유추하여 생략가능
        System.out.println(sss.getObj());

        //--------------------------------------------------------

        UFC<String> kkk = new KKK<>("Simple"); // 상속관계의 제네릭 클래스는 반드시 타입이 일치하여야한다. 부모가 Number 자식이 Integer여도 안된다
        System.out.println(kkk.getObj());
    }
}
