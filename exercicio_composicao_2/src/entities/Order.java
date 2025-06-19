package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	private LocalDateTime moment;
	private OrderStatus status;
	private Client client;

	List<OrderItem> orderItem = new ArrayList<>();

	public Order() {
	}

	public Order(LocalDateTime moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getItems() {
		return orderItem;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void addItem(OrderItem item) {
		orderItem.add(item);
	}

	public void removeItem(OrderItem item) {
		orderItem.remove(item);
	}

	public Double total() {
		Double sum = 0.0;
		for (OrderItem items : orderItem) {
			sum += items.subTotal();
		}
		return sum;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(fmt1.format(moment) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client.getName() + " (" + fmt.format(client.getBirthDate()) + ") - " + client.getEmail() + "\n");
		sb.append("Order items:\n");
		for (OrderItem p : orderItem) {
			sb.append(p.getProduct().getName() + ", Quantity: " + p.getQuantity() + ", Subtotal: $"
					+ String.format("%.2f", p.getPrice()));
			sb.append("\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
}
