package basic;

public class _09_StringRef {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = new String("ABC"); // String도 클래스라 원래는 이렇게 표현

        if (str1.equals(str2)) { // String 비교문은 주로 eqauls를 쓴다
            System.out.println("같다");
        } else {
            System.out.println("다르다");
        }

        String str3 = str1.concat(str2); // concat은 서로 붙여주는 역할, 'str1 + str2'처럼 + 사용하여 붙이기 가능
        System.out.println(str3);

        String str4 = str3.substring(0, 3); // 0번째부터 3번째이전까지 (0~2번째) 출력. 인자가 1개면 n번째부터 끝까지
        System.out.println(str4);

        int cmp = str1.compareTo(str2);
        System.out.println(cmp); // 대소문자 구별하여 일치하면 0반환, str1이 str2보다 아스키번호가 작으면 0보다 작은값 반환, 크면 0보다 큰값 반환

        int cmp2 = str1.compareToIgnoreCase(str2); // 대소문자 구분하지 않으며, 나머지는 compareTo와 같다
        System.out.println(cmp2);

        String str = String.valueOf(100); // String.valueOf는 다른 자료형을 전부다 문자열로 바꿈
        System.out.println(str);

        StringBuilder strBuild = new StringBuilder("123"); // StringBuilder는 내부적으로 문자열을 저장하기위한 공간을 가진다. 그 공간에서 추가,제거등 가능한데 여기서하는 것이 효율적이다
        strBuild.append(456789); // 문자열추가. 결과 - 123456789
        strBuild.delete(0,2); // 0에서 2이전까지 제거. 결과 - 3456789
        strBuild.replace(0,3,"AB"); // 0에서 3이전까지 문자열 교체. 결과 - AB6789
        strBuild.reverse(); // 문자열 뒤집기. 결과 - 9876BA
        System.out.println(strBuild.toString()); //toString()이 문자열 반환이어 원칙적으로 사용해야하지만 없어도 출력이 된다

    }
}
