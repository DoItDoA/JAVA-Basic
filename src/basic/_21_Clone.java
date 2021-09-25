package basic;

class Point implements Cloneable{ // 인터페이스 Cloneable을 구현해야 메소드 clone() 실행할 수 있다.
    private int x;

    public Point(int x){
        this.x = x;
    }
    public void showPoint(){
        System.out.printf("%d",x);
        System.out.println();
    }
    @Override
    //원래는 protected public object clone()이지만 오버라이딩하면서 public으로 접근 범위를 넓혔다. 즉 오버라이딩을 하면 접근 범위를 늘릴 수 있다. 하지만 반대는 안된다
    public Object clone() throws CloneNotSupportedException{ // 이 메소드가 호출되면 이 메소드가 속한 인스턴스의 복사본이 생성된다.
        return super.clone();
    }
}

public class _21_Clone {
    public static void main(String[] args) {
        Point org = new Point(3);
        Point cpy;

        try{
            cpy = (Point)org.clone(); // org를 복사하여 cpy에 저장
            org.showPoint();
            cpy.showPoint();
        }
        catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
    }
}
