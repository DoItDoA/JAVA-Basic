package basic;

class WildBox<T> {
    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return obj.toString();
    }
}

// 와일드카드는 기능적으로 제네릭과 차이가 없다. 즉 어느 것을 써도 무방하다
class GetBox {
    // 'public static <T> void getBox(WildBox<T> box)'의 <T>와 <?>는 기능적으로 같다. Object역할을 한다. 다만 <T>는 void앞에 <T>가 더있어 <?>가 간편하고 보기 좋다
    public static void getBox(WildBox<?> box) { // 와일드 카드는 메소드의 입력인자에만 쓰인다. 클래스의 타입정할때는 쓸 수가 없다.
        System.out.println(box);
    }

    // 'public static <T> void peekBox(WildBox<T extends Number> box)'와 기능적으로 같다. 다만 와일드카드가 보기가 더 좋다. 이유는 위와 같다
    public static void peekBox(WildBox<? extends Number> box) { // Number이하(Number,Integer,Double...)만 입력인자로 받아들인다.
        System.out.println(box);
    }

    // super는 제네릭에는 없는 기능이다. 즉 와일드카드에만 있다
    public static void underBox(WildBox<? super Integer> box) { // Integer이상(Integer,Number,Object)만 입력인자로 받아들인다
        System.out.println(box);
    }
}

public class _28_Wildcard {
    public static void main(String[] args) {
        WildBox<String> box = new WildBox<>();
        box.setObj("simple");
        GetBox.getBox(box);

        WildBox<Integer> box1 = new WildBox<>();
        box1.setObj(111111);
        GetBox.peekBox(box1); // <? extends Number>되어 있어 Number이하로 입력해봤다

        WildBox<Number> box2 = new WildBox<>();
        box2.setObj(222222);
        GetBox.underBox(box2); // <? super Integer>되어 있어 Integer이상으로 입력해봤다
    }
}
