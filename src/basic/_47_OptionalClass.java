package basic;


import java.util.Optional;
import java.util.OptionalInt;

public class _47_OptionalClass {
    public static void main(String[] args) {
        // 1. Optional클래스의 인스턴스 생성과 null 판단 및 값 호출
        Optional<String> os1 = Optional.of("of"); // Optional의 인스턴스 생성1, of는 null 허용안함, null 입력시 예외처리
        Optional<String> os2 = Optional.ofNullable("ofNullable"); // Optional의 인스턴스 생성2, ofNullable은 null 허용함

        if (os1.isPresent()) // 해당 Optional클래스에 값이 존재하는지 판단. 값이 존재하면 true, null이면 false
            System.out.println(os1.get()); // 해당 Optional클래스로부터 값 추출

        if (os2.isPresent())
            System.out.println(os2.get());

        os1.ifPresent(System.out::println); // ifPresent로 좀 더 간편하게 호출. 값이 있으면 해당값 출력, 없으면 null처리

        // 2. Optional 클래스의 map 메소드
        Optional<String> useMap = Optional.of("map");
        Optional<String> mapOs = useMap.map(s -> s.toString()); // map은 해당 값을 람다식으로 변형하여 Optional<T>로 반환한다
        System.out.println(mapOs.get()); // 변형된 값 추출
        
        // 3. Optional 클래스의 flatMap 메소드
        // flatMap도 반환형은 Optional<T>이고 단순히 식만 볼때는 Map낫다. flatMap 응용은 다음 설명 참조
        Optional<String> useFlatMap = Optional.of("flatMap");
        Optional<String> flatMapOs = useFlatMap.flatMap(s -> Optional.of(s.toString())); // flatMap은 map과 달리 Optional.of 인스턴스생성에 영향받지않아 한번 더 람다식으로 해야한다
        System.out.println(flatMapOs.get());
        
        // 4. null값 대체 메소드 orElse
        Optional<String> EmptyOs = Optional.empty(); // empty()는 null값을 생성, 'ofNullable(null)'과 같다
        String str = EmptyOs.map(s -> s.toString()).orElse("Empty"); // 값이 존재하면 map이 출력되고 없으면 orElse로 출력된다. orElse 반환형은 String
        System.out.println(str);
        
        /* 5.
        OptionalInt
        OptionalLong
        OptionalDouble
        */
        OptionalInt oi = OptionalInt.of(3); // 제네릭의 <Integer>,<Long>,<Double>의 오토언박싱을 미리 설정
    }
}
