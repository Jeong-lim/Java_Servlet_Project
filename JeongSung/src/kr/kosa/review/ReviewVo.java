package kr.kosa.review;

public class ReviewVo {
	
	private int reviewerId;
	private String reviewerName;
	private int reviewNumber;
	private String bookType;
	private String bookTitle;
	private String author;
	private String memo;
	
	
	public ReviewVo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getReviewerId() {
		return reviewerId;
	}


	public void setReviewerId(int reviewerId) {
		this.reviewerId = reviewerId;
	}


	public String getReviewerName() {
		return reviewerName;
	}


	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}


	public int getReviewNumber() {
		return reviewNumber;
	}


	public void setReviewNumber(int reviewNumber) {
		this.reviewNumber = reviewNumber;
	}


	public String getBookType() {
		return bookType;
	}


	public void setBookType(String bookType) {
		this.bookType = bookType;
	}


	public String getBookTitle() {
		return bookTitle;
	}


	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getMemo() {
		return memo;
	}


	public void setMemo(String memo) {
		this.memo = memo;
	}


	@Override
	public String toString() {
		return "ReviewVo [reviewerId=" + reviewerId + ", reviewerName=" + reviewerName + ", reviewNumber="
				+ reviewNumber + ", bookType=" + bookType + ", bookTitle=" + bookTitle + ", author=" + author
				+ ", memo=" + memo + "]";
	}

	
	
	
	
}
