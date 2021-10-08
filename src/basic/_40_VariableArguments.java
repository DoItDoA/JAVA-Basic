package basic;

public class _40_VariableArguments {
    public static void showAll(String... stuff) { // 가변인자는 인자의 수에 제한이 없다. 자료형... 사용
        for (String s : stuff)
            System.out.print(s + '\t');
        System.out.println();
    }

    public static void main(String[] args) {
        showAll("Box");
        showAll("Box", "Toy");
        showAll("Box", "Toy", "Apple");
    }
}
