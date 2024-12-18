package basic;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;
import java.util.StringTokenizer;

public class _23_MathClass {
    public static void main(String[] args) {
        // BigInteger
        BigInteger big1 = new BigInteger("1000000000000000000"); // long형보다 큰 데이터를 다룰때 사용.반드시 문자열로 입력
        BigInteger big2 = new BigInteger("-999999999999999999");

        BigInteger r = big1.multiply(big2); // *가 아닌 관련 함수를 써야한다
        System.out.println(r);

        // BigDecimal
        BigDecimal d1 = new BigDecimal("1.6"); // 일반 실수형은 연산시 결과에 오차가 조금은 있다. BigDecimal은 정확한 연산을 하게 한다
        BigDecimal d2 = new BigDecimal("0.1");
        System.out.println(d1.add(d2));

        // Random
        Random rand = new Random(); // 랜덤 클래스 생성
        for (int i = 0; i < 7; i++) {
            System.out.print(rand.nextInt(1000) + " "); // nextInt는 0에서 1미만 사이의 난수 생성지만 1000을 넣으면 *1000이어서 1에서 1000미만 난수
        }
        System.out.println();

        // TokenizeString
        StringTokenizer st = new StringTokenizer("12 + 36 - 8 / 2 = 44", "+-/= "); // StringTokenizer는 두번째 인자에 +,-,/,=,공백을 첫번째 인자에서 제거하여 저장
        while (st.hasMoreTokens()) { // 해당 자료가 있으면 true 반환
            System.out.print(st.nextToken() + " "); // 0번째(아무것도 지정 안됨)에서 다음 선택하여 있으면 출력
        }
    }
}
/*
 --출력화면--
-999999999999999999000000000000000000
1.7
705 467 881 350 505 243 761
12 36 8 2 44
*/