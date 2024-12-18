package basic;

/*
    네스티드 클래스는 static 네스티트 클래스와 Non-static 네스티트 클래스로 나눠지는데
    Non-static 네스티트 클래스를 이너 클래스라고도 한다.
*/

class Outer {
    // 네스티드 클래스
    private static int num = 0; // 변수에 private이 붙어 있지만 메소드로 접근이 가능하며 static이 있어 별도의 공간에 저장 

    static class setNested { // static이 붙어 위의 변수와 같은 공간에 존재하는 클래스안의 클래스
        void add(int n) {
            num += n;
        }
    }

    static class getNested { // 마찬가지로 같은 공간을 사용하여 정보가 공유 가능하다
        int get() {
            return num;
        }
    }

    // 이너 클래스
    private int num2 = 0; // 클래스 내의 전역 변수라 서로 다른 인스턴스의 이너클래스에서도 공유가 가능하다

    class Member { // 이너 클래스 (클래스 안의 클래스)
        void add(int n) {
            num2 += n;
        }

        int get() {
            return num2;
        }
    }
}

public class _41_InnerClass {
    public static void main(String[] args) {
        // 1. 네스티드 클래스
        Outer.setNested setNest = new Outer.setNested(); // 외부 클래스안의 static 클래스 인스턴스 생성
        setNest.add(5); // 메소드 호출
        Outer.getNested getNest = new Outer.getNested();
        System.out.println(getNest.get()); // 같은 변수를 공유하여 정보호출 가능

        // 2. 이너 클래스
        Outer out = new Outer(); // 우선 외부 클래스 인스턴스 생성
        Outer.Member member1 = out.new Member(); // 외부 클래스 안의 이너 클래스의 새 인스턴스 생성
        Outer.Member member2 = out.new Member();

        member1.add(7); // 첫번째 인스턴스에서 변수값 저장
        System.out.println(member2.get()); // 두번째 인스턴스에서 변수값 호출
    }
}
/*
 --출력화면--
5
7
*/