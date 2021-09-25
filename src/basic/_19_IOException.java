package basic;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class _19_IOException {
    public static void main(String[] args) {
        try {
            md1();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void md1() throws IOException, IndexOutOfBoundsException { // 예외가 2개 이상이면 이렇게 쓴다
        md2();
    }

    public static void md2() throws IOException { // throws IOException은 IOException예외가 메소드내에서 발생할 경우 위로 예외처리를 넘긴다.
        Path file = Paths.get("C:\\Users\\USER\\Desktop\\프로그래밍\\not\\simple.txt"); // 중간경로에 not없어 IO오류 발생. 해당 경로파일을 참고하기. simple.txt는 없으면 생성된다
        BufferedWriter writer = Files.newBufferedWriter(file); // 해당 파일에 작성버퍼 생성
        writer.write("A"); // 텍스트파일에 A작성
        writer.write("Z");

        if (writer != null)
            writer.close(); // 버퍼 종료
    }
}
