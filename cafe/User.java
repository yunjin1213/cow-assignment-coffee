package cafe;

import java.util.ArrayList;
import java.util.List;

public class User {

	private List<String> orders = new ArrayList<>();

	public void addOrder(String menu) {
		orders.add(menu);
	}

	public List<String> getOrders() {
		return orders;
	}

	public String removeOrder(int index) {
		return orders.remove(index);
	}

	public void clearOrders() {
		orders.clear();
	}
}
