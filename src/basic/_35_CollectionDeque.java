package basic;

/*
    Stack<E>는 사용이 가능하지만 성능이 저하되어 양방향에서 넣고 꺼내는 Deque를 사용하기를 권장한다.
    우선 Stack의 구조는 먼저 넣은 데이터가 가장 나중에 꺼내지는 First In Last Out이다

    컬렉션 프레임워크의 골격 중
    Collection<E> -> Queue<E> -> Deque<E> -> ArrayDeque<E>
                                          -> LinkedList<E>
    Queue는 Collection을 상속하여 Collection의 하위이다.
*/

import java.util.ArrayDeque;
import java.util.Deque;

interface IStack<E> {
    public boolean push(E item);

    public E pop();
}

class CStack<E> implements IStack<E> {
    private Deque<E> deq;

    public CStack(Deque<E> deq) {
        this.deq = deq;
    }

    @Override
    public boolean push(E item) { // 실수로 offerLast를 넣을 수도 있으나 구조화로 인해 offerFist만 사용 가능
        return deq.offerFirst(item);
    }

    @Override
    public E pop() { // 실수로 pollLast를 넣을 수도 있으나 구조화로 인해 pollFist만 사용 가능
        return deq.pollFirst();
    }
}

public class _35_CollectionDeque {
    public static void main(String[] args) {
        Deque<String> deq = new ArrayDeque<>();

        deq.offerFirst("Box"); // 앞으로 넣기
        deq.offerLast("Robot"); // 뒤로 넣기
        deq.offerFirst("Toy");

        System.out.println(deq.pollFirst()); // 꺼낼때는 최근에 넣은 순으로 꺼낸다
        System.out.println(deq.pollFirst());
        System.out.println("check : " + deq.peekFirst()); // 확인
        System.out.println(deq.pollLast()); // 뒤로 꺼내기
        System.out.println();

        //Stack 구조화하기
        IStack<String> stk = new CStack<>(new ArrayDeque<String>()); // 해당 클래스에 배열 인스턴스 넣기
        stk.push("1.Box");
        stk.push("2.Toy");
        stk.push("3.Robot");

        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
    }
}
/*
 --출력화면--
Toy
Box
check : Robot
Robot

3.Robot
2.Toy
1.Box
*/