package cafe;

import java.util.Scanner;

public class CafeManager {

	private boolean talking = true; // true면 대화 중.


	public void startTalking() {
		System.out.println("카페에 오신 것을 환영합니다!");
	}

	public boolean isTalking() {
		return talking;

		// 이 메서드는 talking 변수의 값을 반환. while 루프에서 이 메서드가 사용되며, true일 때만 루프가 계속 진행됩니다.
	}

	public void finishTalking(Scanner scanner) {
		System.out.println("프로그램을 종료 합니다.");
		talking = false;
		// taling 변수를 false로 선언.
		System.exit(0);
	}

	public void introduceFunction() {
		System.out.println("원하시는 기능을 선택해주세요:");
		System.out.println("1. 주문하기");
		System.out.println("2. 주문 취소하기");
		System.out.println("3. 결제하기");
		System.out.println("4. 종료하기");
	}

	public void introduceMenu() {
		System.out.println("1. 아메리카노 - 3800원");
		System.out.println("2. 에스프레소 - 2400원");
		System.out.println("3. 카페라떼 - 4200원");
		System.out.println("4. 밀크티 - 5100원");
	}

	public int askNumber(Scanner scanner) {
		System.out.print("번호를 선택해 주세요: ");
		return scanner.nextInt();
	}

	public void faultValue(Scanner scanner) {
		System.out.println("잘못된 값을 입력하셨습니다.");
	}
}
