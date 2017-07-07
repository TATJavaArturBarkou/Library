package by.epam.barkou.bean;

public class Order {
	String userId;
	String bookId;
	String onHands;

	public Order(String userId, String bookId) {
		this.userId = userId;
		this.bookId = bookId;
	
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getOnHands() {
		return onHands;
	}

	public void setOnHands(String onHands) {
		this.onHands = onHands;
	}

}
