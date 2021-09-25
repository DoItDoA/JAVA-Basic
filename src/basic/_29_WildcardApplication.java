package basic;

class Plastic {
    @Override
    public String toString() {
        return "Plastic";
    }
}

class Toy extends Plastic { // Plastic -> Toy -> Car 순으로 상속이 된다
    @Override
    public String toString() {
        return "Toy";
    }
}

class Car extends Toy {
    @Override
    public String toString() {
        return "Car";
    }
}

class ToyBox<T> {
    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}

// 슈셋익겟
class BoxHandler { // 여기서 물건 넣기, 꺼내기 이벤트 실행
    public static void setBox(ToyBox<? super Toy> box, Toy toy) { // 입력이 Toy이상(Toy, Plastic) 가능하다
        box.setObj(toy); // 오로지 <? super Toy>에서는 set만 사용가능

        // Toy getToy = box.getObj(); -> box.getObj()에서 box는 Toy,Plastic인데, Toy getToy에서 Toy가 Plastic을 참조할 수 없으므로 get은 사용불가
    }

    public static void getBox(ToyBox<? extends Toy> box) { // 입력이 Toy이하(Toy, Car) 가능하다
        Toy toy = box.getObj(); // 오로지 <? extends Toy>에서는 get만 사용가능
        System.out.println(toy);

        // box.setObj(new Toy()); -> box는 Toy,Car인데, ToyBox<Car>의 setObj에서 자식(Car)이 부모(Toy)의 인스턴스를 저장하는 것은 불가능하다
    }
}

class BoxMove {
    public static void moveBox(ToyBox<? extends Toy> from, ToyBox<? super Toy> to) {
        to.setObj(from.getObj()); // 복합 응용
    }
}

public class _29_WildcardApplication {
    public static void main(String[] args) {
        ToyBox<Toy> box = new ToyBox<>();
        BoxHandler.setBox(box, new Toy()); // 박스다루기 행동에서 장난감 담기
        BoxHandler.getBox(box); // 박스다루기 행동에서 장난감 꺼내기

        //-------------------------------------------
        ToyBox<Toy> box1 = new ToyBox<>(); // 토이박스 1 생성
        ToyBox<Toy> box2 = new ToyBox<>(); // 토이박스 2 생성
        box1.setObj(new Toy()); // 토이박스 1에 장난감 담기
        BoxMove.moveBox(box1, box2); // 토이박스 1에서 토이박스 2로 옮기기
        System.out.println("Move " + box2.getObj()); // 토이박스 2에서 장난감 꺼내기
    }
}
