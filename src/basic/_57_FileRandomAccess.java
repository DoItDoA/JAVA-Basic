package basic;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class _57_FileRandomAccess {
    public static void main(String[] args) {
        Path fp = Paths.get("random.dat");

        ByteBuffer wb = ByteBuffer.allocate(1024); // 처음 버퍼 position 0

        wb.putInt(120); // 버퍼에 int형 데이터 저장. 버퍼 position 4로 변함 (+4)
        wb.putInt(240); // 버퍼 position 8로 변함 (+4)
        wb.putDouble(0.94); // 버퍼 position 16으로 변함 (+8)
        wb.putDouble(0.75); // 버퍼 position 24로 변함 (+8)

        try (FileChannel fc = FileChannel.open(fp,
                StandardOpenOption.CREATE,
                StandardOpenOption.READ,
                StandardOpenOption.WRITE)) // 입출력 채널 생성
        {
            wb.flip(); // 버퍼 position을 0으로 변경하고 데이터 읽기 모드로 변경
            fc.write(wb); // 버퍼에서 데이터 읽어 채널로 데이터 전송. 채널의 position이 24로 변함

            ByteBuffer rb = ByteBuffer.allocate(1024);
            fc.position(0); // 채널의 position 0으로 변경
            fc.read(rb); // 채널로부터 데이터를 읽어 버퍼에 저장. 이때 버퍼 position이 24로 변함

            rb.flip(); // 버퍼 position을 0으로 하고 읽기모드로 변경
            System.out.println(rb.getInt()); // 읽고 나면 position이 4로 변함
            rb.position(Integer.BYTES * 2); // position 0부터 기준으로부터 8로 변경
            System.out.println(rb.getDouble()); // position 16으로 변경
            System.out.println(rb.getDouble()); // position 24로 변경

            rb.position(Integer.BYTES); // position 0부터 기준으로부터 4로 변경
            System.out.println(rb.getInt());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
 --출력화면--

*/