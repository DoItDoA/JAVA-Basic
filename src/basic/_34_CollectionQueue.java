package basic;

import java.util.LinkedList;
import java.util.Queue;

/*
    컬렉션 프레임워크의 골격 중
    Iterable<T> -> Collection<E> -> Queue<E> -> LinkedList<E>
    Queue는 Collection을 상속하여 Collection의 하위이다.
    Queue 넣은 순서대로 먼저 제거가 되는 구조이다 Fist In First Out
*/

public class _34_CollectionQueue {
    public static void main(String[] args) {
        Queue<String> que = new LinkedList<>();
        que.offer("Box"); // 넣기, 넣을 공간 부족하며 false 반환
        que.offer("Toy");
        que.offer("Robot");

        System.out.println(que.poll()); // 꺼내기, 꺼낼 대상없으면 null 반환
        System.out.println("check : " + que.peek()); // 확인, 확인할 대상 없으면 null 반환
        System.out.println(que.poll());
        System.out.println(que.poll());
    }
}
