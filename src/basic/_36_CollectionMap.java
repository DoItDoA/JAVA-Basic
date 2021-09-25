package basic;

/*
    Map<K,V>은 Collection<E>을 상속하지 않는다
    Map은 Key를 이용하여 Value값을 찾는 기능이다.
    그래서 Key는 중복이어서 안된다.

    Map<K,V> -> HaspMap<K,V> 정렬되어 있지 않다
             -> TreeMap<K,V> 기본 오름차순 정렬되어 있다
*/

import java.util.*;

class AgeComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer n1, Integer n2) {
        return n2.intValue() - n1.intValue(); // 내림차순
    }
}

public class _36_CollectionMap {
    public static void main(String[] args) {
        Map<Integer, String> hMap = new HashMap<>();
        hMap.put(45, "Brown"); // Key와 Value 삽입
        hMap.put(37, "James");
        hMap.put(23, "Martin");

        Set<Integer> ksh = hMap.keySet(); // Key값들만 Set에 저장

        for (Integer n : ksh) {
            System.out.print(n.toString() + '\t');
            System.out.println(hMap.get(n)); // Key값을 이용하여 Value호출
        }
        System.out.println();

        //----------------------------------------------------------------
        Map<Integer, String> tMap = new TreeMap<>(new AgeComparator()); // Comparator를 이용하여 내림차순 설정
        tMap.put(45, "Brown");
        tMap.put(37, "James");
        tMap.put(23, "Martin");

        Set<Integer> kst = tMap.keySet();
        
        for (Integer n : kst) {
            System.out.print(n.toString() + '\t');
            System.out.println(hMap.get(n));
        }

    }
}
