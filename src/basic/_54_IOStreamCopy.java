package basic;

import java.io.*;
import java.util.Scanner;

public class _54_IOStreamCopy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("대상 파일 : ");
        String src = sc.nextLine(); // 출력 스트림에 생선된 파일 입력 xxx.dat, xxx.txt... 입력

        System.out.println("사본 이름 : ");
        String dst = sc.nextLine(); // 복사될 파일 이름 지점 xxx.dat, xxx.txt... 입력
        
        // ;으로 구분하여 입력과 출력 스트림 생성
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(src));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dst))) {
            int data;

            while (true) {
                data = in.read(); // 원본으로부터 문자를 하나씩 읽는다
                if (data == -1) // 하나씩 반환하다가 반환할 문자가 없으면 -1 반환
                    break;
                out.write(data); // 복사본에 문자를 하나씩 쓴다
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
