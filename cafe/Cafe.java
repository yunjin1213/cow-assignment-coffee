package cafe;

public class Cafe {

    public static void main(String[] args) {
        CafeManager cafeManager = new CafeManager();
        cafeManager.startTalking();

        while (cafeManager.isTalking()) {
            cafeManager.introduceFunction();
            int talkNumber = cafeManager.askNumber();

            switch (talkNumber) {
                case 1 -> {
                    cafeManager.introduceMenu();
                    int selectMenuNumber = cafeManager.askNumber();
                    // TODO: OrderSystem 주문 구현 로직 호출
                }
                case 2 -> {

                    // TODO: OrderSystem 주문 취소 구현 로직 호출
                }
                case 3 -> {
                    // TODO: OrderSystem 결제 구현 로직 호출
                }
                case 4 -> {
                    cafeManager.finishTalking();
                }
                default -> {
                    cafeManager.faultValue();
                }
            }
        }
    }
}
