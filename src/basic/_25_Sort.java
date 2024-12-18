package basic;

import java.util.Arrays;

class Compare implements Comparable { // 메소드 compareTo를 쓰기 위해서는 반드시 Comparable을 구현해야한다.
    // Comparable<Compare> 제네릭 타입을 달아두면 compareTo(Compare o)로 사용이 가능하다
    private String name;
    private int age;

    public Compare(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Object o) { // Arrays.sort시 정렬 기준을 정한다. Comparable타입이 없기 때문에 입력인자를 Object로 해야한다
        Compare p = (Compare) o;
        /*
        if (this.age > p.age) { // 서로 비교를 하여 p가 this보다 작으면 1을 반환하여 차순을 위로 염두해둔다.(오름차순)
            return 1;
        } else if (this.age < p.age) { // 서로 비교를 하여 p가 this보다 크면 -1을 반환하여 차순을 밑으로 염두해둔다.(오름차순)
            return -1;
        } else { // 서로 같으면 0 반환
            return 0;
        }
        */ // 아래가 더 간편
        // p.age는 Arrays.sort에 들어오는 새 인스턴스의 age값, this.age는 Compare(name,age)의 생성자에 들어오는 값
        return p.age - this.age; // 서로 비교를 하여 p가 this보다 크면 양수를 반환하여 차순을 위로 염두해둔다.(내림차순)

    }

    @Override
    public String toString() {
        return name + " : " + age;
    }
}

public class _25_Sort {
    public static void main(String[] args) {
        Compare[] ar = new Compare[3];
        ar[0] = new Compare("Lee", 29);
        ar[1] = new Compare("Goo", 26);
        ar[2] = new Compare("Soo", 40);

        Arrays.sort(ar); // 각 배열을 정렬한다

        for (Compare p : ar)
            System.out.println(p);
    }
}
/*
 --출력화면--
Soo : 40
Lee : 29
Goo : 26
*/