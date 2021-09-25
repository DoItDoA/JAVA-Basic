package basic;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/*
    컬렉션 프레임워크의 골격 중
    Collection<E> -> Set<E> -> HashSet<E> 저장 순서가 유지 안되고, 중복 허용X
                            -> TreeSet<E> 기본 오름차순 유지하면서, 중복 허용X
    Set은 Collection을 상속하여 Collection의 하위이다.
*/

class Human implements Comparable<Human> {
    String name;
    int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " : " + age;
    }

    @Override
    public int compareTo(Human h) {
        return h.age - this.age; // 내림차순
    }
}

class HumanComparator implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return h1.age - h2.age; // 오름차순
    }
}

public class _33_CollectionTreeSet {
    public static void main(String[] args) {
        // new HumanComparator()가 없다면 Comparable의 compareTo를 따라 내림차순이 표현되는데 있으면 Comparator의 compare를 우선순위 잡아 오름차순을 표현한다
        Set<Human> tree = new TreeSet<>(new HumanComparator());
        tree.add(new Human("YOON", 33));
        tree.add(new Human("HONG", 37));
        tree.add(new Human("SHIN", 31));

        for (Human h : tree)
            System.out.println(h);
    }
}
