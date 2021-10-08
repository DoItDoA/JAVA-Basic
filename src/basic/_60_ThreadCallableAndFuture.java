package basic;

import java.util.concurrent.*;

public class _60_ThreadCallableAndFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<Integer> task = () -> { // Callable<T> 로 반환하여 쓰레드가 반환값도 가질 수가 있다. Callable 메소드는 call()
            int sum = 0;
            sum += 5;
            return sum;
        };

        ExecutorService exr = Executors.newSingleThreadExecutor();
        Future<Integer> fur = exr.submit(task); // 반환 값을 Future에 저장
        Integer r = fur.get(); // 쓰레드의 반환값 획득
        System.out.println(r);
        exr.shutdown();
    }
}
