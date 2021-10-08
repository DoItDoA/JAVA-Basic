package basic;

@FunctionalInterface // 인터페이스에는 추상메소드(print)가 하나만 존재한다는 표시
interface LamInterface {
    void print(String s); // 매개변수가 하나

    default int add(int a, int b) {
        return a + b;
    } // default는 써도 그만 안써도 그만이라서 람다인터페이스에는 들어가도 문제없다.

    static int sub(int a, int b) {
        return a - b;
    } // static은 별도의 공간이기 때문에 람다인터페이스에는 들어가도 문제없다.
}

interface Calculate<T> { // 제네릭 기반의 함수형 인터페이스(람다 인터페이스)
    T cal(T a, T b);
}

public class _43_Lambda {
    public static void showLambda(LamInterface l, String s) { // 첫번째 인자는 람다식의 입력값
        l.print(s);
    }

    public static void main(String[] args) {
        // 1. 익명함수
        LamInterface anonymousPrn = new LamInterface() {
            @Override
            public void print(String s) {
                System.out.println(s);
            }
        }; // 익명함수에서 new LamInterface()가 필요없어 제거하고 public void print(String s) 또한 인터페이스에 있어 제거 가능하다
        anonymousPrn.print("Anonymous");

        // 2. 람다식
        // 람다식은 인터페이스에 '추상함수가 1개만 있을 경우'에만 사용 가능하다.
        // 람다식의 표현은 s(명칭 아무거나) 입력 전달값을 넣고 -> 이후로 내가 원하는 함수를 넣는다.
        // 입력전달값은 한개이면 괄호 생각가능하고 2개부터 괄호입력 입력전달값이 없으면 ()만 입력. 내가 원하는 함수도 1개면 생략가능 2개부터 중괄호를 넣는다
        LamInterface LambdaPrn = s -> System.out.println(s);
        LambdaPrn.print("Lambda");

        // 3. 람다식의 인자 전달
        showLambda((s) -> System.out.println(s), "Lambda");

        // 4. 제네릭 기반의 람다식
        Calculate<Integer> c = (a, b) -> {
            return a + b; // 중괄호 안에 리턴이 하나뿐이면 중괄호와 리턴을 생략하고 작성이 가능하다
        };
        System.out.println(c.cal(4, 3));
    }
}