package kr.kosa.review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class ReviewDao {
	
	
	DataSource dataSource;

	public ReviewDao() {
		try {
			Context initCtx = new InitialContext();
			dataSource = (DataSource)initCtx.lookup("java:comp/env/dbcp_myoracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	//리뷰어 번호 찾는 메서드
	public int getReviewerId(String name) {
		Connection con = null;
		int result=0;
		try {
			con = dataSource.getConnection();
			String sql = "select reviewer_id from reviews where reviewer_name='name'";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con!=null) try {con.close();} catch(Exception e) {}
		}			
		return result;
	}
	
	//reviewNumber 정하는 메서드
	public int setReviewNumber() {
		int result=0;
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql = "select count(review_Number) from reviews";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con!=null) try{con.close();} catch(Exception e) {} 
		}
		
		
		return result+1;
	}
	
	//리뷰어 이름 가져오는 메서드
	public List<String> getReviewerNames() {
		List<String> reviewerNameList = new ArrayList();
		Connection con = null;
		String result ="";
		try {
			con = dataSource.getConnection();
			String sql = "select reviewer_name from reviews";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				ReviewVo review = new ReviewVo();
				reviewerNameList.add(rs.getString("reviewer_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con!=null) try {con.close();} catch(Exception e) {}
		}
		return reviewerNameList;
	}
	
	//읽기 Read (리뷰 글 조회)
	public List<ReviewVo> getAllReviews(){
		List<ReviewVo> reviewList = new ArrayList<>(); 
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql = "select * from reviews";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				ReviewVo review = new ReviewVo();
				review.setReviewerId(rs.getInt("reviewer_id"));
				review.setReviewerName(rs.getNString("reviewer_name"));
				review.setReviewNumber(rs.getInt("review_number"));
				review.setBookType(rs.getString("book_type"));
				review.setBookTitle(rs.getString("book_title"));
				review.setAuthor(rs.getString("author"));
				review.setMemo(rs.getString("memo"));
				reviewList.add(review);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			if(con!=null) try {con.close();} catch(Exception e) {}
		}
		return reviewList;		
	}
	
	//쓰기 Create (리뷰 글 입력)
	public void insertReview(ReviewVo review) {
		Connection con = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "insert into reviews(  "
					   + "reviewer_name "
					   + "book_type, book_title, author, memo) "
					   + "values (?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, review.getReviewerName());
			stmt.setString(2, review.getBookType());
			stmt.setString(3, review.getBookTitle());
			stmt.setString(4, review.getAuthor());
			stmt.setString(5, review.getMemo());
			stmt.executeUpdate();
			} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//수정 Update (리뷰 글 수정)
	public void updateReview(ReviewVo review) {
		Connection con = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "insert into reviews(  "
					   + "reviewer_id, reviewer_name, review_number "
					   + "book_type, book_title, author, memo) "
					   + "values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, review.getReviewerId());
			stmt.setString(2, review.getReviewerName());
			stmt.setInt(3, review.getReviewNumber());
			stmt.setString(4, review.getBookType());
			stmt.setString(5, review.getBookTitle());
			stmt.setString(6, review.getAuthor());
			stmt.setString(7, review.getMemo());
			stmt.executeUpdate();
			} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//수정 Update (리뷰 글 수정)
	public void deleteReview(int reviewNumber) {
		Connection con = null;
		
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			
			String sql = "delete * from reviews where review_number=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
