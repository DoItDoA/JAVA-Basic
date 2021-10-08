package basic;

import java.nio.file.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class _55_NIOStream {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\JavaStudy\\pathDemo.java"); // 절대 경로로 경로 정보 가져옴
        Path root = path.getRoot(); // 제일 처음 위치 가져옴
        Path parent = path.getParent(); // 해당 폴더 위치 가져옴
        Path fileName = path.getFileName(); // 파일명 가져옴

        System.out.println("Absolute : " + path);
        System.out.println("Root : " + root);
        System.out.println("Parent : " + parent);
        System.out.println("File : " + fileName);

        Path currentPath = Paths.get("");
        String currentDir;

        if (currentPath.isAbsolute()) // 해당경로가 절대경로인지 판단
            currentDir = currentPath.toString();
        else
            currentDir = currentPath.toAbsolutePath().toString(); // 해당 경로를 절대경로로 변환
        System.out.println("Current Directory : " + currentDir);


        // 파일, 폴더 생성
        try {
            Path dp1 = Paths.get("NIOStreamDir\\Empty"); // 폴더 생성은 경로 마지막에 폴더명 쓴다. 상대경로.
            Files.createDirectory(dp1); //해당 경로에 Empty폴더 생성. parent(NIOStreamDir)가 없거나 Empty폴더가 이미 존재하면 예외처리

            Path filePath = Paths.get("NIOStreamDir\\Empty\\empty.txt"); // 파일 생성은 경로 마지막에 파일명 쓴다.
            Files.createFile(filePath); // 해당 경로에 empty파일 생성. parent(NIOStreamDir\Empty)가 없거나 empty파일이 이미 존재하면 예외처리

            Path dp2 = Paths.get("NIOStreamDir2\\Empty"); // 폴더 생성은 경로 마지막에 폴더명 쓴다
            Files.createDirectories(dp2); // 해당 경로에 디렉토리를 전부 다 생성한다. 그래서 이미 존재해도 예외처리 안함
        } catch (IOException e) {
            e.printStackTrace();
        }


        // 파일에 입력과 출력
        try {
            Path filePath = Paths.get("NIOStreamDir\\simple.bin");
            filePath = Files.createFile(filePath); // 파일 생성, 반환값은 Path

            byte[] bufferWrite = {0x13, 0x14}; // 파일에 넣을 정보
            Files.write(filePath, bufferWrite, StandardOpenOption.APPEND); // 첫번째인자는 생성된 파일 경로, 두번째인자는 해당정보, 세번째인자는 옵션(파일에 데이터추가)
            byte[] bufferRead = Files.readAllBytes(filePath); // 파일경로로부터 데이터 읽어 배열에 저장

            for (byte b : bufferRead)
                System.out.print(b + "\t");
            System.out.println();

            // 문자 입출력
            Path fp = Paths.get("NIOStreamDir\\simple.txt");
            String st1 = "One";
            String st2 = "Two";
            List<String> listWrite = Arrays.asList(st1, st2); // 문자열은 컬렉션 이용한다

            Files.write(fp, listWrite); // 옵션이 없으면 StandardOpenOption.CREATE가 적용. CREATE는 파일이 존재하지 않으면 생성하거나 덮어씌움
            // 다른 옵션 -> CREATE_NEW : 파일 생성하고 이미 존재하면 예외처리,  TRUNCATE_EXISTING : 파일의 내용을 덮어씌움, 해당파일이 없으면 예외처리
            List<String> listRead = Files.readAllLines(fp); // 위에는 Bytes 쓰고 여기는 Lines 쓴다
            System.out.println(listRead);
        } catch (IOException e) {
            e.printStackTrace();
        }


        // 파일 복사와 이동
        try {
            Path src = Paths.get("NIOStreamDir\\Empty\\empty.txt"); // 원본
            Path dst = Paths.get("NIOStreamDir\\Empty\\empty2.txt"); // 복사본

            Files.copy(src, dst, StandardCopyOption.REPLACE_EXISTING); // 옵션이 해당파일을 복사하고 존재하면 덮어씌움. COPY_ATTRIBUTES : 복사하고 존재하면 예외처리

            Path src1 = Paths.get("NIOStreamDir\\Empty"); // 파일말고 폴더 통째로 이동 복사 가능하다
            Path dst1 = Paths.get("NIOStreamDir2\\Empty");

            Files.move(src1, dst1, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
