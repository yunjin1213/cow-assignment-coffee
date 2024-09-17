package cafe;

import java.util.Scanner;

public class CafeManager {

	private boolean talking = true;
	private Scanner sc = new Scanner(System.in);

	public void startTalking() {
		System.out.println("카페에 오신 것을 환영합니다!");
		System.out.println("무엇을 도와드릴까요?");
	}

	public boolean isTalking() {
		return talking;
	}

	public void finishTalking() {
		talking = false;
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

	public int askNumber() {
		System.out.print("번호를 선택해 주세요: ");
		return sc.nextInt();
	}

	public void faultValue() {
		System.out.println("잘못된 값을 입력하셨습니다.");
	}
}
