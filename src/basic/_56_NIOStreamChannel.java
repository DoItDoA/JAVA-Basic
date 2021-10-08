package basic;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/*
  채널은 스트림과 달리 입력과 출력 양방향으로 데이터 이동이 가능하다.
  채널은 반드시 버퍼에 연결해서 사용해야한다.
  채널의 출력 경로                             채널의 입력 경로            
  데이터 -> 버퍼 -> 채널 -> 파일                파일 -> 채널 -> 버퍼 -> 데이터
  
  복사 경로
  파일 -> 채널 -> 버퍼 -> 채널 -> 파일
  *기존의 I/O 스트림으로 복사하면 입력 버퍼와 출력 버퍼 2개를 이용하지만, 채널은 버퍼 1개를 이용하여 좀 더 효율적이다.
*/
public class _56_NIOStreamChannel {
    public static void main(String[] args) {
        // 채널을 이용한 카피
        Scanner sc = new Scanner(System.in);
        System.out.print("대상 파일 : ");
        Path src = Paths.get(sc.nextLine());

        System.out.print("사본 이름 : ");
        Path dst = Paths.get(sc.nextLine());

        ByteBuffer buf = ByteBuffer.allocate(1024); // 1024바이트 버퍼 생성. 입출력 파일의 크기가 작고 빈번할 때 사용
        // ByteBuffer buf = ByteBuffer.allocateDirect(1024); -> 파일의 크기가 크고 빈번하지 않을 때 사용
        
        try (FileChannel inputC = FileChannel.open(src, StandardOpenOption.READ); // 원본으로부터 읽기 위한 입력용 채널 생성
             FileChannel outputC = FileChannel.open(dst, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) // 복사본에 쓰기 위한 출력용 채널 생성, CREATE는 위의 설명참조
        {
            int num;
            while (true) {
                num = inputC.read(buf); // 입력용 채널에서 버퍼로 읽어들임
                if (num == -1)
                    break;
                buf.flip(); // 데이터들이 버퍼의 position 0부터 n번째까지 하나씩 쌓여 있다. 이때 position은 n을 가리키는데 flip은 다시 position을 0으로 하여 처음부터 데이터 읽게 만듬  
                outputC.write(buf); // 버퍼에서 데이터를 읽어 출력용 채널로 데이터 전송
                buf.clear(); // 버퍼 비우기
                // buf.compact(); -> 버퍼에서 읽은 데이터만 지운다. clear() 대신 사용 가능
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
