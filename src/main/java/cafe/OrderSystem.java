// 카페 주문기능을 interface로 만듬, 구현해야 할 메서드를 제공.

package cafe;

import java.util.Scanner;

public interface OrderSystem {

    void pay(Scanner scanner);

    void order(Scanner scanner);

    void cancelOrder(Scanner scanner);



}
