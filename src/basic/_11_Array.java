package basic;

import java.util.Arrays;

class ddd {
    private String str;

    ddd(String str) {
        this.str = str;
    }

    public String toString() {
        return str;
    }
}

public class _11_Array {
    public static void main(String[] args) {
        ddd[] ar = new ddd[2]; // 클래스를 배열로 만들기

        ar[0] = new ddd("first"); // 각 배열에 새로 인스턴스 생성하여 값 저장
        ar[1] = new ddd("second");

        for (ddd e : ar) { // 배열 for문은 이렇게 사용하는 것이 편하다 (클래스 명칭아무거나 : 참조변수)
            System.out.println(e);
        }

        String[] ar1 = {"1", "2"}; // 이렇게 줄여서 표현 가능. String[] ar1 = new String[] {"1","2"}도 표현 가능. 다만 클래스(ddd)는 불가능
        int[] ar2 = {1, 2};

        int[] ar3 = new int[10]; // 초기화값은 전부다 0이다
        Arrays.fill(ar3, 7); // 초기화를 7로 변경
        for (int e : ar3) {
            System.out.print(e);
        }

        int[][] arr = { // 2차원 배열의 초기화
                {11},
                {22, 33},
                {44, 55, 66}
        };

    }
}
