package cafe;

import java.util.Scanner;

public class OrderSystemImpl implements OrderSystem {

    // User 객체와 상호 작용. User 클래스의 객체
    private User user;

    // 사용자가 주문한 메뉴의 총 가격을 저장
    private int totalPrice = 0;

    // User 객체를 받아서 이 클래스가 User 객체와 상호작용하도록 한다. 이 부분 잘 이해 안감..
    public OrderSystemImpl(User user) {
        this.user = user;
    }

    @Override
    public void order(Scanner scanner) {
        if (user.getOrders().size() >= 5) {
            // Size는 list의 요소 개수를 반환.
            System.out.println("더 이상 주문할 수 없습니다. 최대 5개까지만 주문할 수 있습니다.");
            return;
        }

        System.out.println("주문할 메뉴 번호를 입력해 주세요: ");
        int menuNumber = scanner.nextInt();

        switch (menuNumber) {
            case 1 -> addOrder("아메리카노", 3800);
            case 2 -> addOrder("에스프레소", 2400);
            case 3 -> addOrder("카페라떼", 4200);
            case 4 -> addOrder("밀크티", 5100);
            default -> System.out.println("잘못된 메뉴 번호입니다. 1, 2, 3, 4 중에 선택해 주세요.");

        }
    }

    private void addOrder(String menu, int price) {
        user.addOrder(menu);
        totalPrice += price;
        System.out.println(menu + "가(이) 주문되었습니다. 현재 총 금액: " + totalPrice + "원");
    }

    @Override
    public void pay(Scanner scanner) {
        if (user.getOrders().isEmpty()) {
            // getOrders로 부터 주문 리스트 반환, 그리고 empty 면 주문 없다고 실행.
            System.out.println("결제할 주문이 없습니다.");
            return; // 메서드 실행 종료
        }

        System.out.println("총 결제 금액은 " + totalPrice + "원입니다.");

        System.out.print("결제할 금액을 입력해 주세요: ");
        int payment = scanner.nextInt();

        if (payment >= totalPrice) {
            int change = payment - totalPrice;
            System.out.println("결제가 완료되었습니다. 거스름돈: " + change + "원");
            user.clearOrders();
            totalPrice = 0;
        } else {
            System.out.println("결제 금액이 부족합니다. 주문을 다시 확인해 주세요.");
        }
    }

    @Override
    public void cancelOrder(Scanner scanner) {
        if (user.getOrders().isEmpty()) {
            System.out.println("취소할 주문이 없습니다.");
            return;
        }

        System.out.println("취소할 주문을 선택 해주세요: ");

        for (int i = 0; i < user.getOrders().size(); i++)
            /*
             * 루프의 시작은 0, 이 루프는 주문 목록의 크기보다 작을 때까지 반복한다. 루프가 실행될 때마다 i가 1씩 증가한다.
             */
        {
            System.out.println((i + 1) + ". " + user.getOrders().get(i));
        }

        // i는 0부터 출력이지만, +1 함으로써 1로 출력할 수 있도록..

        int orderNumber = scanner.nextInt();
        String canceledOrder = user.removeOrder(orderNumber - 1);
        int price = getPrice(canceledOrder);
        totalPrice -= price;

        System.out.println(canceledOrder + "가(이) 취소되었습니다. 현재 총 금액: " + totalPrice + "원");
    }

    private int getPrice(String menu) {
        return switch (menu) {
            case "아메리카노" -> 3800;
            case "에스프레소" -> 2400;
            case "카페라떼" -> 4200;
            case "밀크티" -> 5100;
            default -> 0;
        };
    }
}
