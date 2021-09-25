package basic;

import java.util.*;

/*
    ListIterator<E>는 Iterator<E>의 하위이다.
    ListIterator<E>는 List<E>에 한해서 양방향 반복이 가능하다
*/
public class _31_ListIterator {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Toy", "Box");
        list = new ArrayList<>(list);

        ListIterator<String> litr = list.listIterator(); // 양방향 반복자 획득

        String str;
        while (litr.hasNext()) {
            str = litr.next(); // str로 따로 저장해둬야 오류가 안남
            System.out.print(str + '\t');
            if (str.equals("Toy")) {
                litr.add("Toy2"); // 추가하더라도 다음 next()는 안잡힌다.
            }
        }
        System.out.println();

        while (litr.hasPrevious()) { // 이전 존재시 반복문 실행
            str = litr.previous(); // str로 따로 저장해둬야 오류가 안남. 이전으로 이동
            System.out.print(str + '\t');
            if (str.equals("Toy2"))
                litr.add("Robot"); 
        }
    }
}
