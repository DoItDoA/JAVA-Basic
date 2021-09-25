package basic;

import java.util.*;

/*
    컬렉션 프레임워크의 골격 중
    Iterable<T> -> Collection<E> -> List<E> -> ArrayList<E> 장점 : 저장된 인스턴스 참조가 빠르다. 즉 인덱스값을 통해 빠르게 접근. 단점 : 저장, 삭제시 느리다
                                            -> LinkedList<E> 장점 : 저장, 삭제시 빠르다. 단점 저장된 인스턴스 참조가 느리다.
    List는 Collection을 상속하여 Collection의 하위이다.
*/


public class _30_CollectionList {
    public static void main(String[] args) {
        List<String> baseList = new ArrayList<>(); // 기본 List 참조, 참조 클래스에서 ArrayList가 아닌 List를 쓰는 이유는 LinkedList로 바꾸기 위한 유연성 
        baseList.add("Toy"); // 리스트 추가
        baseList.get(0); // 리스트 참조
        baseList.remove(0); // 리스트 삭제, 삭제시 삭제된 공간은 남지 않고 다음 인텍스 값이 앞당겨져 공간을 메꾼다
        // ex) 1 3 2에서 3 삭제시 1 □ 2 가 아니고 1 2 가 된다, 배열 사이즈도 2로 변함, 일반 배열은 삭제도 어렵고 삭제 시 빈공간이 남는다.

        List<String> list = Arrays.asList("Toy", "Box", "Robot", "Box"); // asList를 사용하여 배열 값을 초기화할 수 있다. 다만 해당 배열의 삭제,추가가 불가능하다
        list = new LinkedList<>(list); // 삭제가 불가능한 list를 새로운 LinkedList(또는 ArrayList)를 만들어 거기에 복사하여 삭제, 추가가 가능하게 한다

        // List는 Iterable의 하위여서 Iterable의 함수를 사용할 수 있다.
        // 처음에 list에 iterator함수를 써 Iterator가 참조하게 한다. 맨 처음은 "Toy"이전 아무것도 아닌 것(무)을 가리킨다
        for (Iterator<String> itr = list.iterator(); itr.hasNext(); ) { // hasNext()를 통해 다음이 있으면 반복이 실행 
            if (itr.next().equals("Box")) // 다음이 있으므로 다음(next())을 통해 값이 "Box"이면 실행
                itr.remove(); // 해당값 제거
        }

        list = new ArrayList<>(list); // 해당 리스트를 ArrayList로 복사

        for (Iterator<String> itr = list.iterator(); itr.hasNext(); ) {
            System.out.print(itr.next() + '\t'); // next()를 통해 출력
        }
    }
}