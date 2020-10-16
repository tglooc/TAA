package sample.simple.extObj;

public class Account {

	private int amount;
	private final String userId;

	public Account(int amount, String userId) {
		this.amount = amount;
		this.userId = userId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void updateAmount(Operation op, int sum) {
		switch (op) {
		case addtion:
			amount += sum;
			break;
		case substraction:
			amount -= sum;
			break;

		default:
			break;
		}
	}

	public String getUserId() {
		return userId;
	}

	@Override
	public String toString() {
		return "Account [amount=" + amount + ", userId=" + userId + "]";
	}

}
