package basic;

/*
   Input은 파일에서 Java Program로 이동하여 읽기
*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class _53_IOStreamInput {
    public static void main(String[] args) {
        // 바이트 스트림
        // I/O Stream은 스트림 생성 후 finally에서 close() 사용하여 매번 닫아줘야하는데, try-with-resources문은 try() 괄호 안에 스트림 생성코드 쓰면 close도 자동으로 해준다
        try (DataInputStream in =
                     new DataInputStream( // 파일로부터 데이터 전송시 자료형(int 등)을 구성하게 하는 필터스트림
                             new BufferedInputStream( // 파일 전송시 1Byte씩 읽지만 버퍼 필터스트림 생성하여 데이터를 모아서 한번에 전송시킨다.
                                     new FileInputStream("data.dat")))) // 입력스트림 생성. data.dat 파일과 연결
        {
            int num1 = in.readInt(); // int형 데이터 꺼냄
            double num2 = in.readDouble(); // double형 데이터 꺼냄
            // 데이터 읽을 때 출력스트림의 순서에 맞춰서 데이터를 읽어야한다. 출력이 int->double 이면 입력도 똑같이

            System.out.println(num1);
            System.out.println(num2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 원하는 경로 바이트 스트림
        Path fp = Paths.get("C:\\Users\\USER\\Desktop\\프로그래밍\\JAVA\\JAVA\\IOStreamDir\\data.dat"); // 경로 가져오기, 절대경로, NIOStream 참조
        try (DataInputStream in =
                     new DataInputStream(
                             new BufferedInputStream(
                                     Files.newInputStream(fp))))  // 해당 경로로 입력 스트림 생성
        {
            int num1 = in.readInt();
            double num2 = in.readDouble();
            System.out.println(num1);
            System.out.println(num2);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 문자열 스트림
        try (BufferedReader br =
                     new BufferedReader( // 문자열을 한번에 보냄
                             new FileReader("String.txt"))) //  바이트 스트림과 같이 1Byte 보내지만 OS에 맞춰진 인코딩형식을 자바에 맞춰 인코딩함. 
        {
            String str;
            while (true) {
                str = br.readLine(); // 한 문장 읽어 들이기
                if (str == null) // 더 이상 읽을 문자가 없으면 멈춤
                    break;
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 원하는 경로 문자 스트림
        Path fps = Paths.get("C:\\Users\\USER\\Desktop\\프로그래밍\\JAVA\\JAVA\\IOStreamDir\\String.txt"); // 경로 가져오기, 절대경로, NIOStream 참조
        try (BufferedReader br = Files.newBufferedReader(fps)) // 해당경로 토대로 인코딩과 버퍼기능도 해준다
        {
            String str;
            while (true) {
                str = br.readLine();
                if (str == null)
                    break;
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 인스턴스 기반의 스트림
        try (ObjectInputStream oi =
                     new ObjectInputStream( // 인스턴스를 입력하는 스트림
                             new FileInputStream("Object.bin"))) // 입력 스트림 생성
        {
            SBox box = (SBox) oi.readObject(); // 인스턴스 복원, 저장된 인스턴스를 꺼내는 것을 '객체 역 직렬화' 라고 한다
            System.out.println(box.get());
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}
