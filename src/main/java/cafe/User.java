// 사용자의 주문 내을 관리

package cafe;

import java.util.ArrayList;
import java.util.List;

public class User {


    // 근데 개수를 5개 제한하는거면 ArrayList말고 Vector 써도 되지 않나..
    private List<String> orders = new ArrayList<>(); // ArrayList로 저장 하는데, 변수 타입이 String.

    public void addOrder(String menu) {
        orders.add(menu);

        /* lList에다가 메뉴 이름 저장. */
    }

    public List<String> getOrders() {
        return orders;

        /*
         * 주문 리스트를 반환. getOrders를 호출하면 사용자가 주문한 리스트를 받을 수 있다. return getOrders 메서드를 호출 한
         * 곳으로 orders 라는 리스트를 받을 수 있다.
         */
    }

    public String removeOrder(int index) {
        return orders.remove(index);
        /* 특정 인덱스의 주문을 제거하고 제거된 주문 항목을 반환(By. return) */
    }

    public void clearOrders() {
        orders.clear();
        /* clear()는 ArrayList 클래스의 메서드로, 리스트에 저장된 모든 요소를 제거. */
    }
}
