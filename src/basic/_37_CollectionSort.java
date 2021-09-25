package basic;

import java.util.*;

class Bus implements Comparable<Bus> {
    protected int disp;

    public Bus(int disp) {
        this.disp = disp;
    }

    @Override
    public int compareTo(Bus obj) {
        return disp - obj.disp;
    }
}

class EBus extends Bus {
    private int battery;

    public EBus(int disp, int battery) {
        super(disp); // Bus의 생성자
        this.battery = battery;
    }

    @Override
    public String toString() {
        return "cc : " + disp + ", battery : " + battery;
    }
}

class BusCompare implements Comparator<Bus> {
    @Override
    public int compare(Bus obj1, Bus obj2) {
        return obj2.disp - obj1.disp; // 내림차순
    }
}

public class _37_CollectionSort {
    public static void main(String[] args) {
        List<EBus> list = new ArrayList<>();
        list.add(new EBus(1200, 99));
        list.add(new EBus(3000, 55));
        list.add(new EBus(1800, 87));

        /*
        sort는 구성이 'public static <T Extends Comparable<? super T>> void sort(List<T> list)'이다
        조금 더 간단히 구성하자면 '<T Extends Comparable<T>> void sort(List<T> list)'로 볼 때, <T>는 comparable을 구현한 상태이여야한다.
        List<Bus>면 문제가 없지만 Bus를 상속한 List<EBus>일 경우, '<EBus Extends Comparable<EBus>> void sort(List<EBus> list)'에서
        Bus는 Comparbale 구현하지만 EBus는 직접 구현하지 않고 간접 구현하기 때문에 위의 방식이 맞지 않다. 그래서 <? super T>를 사용한다.
        즉 '<EBus Extends Comparable<? super EBus>> void sort(List<EBus> list)'에서 <? super EBus>는 EBus의 상위도 가능하므로
        Bus도 포함되고, Bus는 Comparable을 구현하기 때문에 사용이 가능하다.

        결론은 Comparable을 구현한 클래스의 자손들도 Collections.sort를 이용하여 정렬이 가능하다.
        */
        Collections.sort(list); // 핵심요소 

        for (Iterator<EBus> itr = list.iterator(); itr.hasNext(); )
            System.out.println(itr.next());
        System.out.println();

        // Comparator를 이용한 정렬
        BusCompare comp = new BusCompare();
        // sort 구성이 'public static <T> void sort(List<T> list, Comparator<? super T> comp)
        // public static <EBus> void sort(List<EBus> list, Comparator<? super EBus> comp)
        Collections.sort(list,comp);

        for (Iterator<EBus> itr = list.iterator(); itr.hasNext(); )
            System.out.println(itr.next());

    }
}
