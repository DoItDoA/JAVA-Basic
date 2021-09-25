package basic;

import java.util.Arrays;

public class _24_ArrayClass {
    public static void main(String[] args) {
        int[] arOrg = {3, 5, 1, 4, 2};
        Arrays.sort(arOrg); // 단순 내림차순
        int[] cpy = Arrays.copyOfRange(arOrg, 2, 5); // array복사 첫번째인자 복사대상, 두번째인자 2번째부터 세번째인자 5번째이전까지
        for (int i : cpy) {
            System.out.print(i + " ");
        }
        System.out.println();

        int idx = Arrays.binarySearch(arOrg,3); // 해당 배열에서 값찾기. 배열의 인덱스값 반환
        System.out.println(idx);
    }
}
