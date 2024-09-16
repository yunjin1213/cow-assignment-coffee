package cafe;

public class Cafe {

    public static void main(String[] args) {
        CafeManager cafeManager = new CafeManager();
        User user = new User(); // User 객체 생성
        OrderSystem orderSystem = new OrderSystemImpl(user); // OrderSystemImpl 인스턴스 생성

        cafeManager.startTalking();

        while (cafeManager.isTalking()) {
            cafeManager.introduceFunction();
            int talkNumber = cafeManager.askNumber();

            switch (talkNumber) {
                case 1 -> {
                    cafeManager.introduceMenu();
                    orderSystem.order(); // 주문 처리
                }
                case 2 -> {
                    orderSystem.cancelOrder(); // 주문 취소 처리
                }
                case 3 -> {
                    orderSystem.pay(); // 결제 처리
                }
                case 4 -> {
                    cafeManager.finishTalking(); // 대화 종료
                }
                default -> {
                    cafeManager.faultValue(); // 잘못된 입력 처리
                }
            }
        }
    }
}
