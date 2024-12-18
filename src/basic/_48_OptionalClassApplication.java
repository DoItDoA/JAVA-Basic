package basic;

import java.util.Optional;

// map 사용
class MapA {
    MapB b; // MapB를 참조시 MapB가 없거나 MapB에 대한 데이터가 없을 경우 null 될 수 있다.

    public MapA(MapB b) {
        this.b = b;
    }

    public MapB getMapA() {
        return b;
    }
}

class MapB {
    String strB; // MapB는 있지만 자료가 없을 경우 null 될 수 있다

    public MapB(String strB) {
        this.strB = strB;
    }

    public String getMapB() {
        return strB;
    }
}

// flatMap 사용
class FlatMapA {
    Optional<FlatMapB> b; //flapMap은 이렇게 변수에 Optional 처리하여 null값 판별한다.

    public FlatMapA(Optional<FlatMapB> b) {
        this.b = b;
    }

    public Optional<FlatMapB> getFlatMapA() {
        return b;
    }
}

class FlatMapB {
    Optional<String> strB; // FlatMapB 데이터도 Optional처리하여 판별

    public FlatMapB(Optional<String> strB) { // Optional<String> strB = Optional.of("flapMap")
        this.strB = strB;
    }

    public Optional<String> getFlatMapB() {
        return strB;
    }
}

public class _48_OptionalClassApplication {
    // map 관련 메소드
    public static void showMap(Optional<MapA> a) { // 맨처음은 MapA를 참조
        String str = a.map(MapA::getMapA) // MapB를 호출시 없으면 null
                .map(MapB::getMapB) // MapB데이터 호출시 없으면 null
                .orElse("nothing");

        System.out.println(str);
    }

    // flapMap 관련 메소드
    public static void showFlatMap(Optional<FlatMapA> a) {
        String str = a.flatMap(FlatMapA::getFlatMapA)
                .flatMap(FlatMapB::getFlatMapB)
                .orElse("nothing");
        // 보통 flatMap은 Optional 인스턴스(Optional.of) 생성수보다 1개 적다
        System.out.println(str);
    }

    public static void main(String[] args) {
        // map 응용
        MapB mb = new MapB("map"); // MapB에 데이터 삽입
        MapA ma = new MapA(mb); // MapA는 MapB를 인자로 받아들임
        showMap(Optional.of(ma)); // Optional<MapA> a = Optional.of("map")

        // flatMap 응용
        Optional<FlatMapB> fmb = Optional.of(new FlatMapB(Optional.of("flapMap"))); // Optional 인스턴스 생성 후, 새 인스턴스 FlatMapB에 입력인자 넣고 다시 optional 인스턴스 생성
        Optional<FlatMapA> fma = Optional.of(new FlatMapA(fmb)); // 새 인스턴스 (FlatMapA)에 Optional 값 넣고 Optional 인스턴스 생성
        showFlatMap(fma);
    }
}
/*
 --출력화면--
map
flapMap
*/