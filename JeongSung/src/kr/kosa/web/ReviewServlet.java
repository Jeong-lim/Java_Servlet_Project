package kr.kosa.web;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kosa.review.ReviewDao;
import kr.kosa.review.ReviewVo;

public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReviewServlet() {
        super();
    }
    
    ReviewDao dao = new ReviewDao();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf('/'));
		request.setAttribute("reviewerNameList", dao.ReviewerSelects());
		String view = "/select.jsp";
		
		
		if("/Main.do".equalsIgnoreCase(cmd)) {
			String name = request.getParameter("name");			
			request.setAttribute("name", name);
			request.setAttribute("namelist", dao.getReviewerNames());
			view = "main.jsp";
		}else if("/ReviewList.do".equals(cmd)) {
			System.out.println("리뷰 상세조회");
			String reviewerName = request.getParameter("reviewerName");
			request.setAttribute("name", reviewerName);
			System.out.println("1");
			System.out.println(reviewerName);
			System.out.println("2");
			//String reviewNum = request.getParameter("reviewNumber");
			//int reviewNumber = Integer.parseInt(reviewNum);
			int reviewNumber = dao.getReviewNumber(reviewerName);
			System.out.println(reviewNumber);
			request.setAttribute("reviewlist", dao.getReviewName(reviewerName));			
			view = "/WEB-INF/views/review/reviewlist.jsp";
		}else if("/ReviewInsert.do".equals(cmd)) {
			System.out.println("리뷰 작성");
			request.setAttribute("reviewNumber", dao.setReviewNumber());
			request.setAttribute("namelist", dao.getReviewerNames());
			view = "/WEB-INF/views/review/reviewform.jsp";
		}else if("/ReviewDetails.do".equals(cmd)) {
			System.out.println("리뷰 상세조회");
			String reviewerName = request.getParameter("reviewerName");
			int reviewNumber = dao.getReviewNumber(reviewerName);
			System.out.println(reviewNumber);
			request.setAttribute("review", dao.getReviewDetails(reviewNumber));
			view = "/WEB-INF/views/review/reviewdetails.jsp";
		}else if("/ReviewUpdate.do".equals(cmd)) {
			System.out.println("리뷰 수정");
			request.setAttribute("reviewNumber", dao.setReviewNumber());
			request.setAttribute("namelist", dao.getReviewerNames());
			String reviewNumStr = request.getParameter("reviewNumber");
			int reviewNum = Integer.parseInt(reviewNumStr);
			request.setAttribute("review", dao.getReview(reviewNum));
			System.out.println(reviewNum);			
			
			view = "/WEB-INF/views/review/updateform.jsp";
		}else if("/ReviewDelete.do".equals(cmd)) {	
			view = "/WEB-INF/views/review/reviewdeleteform.jsp";
		}else if("/ReviewAll.do".equals(cmd)) {
			System.out.println("전체");
			request.setAttribute("allreviewlist", dao.getAllReviews());
			view = "/WEB-INF/views/review/reviewall.jsp";
		}
		
		RequestDispatcher disp = request.getRequestDispatcher(view);
		disp.forward(request, response);
		
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf('/'));
		
		if("/ReviewInsert.do".equals(cmd)) {
			String reviewerName = request.getParameter("reviewerName");
			String bookType = request.getParameter("type");
			String reviewNumber = request.getParameter("reviewNumber");
			String bookTitle = request.getParameter("bookTitle");
			String author = request.getParameter("author");
			String memo = request.getParameter("content");
			int reviewerId = dao.getReviewerId(reviewerName); 
			ReviewVo review = new ReviewVo();
			
			review.setReviewerName(reviewerName);
			review.setBookType(bookType);
			review.setBookTitle(bookTitle);
			review.setAuthor(author);
			review.setReviewerId(reviewerId);
			review.setReviewNumber(Integer.parseInt(reviewNumber));
			review.setMemo(memo);
			System.out.println(review);
			dao.insertReview(review);
			
			response.sendRedirect("ReviewAll.do");
		}else if("/ReviewUpdate.do".equals(cmd)) {

			String reviewNumber = request.getParameter("reviewNumber");
			String reviewerName = request.getParameter("reviewerName");
			int reviewerId = dao.getReviewerId(reviewerName); 
			String bookType = request.getParameter("bookType");
			String bookTitle = request.getParameter("bookTitle");
			String author = request.getParameter("author");
			String memo = request.getParameter("memo");
			ReviewVo review = new ReviewVo();
			System.out.println(bookTitle);
			review.setReviewerName(reviewerName);
			review.setBookType(bookType);
			review.setBookTitle(bookTitle);
			review.setAuthor(author);
			review.setReviewerId(reviewerId);
			review.setReviewNumber(Integer.parseInt(reviewNumber));
			review.setMemo(memo);
			System.out.println(review);
			dao.updateReview(review);
			
			response.sendRedirect("ReviewAll.do");
		}else if("/ReviewDelete.do".equals(cmd)) {
			String reviewNumber = request.getParameter("reviewNumber");
			dao.deleteReview(Integer.parseInt(reviewNumber));
			response.sendRedirect("ReviewAll.do");
		}//end if
		
	}//end doPost

}//end servlet class
