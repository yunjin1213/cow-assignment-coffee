package cafe;

public class Cafe {

	public static void main(String[] args) {

		CafeManager cafeManager = new CafeManager();
		User user = new User();
		OrderSystem orderSystem = new OrderSystemImpl(user);

		cafeManager.startTalking();

		while (cafeManager.isTalking()) {
			cafeManager.introduceFunction();
			int talkNumber = cafeManager.askNumber();

			switch (talkNumber) {
			case 1 -> {
				cafeManager.introduceMenu();
				orderSystem.order();
			}
			case 2 -> orderSystem.cancelOrder();
			case 3 -> orderSystem.pay();
			case 4 -> {
				cafeManager.finishTalking();
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}

			default -> {
				cafeManager.faultValue();
				System.out.println("잘못된 입력입니다. 1, 2, 3, 4 중 선택하여 주세요.");
			}
			}
		}
	}
}
