package cafe;

import java.util.Scanner;

public class OrderSystemImpl implements OrderSystem {

	private User user;
	private int totalPrice = 0;

	public OrderSystemImpl(User user) {
		this.user = user;
	}

	@Override
	public void order() {
		if (user.getOrders().size() >= 5) {
			System.out.println("더 이상 주문할 수 없습니다. 최대 5개까지만 주문할 수 있습니다.");
			return;
		}

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

	private void addOrder(String menu, int price) {
		user.addOrder(menu);
		totalPrice += price;
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
			user.clearOrders();
			totalPrice = 0;
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

		for (int i = 0; i < user.getOrders().size(); i++) {
			System.out.println((i + 1) + ". " + user.getOrders().get(i));
		}

		int orderNumber = sc.nextInt();
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
