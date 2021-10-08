package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class _61_ThreadCollection {
    public static List<Integer> list = Collections.synchronizedList(new ArrayList<>()); // synchronizedXXX로 전달

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 16; i++)
            list.add(i); // 동기화 처리된 컬렉션 인스턴스에 하나씩 저장

        Runnable listTask = () -> {
            synchronized (list) { // 반복자도 동기화를 해야한다. 이 영역에 실행 시 list에 다른 쓰레드 접근 불가
                ListIterator<Integer> itr = list.listIterator();
                while (itr.hasNext())
                    itr.set(itr.next() + 1); // 1씩 더하고 저장
            }
        };

        ExecutorService exr = Executors.newFixedThreadPool(3); // 쓰레드 3개 실행하니 list에 3씩 더해진다.
        exr.submit(listTask);
        exr.submit(listTask);
        exr.submit(listTask);

        exr.shutdown();
        boolean s = exr.awaitTermination(2, TimeUnit.SECONDS); // 각 쓰레드가 처리 중이므로 shutdown후 2초 있다가 종료하거나 다 끝나면 종료시킨다.
        System.out.println(list); // awaitTermination가 없으면 main 쓰레드 작업으로 list 연산 처리 끝나서 3씩 더하기 결과 나오기전에 그대로 출력이 된다.
        System.out.println(s);
    }
}
