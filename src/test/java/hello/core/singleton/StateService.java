package hello.core.singleton;

public class StateService {
    private int price; // 상태 유지 필드

    public void orderStateful(String name, int price) {
        System.out.println("name = " + name + ", price = " + price);
        this.price = price;
    }

    public int orderStateless(String name, int price) {
        System.out.println("name = " + name + ", price = " + price);
        return price;
    }

    public int getPrice() {
        return price;
    }
}
