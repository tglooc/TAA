package sample.simple.extObj;

public class Article {

	private int id;
	private String name;
	private float price;
	private int qty;

	public Article(int id, String name, float price, int qty) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.qty = qty;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public void updateQty(Operation op, int sum) {
		switch (op) {
		case addtion:
			qty += sum;
			break;
		case substraction:
			qty -= sum;
			break;

		default:
			break;
		}
	}

	@Override
	public String toString() {
		return "Article n°" + id + " : " + name + " (" + price + ")";
	}

}
