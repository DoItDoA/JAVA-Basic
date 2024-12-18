package basic;

/*
   Output은 Java Program에서 파일로 이동하여 생성
*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class _53_IOStreamOutput {
    public static void main(String[] args) {
        // 바이트 스트림
        // I/O Stream은 스트림 생성 후 finally에서 close() 사용하여 매번 닫아줘야하는데, try-with-resources문은 try() 괄호 안에 스트림 생성코드 쓰면 close도 자동으로 해준다
        try (DataOutputStream out =
                     new DataOutputStream( // 파일에 데이터 전송시 자료형(int 등)을 구성하게 하는 필터스트림
                             new BufferedOutputStream( // 파일 전송시 1Byte씩 써서보내지만  버퍼 필터스트림 생성하여 데이터를 모아서 한번에 전송시킨다.
                                     new FileOutputStream("data.dat"))))  // 출력스트림 생성. 파일이 생성되며 확장자는 아무거나해도 되지만 기본적으로 dat 쓴다
        {
            out.writeInt(7); // int형 데이터 저장
            out.writeDouble(3.14); // double형 데이터 저장

            // flush()는 write 메소드를 통해 데이터를 저장했음에도 불고하고 저장안되는 경우가 있는데 중요한 데이터가 있다면 버퍼를 비우고 저장하게 한다. 자주쓰면 성능 저하
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 원하는 경로 바이트 스트림
        Path fp = Paths.get("IOStreamDir/data.dat"); // 경로 가져오기, 상대경로, NIOStream 참조
        try (DataOutputStream out =
                     new DataOutputStream(
                             new BufferedOutputStream(
                                     Files.newOutputStream(fp))))  // 해당 경로로 출력 스트림 생성
        {
            out.writeInt(77777);
            out.writeDouble(3.1444444);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 문자 스트림
        String ks = "공부에 있어서 돈이 꼭 필요한 것은 아니다.";
        String es = "Life is long if you know how to use it.";
        try (BufferedWriter bw =
                     new BufferedWriter( // 문자열을 한번에 모아서 보냄
                             new FileWriter("String.txt"))) // 바이트 스트림과 같이 1Byte 보내지만 자바에서 쓰인 문자를 OS가 읽을 수 있게 인코딩함. 즉 파일을 열면 읽을 수 있다.
        {
            bw.write(ks, 0, ks.length()); // 문자열 ks를 0부터 ks길이만큼 저장
            bw.newLine(); // 줄 바꿈 문자를 삽입
            bw.write(es, 0, es.length());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 원하는 경로 문자 스트림
        Path fps = Paths.get("IOStreamDir/String.txt");
        try (BufferedWriter bw = Files.newBufferedWriter(fps)) // 해당경로 토대로 인코딩과 버퍼기능도 해준다
        {
            bw.write(ks, 0, ks.length());
            bw.newLine();
            bw.write(es, 0, es.length());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 인스턴스 기반의 스트림
        SBox box = new SBox("Robot"); // 인스턴스에 문자열 "Robot" 저장
        try (ObjectOutputStream oo =
                     new ObjectOutputStream( // 인스턴스를 출력하는 스트림
                             new FileOutputStream("Object.bin"))) // 출력스트림 생성
        {
            oo.writeObject(box); // 참조변수 저장, 인스턴스를 통째로 저장하는 것을 '객체 직렬화' 라고 한다.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
 --출력화면--

*/