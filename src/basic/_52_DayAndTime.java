package basic;

import java.awt.dnd.DragGestureEvent;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class _52_DayAndTime {
    public static long fibonacci(long n) {
        if (n == 1 || n == 2)
            return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3, 10, 40);
        Instant start = Instant.now(); // 현재 시각 정보를 담음 (스톱워치 시작)
        nums.stream()
                .map(n -> fibonacci(n))
                .forEach(r -> System.out.println(r));
        Instant end = Instant.now(); // 현재 시각 정보를 담음 (스톱워치 끝)
        System.out.println("걸린 시간 : " + Duration.between(start, end).toMillis()); // 걸린 시간 간격을 밀리초(1/1000초)로 환산. 코드작성시 작동시간 측정

        // LocalDate (날짜)
        LocalDate today = LocalDate.now(); // 현재날짜 정보 호출
        System.out.println("오늘 : " + today);

        LocalDate xmas = LocalDate.of(today.getYear(), 12, 25); // 날짜 직접입력, getYear()함수로 현재년도 호출
        System.out.println("크리스마스 : " + xmas);

        LocalDate eve = xmas.minusDays(1); // 날짜에서 1일 빼기, Days, Months, Years 등 있고 plusXXX 표현도 있다. 
        System.out.println("크리스마스 이브 : " + eve);

        Period left = Period.between(today, xmas); // 두 날짜 사이 기간 구하기. 날짜는 Period
        System.out.println("크리스마스까지 앞으로 " + left.getMonths() + "개월 " + left.getDays() + "일"); // 기간 날짜에서 년,월 호출


        // LocalTime (시간)
        LocalTime now = LocalTime.now(); // 현재시각 정보 호출
        System.out.println("지금 시각 : " + now);

        LocalTime mt = now.plusHours(2).plusMinutes(10); // 시간, 분 더하기
        System.out.println("지금 시각으로부터 2시간 10분뒤 : " + mt);

        LocalTime Tstart = LocalTime.of(14, 24, 35); // 시간 직접입력
        LocalTime Tend = LocalTime.of(17, 31, 19);

        Duration Tbetween = Duration.between(Tstart, Tend); // 시간 간격 구하기. 시간은 Duration
        System.out.println("시간 간격 : " + Tbetween);

        // LocalDateTime (날짜와 시간)
        LocalDateTime dt = LocalDateTime.now(); // 현재 날짜와 시간 정보 호출
        System.out.println("현재일과 시간 : " + dt);

        LocalDateTime dmt = dt.minusDays(1).plusHours(3).plusMinutes(35); // 일자 빼고 시간 더하기
        System.out.println("현재일로부터 1일전 3시간 35분뒤 : " + dmt);

        LocalDateTime day1 = LocalDateTime.of(2021, 1, 1, 8, 18); // 직접 날짜와 시간 입력
        LocalDateTime day2 = LocalDateTime.of(2022, 2, 4, 20, 19);

        LocalDateTime fastDay;
        if (day1.isBefore(day2)) // day1이 day2보다 빠르면 true 호출
            fastDay = day1;
        else
            fastDay = day2;

        Period dayBetween = Period.between(day1.toLocalDate(), day2.toLocalDate()); // 날짜와 시간 정보에서 날짜 기간만 호출
        System.out.println("날짜 간격 : " + dayBetween);
        System.out.println(dayBetween.getYears() + "년 " + dayBetween.getMonths() + "개월 " + dayBetween.getDays() + "일"); // 날짜 정보 포맷

        Duration timeBetween = Duration.between(day1.toLocalTime(), day2.toLocalTime()); // 날짜와 시간 정보에서 시간 기간만 호출
        System.out.println("시간 간격 : " + timeBetween);
        System.out.println(timeBetween.toHours() + "시간 " + timeBetween.toMinutesPart() + "분"); // 시간 정보 포맷
        System.out.println("총" + timeBetween.toMinutes() + "분"); // Part가 붙으면 Part부분만 계산하고 없으면 전체 시간을 계산한다.

        // format
        DateTimeFormatter fm = DateTimeFormatter.ofPattern("yy-MM-dd , HH:m:s"); // 포맷 틀 작성
        System.out.println("시간 포맷: " + day1.format(fm)); // LocalDate,LocalTime,LocalDateTime 대상으로 포맷. Duration과 Period는 안됨
    }

}
