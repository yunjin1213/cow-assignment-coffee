package cafe;

import java.util.Scanner;

public class OrderSystemImpl implements OrderSystem {

    private User user;  // User 객체를 사용하여 주문을 관리
    private int totalPrice = 0;  // 총 주문 금액

    public OrderSystemImpl(User user) {
        this.user = user;
    }

    @Override
    public void order() {
        Scanner sc = new Scanner(System.in);
        System.out.println("주문할 메뉴 번호를 입력해 주세요: ");
        int menuNumber = sc.nextInt();

        switch (menuNumber) {
            case 1 -> addOrder("아메리카노", 3800);
            case 2 -> addOrder("에스프레소", 2400);
            case 3 -> addOrder("카페라떼", 4200);
            case 4 -> addOrder("밀크티", 5100);
            default -> System.out.println("잘못된 메뉴 번호입니다. 1, 2, 3, 4 중에 선택해 주세요.");
        }
    }

    // 주문 추가
    private void addOrder(String menu, int price) {
        user.addOrder(menu);  // 주문 추가
        totalPrice += price;  // 총 주문 금액에 추가
        System.out.println(menu + "가(이) 주문되었습니다. 현재 총 금액: " + totalPrice + "원");
    }

    @Override
    public void pay() {
        if (user.getOrders().isEmpty()) {
            System.out.println("결제할 주문이 없습니다.");
            return;
        }

        System.out.println("총 결제 금액은 " + totalPrice + "원입니다.");
        Scanner sc = new Scanner(System.in);
        System.out.print("결제할 금액을 입력해 주세요: ");
        int payment = sc.nextInt();

        if (payment >= totalPrice) {
            int change = payment - totalPrice;
            System.out.println("결제가 완료되었습니다. 거스름돈: " + change + "원");
            user.clearOrders();  // 주문 목록 초기화
            totalPrice = 0;  // 총 금액 초기화
        } else {
            System.out.println("결제 금액이 부족합니다. 주문을 다시 확인해 주세요.");
        }
    }

    @Override
    public void cancelOrder() {
        if (user.getOrders().isEmpty()) {
            System.out.println("취소할 주문이 없습니다.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("취소할 주문을 선택 해주세요: ");

        // 현재 주문 목록 출력
        for (int i = 0; i < user.getOrders().size(); i++) {
            System.out.println((i + 1) + ". " + user.getOrders().get(i));
        }

        int orderNumber = sc.nextInt();

        // 유효한 주문 번호 확인 후 취소
        if (orderNumber > 0 && orderNumber <= user.getOrders().size()) {
            String canceledOrder = user.removeOrder(orderNumber - 1);
            System.out.println(canceledOrder + "가(이) 취소되었습니다.");
        } else {
            System.out.println("잘못된 주문 번호입니다.");
        }
    }
}
