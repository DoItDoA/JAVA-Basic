package basic;

/*
    컬렉션 프레임워크의 골격 중
    Collection<E> -> Set<E> -> HashSet<E> 저장 순서가 유지 안되고, 중복 허용X
                            -> TreeSet<E> 기본 오름차순 유지하면서, 중복 허용X
    Set은 Collection을 상속하여 Collection의 하위이다.
*/

import java.util.*;

class HashNum {
    private int num;

    public HashNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }

    @Override // Object클래스의 메소드이다
    public int hashCode() { // 해당클래스에 들어온 값을 분류하여 나중에 equals가 처리하기 좀 더 쉽게 해준다
        return num % 3; // 나머지가 0,1,2 이렇게 3분류로 나눠져 각 분류된 값끼리 equals가 처리하게 한다.
        // 분류 기준은 % 2(2분류)하여 너무 적거나 % 10000(10000분류)하여 너무 많게 분류하지 않고 적절히 분류하도록한다
    }

    @Override // Object클래스의 메소드이다
    public boolean equals(Object obj) { // 해당 인스턴스(new HashNum(7777))를 입력인자로 읽는다
        if (num == ((HashNum) obj).num) // 분류된 값과 해당 인스턴스의 넘버값과 비교하여 동일하면 true 반환
            return true;
        else
            return false;
    }
}

class Vehicle {
    private String model;
    private String color;

    public Vehicle(String model, String color) {
        this.model = model;
        this.color = color;
    }

    @Override
    public String toString() {
        return model + " : " + color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, color); // 입력 인자가 여러개일 때 Objects.hash를 이용하면 좋다
        // return (model.hashCode() + color.hashCode()) / 2; -> 이 방법도 되지만 번거롭다.

    }

    @Override
    public boolean equals(Object obj) {
        String ObjModel = ((Vehicle) obj).model;
        String ObjColor = ((Vehicle) obj).color;
        if (model.equals(ObjModel) && color.equals(ObjColor))
            return true;
        else
            return false;
    }
}

public class _32_CollectionHashSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Toy");
        set.add("Box");
        set.add("Box"); // 중복 확인 위해 삽입

        for (String s : set)
            System.out.print(s + '\t'); // 출력시 중복은 출력이 안됨
        System.out.println();

        //------------------------------------------------------------
        Set<HashNum> setNum = new HashSet<>();
        setNum.add(new HashNum(7777)); // 둘의 입력값은 같아보이지만 서로 다른 인스턴스여서 중복처리가 안되어 둘다 출력이 된다
        setNum.add(new HashNum(7777)); // HashNum클래스 안의 hashCode()와 eqauls()를 통해 동일 인스턴스로 간주하여 하나만 출력되게 한다

        for (HashNum n : setNum)
            System.out.print(n.toString() + '\t'); // toString()을 사용하여 '+'와 같이 사용가능하게 한다.
        System.out.println();

        //------------------------------------------------------------
        Set<Vehicle> setString = new HashSet<>();
        setString.add(new Vehicle("HY", "RED"));
        setString.add(new Vehicle("HD", "RED"));
        setString.add(new Vehicle("HY", "RED"));

        for (Vehicle car : setString)
            System.out.println(car);

        //------------------------------------------------------------
        List<String> list = Arrays.asList("Box", "Toy", "Box"); // List는 중복이 허용된다.
        list = new ArrayList<>(list);
        Set<String> removeSet = new HashSet<>(list); // Set으로 중복 제거
        list = new ArrayList<>(removeSet); // 다시 List변경

        for (String l : list)
            System.out.print(l.toString() + '\t');
    }
}
