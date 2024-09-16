package cafe;


import java.util.Scanner;
import java.util.Vector;

public class OrderSystemInt implements OrderSystem {

    private Vector<String> orders = new Vector<>();
    int Custom = 20000;


    @Override
    public void order() {
        Scanner sc = new Scanner(System.in);
        System.out.println("주문할 번호를 입력해 주세요: ");
        int menuNumber = sc.nextInt();

        switch (menuNumber) {
            case 1 -> addOrder("아메리카노", 3800);
            case 2 -> addOrder("에스프레소", 2400);
            case 3 -> addOrder("카페라떼", 4200);
            case 4 -> addOrder("밀크티", 5100);
            default -> System.out.println("1,2,3,4,5 만 입력 가능 합니다.");
        }
    }

        public void addOrder(String menu, int price) {

            orders.add(menu);
            System.out.println(menu + "가 성공적으로 주문 되었습니다.");



    }

    @Override
    public void pay() {


    }

    @Override
    public void cancelOrder() {

    }
}
