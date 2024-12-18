package basic;

import java.util.concurrent.*;

class Task extends Thread { // Thread를 구현해야 쓰레드가 된다.
    public void run() { // run 안에 작업 구현
    }
}

public class _58_Thread {
    public static void main(String[] args) throws InterruptedException {
        // 쓰레드 작업 1
        Runnable task1 = () -> { // 쓰레드 작업시 반드시 Runnable 구현. Runnable은 run 메소드 하나만 있다.
            String name = Thread.currentThread().getName(); // 현재 쓰레드의 이름를 가져온다
            System.out.println("쓰레드 이름 : " + name);
            try {
                for (int i = 0; i < 20; i++) {
                    if (i % 2 == 0)
                        System.out.print(i + " ");
                    Thread.sleep(100); // 0.1초마다 쓰레드 작업함
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };
        // 쓰레드 작업 2
        Runnable task2 = () -> {
            String name = Thread.currentThread().getName();
            System.out.println("쓰레드 이름 : " + name);
            try {
                for (int i = 0; i < 20; i++) {
                    if (i % 2 == 1)
                        System.out.print(i + " ");
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };


        Thread t1 = new Thread(task1, "Anything"); // 쓰레드 생성, 첫번째에 쓰레드 작업을 가져오고, 두번째는 쓰레드 이름 설정
        Thread t2 = new Thread(task2);

        // 현재 쓰레드는 총 3개이다. main, task1, task2
        t1.start(); // 쓰레드 작업 시작. 먼저 시작했다고 t1이 t2보다 먼저 작업하는 것은 아니다.
        t2.start();

        String name = Thread.currentThread().getName();
        System.out.println("쓰레드 이름 : " + name);

        t1.join(); // t1 작업이 끝날 때까지 기다린다.
        t2.join(); // t2 작업이 끝날 때까지 기다린다.

        System.out.println("End"); // t1,t2 작업이 끝나면(쓰레드 소멸) 호출. 만약 join이 없다면 main 작업대로 하여 바로 호출 된다

        Task t = new Task(); // Runnable 없이 쓰레드 생성.(잘 안쓴다)

        // 쓰레드 풀 생성하여 쓰레드 재활용
        // 쓰레드 생성과 소멸은 부담이 간다. 그래서 풀을 만들어 그 안에 쓰레드 생성한다. 그 쓰레드를 꺼내 작업하고 끝나면 쓰레드는 다시 풀로 돌아가 대기한다.
        Runnable task3 = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " : " + (10 + 20));
        };

        ExecutorService exr = Executors.newSingleThreadExecutor(); // 풀 생성하고 하나의 쓰레드를 만들어 유지. newCachedThreadPool 작업의 수에 맞게 쓰레드 수를 유동적으로 관리
        exr.submit(task3); // 쓰레드 풀에 작업전달

        exr.submit(() -> { // 풀 안에 람다식 전달도 가능
            String name1 = Thread.currentThread().getName();
            System.out.println(name1 + " : " + (5 * 7));
        });

        exr.shutdown(); // 쓰레드 풀과 그 안에 있는 쓰레드의 소멸
    }
}
/*
 --출력화면--
쓰레드 이름 : main
쓰레드 이름 : Anything
0 쓰레드 이름 : Thread-0
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 End
pool-1-thread-1 : 30
pool-1-thread-1 : 35
*/