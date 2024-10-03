package cafe;

import java.util.Scanner;

public class Cafe {

    public static void main(String[] args) {

        CafeManager cafeManager = new CafeManager();
        User user = new User();
        Scanner scanner = new Scanner(System.in);

		/* OrderSystemImpl 객체 생성 하면서 OrderSystem 인터페이스를 받으면서,
		user객체가 주문을 관리할 수 있도록. */
        OrderSystem orderSystem = new OrderSystemImpl(user);

        cafeManager.startTalking();

        while (cafeManager.isTalking()) {
            // isTalking 메서드는 talking 변수의 값을 반환.

            cafeManager.introduceFunction();
            int talkNumber = cafeManager.askNumber(scanner);

            switch (talkNumber) {
                case 1 -> {
                    cafeManager.introduceMenu();
                    orderSystem.order(scanner);
                }
                case 2 -> orderSystem.cancelOrder(scanner);
                case 3 -> orderSystem.pay(scanner);
                case 4 -> cafeManager.finishTalking(scanner);
                default -> cafeManager.faultValue(scanner);

            }
        }
    }
}
