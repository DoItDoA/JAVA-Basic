package basic;

class Bank {
    int balance = 0;

    public int deposit(int amount) {
        balance += amount;
        return balance;
    }

    public int checkMyBalance() {
        System.out.println("잔액 " + balance);
        return balance;
    }
}

public class _02_ClassPresent {
    public static void main(String[] args) {
        Bank ref = new Bank();
        ref.deposit(1000);
        check(ref); // 함수호출시 참조변수를 넣기
    }

    public static void check(Bank acc) { // 참조변수가 입력인자이기 때문에 입력형도 클래스인 Bank사용
        acc.checkMyBalance();
    }
}
