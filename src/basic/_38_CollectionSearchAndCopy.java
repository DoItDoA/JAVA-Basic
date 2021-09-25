package basic;

import java.util.*;

class StrCompare implements Comparator<String> {
    @Override
    public int compare(String obj1, String obj2) {
        return obj1.compareToIgnoreCase(obj2); // 대소문자 구별없이 비교
    }
}

public class _38_CollectionSearchAndCopy {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Robot");
        list.add("Apple");
        list.add("Box");

        Collections.sort(list); // 찾기이전에 해당 컬렉션 인스턴스가 정렬된 상태여야한다.
        System.out.println(list); // 정렬된 인스턴스
        int idx = Collections.binarySearch(list, "Robot"); // 인덱스값 반환, 없으면 음수 반환
        System.out.println(idx + " " + list.get(idx)); // 인덱스 및 값 출력

        // Comparator를 이용한 찾기
        StrCompare comp = new StrCompare();
        Collections.sort(list, comp);
        System.out.println(list);
        int idx2 = Collections.binarySearch(list, "Robot", comp); // 3번째 인자 Comparator인스턴스를 추가한다.
        System.out.println(idx2 + " " + list.get(idx2));

        // 복사하기
        List<String> src = Arrays.asList("로봇", "사과", "박스");
        src = new ArrayList<>(src);

        Collections.sort(src); // 복사이전에 정렬부터한다.
        Collections.copy(list, src); // src의 내용을 list에 덮어씌우기. 덮어씌어질 공간이 적어도 src보다 크거나 같아야한다.
        System.out.println(list);

    }

}

