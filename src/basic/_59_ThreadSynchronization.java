package basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class Counter {
    int count = 0;

    synchronized void increment() { // 메소드 전체에 동기화.
        count++;
    }

    public void decrement() {
        synchronized (this) { // 메소드 내에서 부분적으로 동기화. this는 이 인스턴스를 의미한다.
            count--;
        }
    }

    public int getCount() {
        return count;
    }

    ReentrantLock criticObj = new ReentrantLock(); // synchronized 대신할 클래스 생성

    public void lock() {
        criticObj.lock(); // 문을 잠근다.

        try {
            count += 2;
        } finally {
            criticObj.unlock(); // 문을 연다.
        }
        // 문을 잠근 것에서부터 열때까지 동기화를 한다.
    }
}

public class _59_ThreadSynchronization {
    public static Counter cnt = new Counter();

    public static void main(String[] args) throws InterruptedException {
        // 한개의 변수(count)에 접근시 동기화를 안하면 1000번 더하고 1000번 빼지만 0이 안나온다.
        // 값을 변화시키고 저장할 때 여러 스텝을 거치는데 스텝 도중 쓰레드가 다른 작업도 하여 값이 제대로 저장이 안된다. 동기화는 그 스텝이 다 끝날 때까지 기다려주게 한다.
        Runnable task1 = () -> {
            for (int i = 0; i < 1000; i++)
                cnt.increment(); // 값 1 감소
        };

        Runnable task2 = () -> {
            for (int i = 0; i < 1000; i++)
                cnt.decrement(); // 값 1 증가
        };

        ExecutorService exr = Executors.newFixedThreadPool(2); // 풀안에 2개의 쓰레드 생성 유지
        exr.submit(task1);
        exr.submit(task2);

        exr.shutdown();
        boolean isTeminated = exr.awaitTermination(3, TimeUnit.SECONDS); // shotdown() 메소드 호출 후, 모든 작업 처리를 시간내에 처리하면 true, 못하면 interrupt하고 false 리턴
        System.out.println(cnt.getCount());
        System.out.println(isTeminated);
    }
}
/*
 --출력화면--
0
true
*/