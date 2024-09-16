package cafe;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<String> orders = new ArrayList<>();  // 주문 목록

    // 주문 추가 메서드
    public void addOrder(String order) {
        orders.add(order);
    }

    // 주문 삭제 메서드 (취소 시 사용)
    public String removeOrder(int index) {
        return orders.remove(index);
    }

    // 주문 목록 반환 메서드
    public List<String> getOrders() {
        return orders;
    }

    // 주문 목록 초기화 메서드
    public void clearOrders() {
        orders.clear();
    }
}
