package basic;

class Who {
    String name;
    int age;

    // 생성자 생성(클래명과 같게 한다)
    public Who(String name, int age) {
        this.name = name; // this는 클래스 Who를 가리키고 보통 입력인자와 클래스 변수가 같을 시 사용
        this.age = age;
    }

    public void present() {
        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age);
    }
}

public class _03_Constructor {
    public static void main(String[] args) {
        Who man = new Who("정호",19);
        Who woman = new Who("유미",20);

        man.present();
        woman.present();
    }
}
/*
 --출력화면--
 출력
*/