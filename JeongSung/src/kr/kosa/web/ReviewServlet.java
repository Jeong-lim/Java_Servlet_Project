package kr.kosa.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf('/'));
		
		request.setAttribute("reviewerNameList", dao.getReviewerNames());
		String view = "/select.jsp";
		if("/Main.do".equalsIgnoreCase(cmd)) {
			
			view = "main.jsp";
		}else if("/ReviewList.do".equals(cmd)) {
			System.out.println("모든 회원 정보 출력");
			request.setAttribute("reviewlist", dao.getAllReviews());
			System.out.println(dao.getAllReviews().size());
			// 뷰로 포워드(뷰 경로를 지정)
			view = "/WEB-INF/views/review/reviewlist.jsp";
		}else if("/ReviewInsert.do".equals(cmd)) {
			System.out.println("리뷰 작성");
			request.setAttribute("reviewNumber", dao.setReviewNumber());
			request.setAttribute("namelist", dao.getReviewerNames());
			view = "/WEB-INF/views/review/reviewform.jsp";
		}else if("/ReviewDetail.do".equals(cmd)) {
			System.out.println("리뷰 상세조회");
			String reviewNum = request.getParameter("reviewNumber");
			int reviewNumber = Integer.parseInt(reviewNum);
		}else if("/ReviewUpdate.do".equals(cmd)) {
			System.out.println("리뷰 수정");
		}else if("/ReviewDelete.do".equals(cmd)) {	
			
		}
		
		RequestDispatcher disp = request.getRequestDispatcher(view);
		disp.forward(request, response);
		
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf('/'));
		
		if("/ReviewInsert.do".equals(cmd)) {
			String reviewerName = request.getParameter("firstName");
			String bookType = request.getParameter("bookType");
			String bookTitle = request.getParameter("bookTitle");
			String author = request.getParameter("author");
			String memo = request.getParameter("memo");
			int reviewerId = dao.getReviewerId(reviewerName);
			int reviewNumber = dao.setReviewNumber();
			ReviewVo review = new ReviewVo();
			review.setReviewerName(reviewerName);
			review.setBookType(bookType);
			review.setBookTitle(bookTitle);
			review.setAuthor(author);
			review.setReviewerId(reviewerId);
			review.setReviewNumber(reviewNumber);
			System.out.println(review);
			dao.insertReview(review);
			
			response.sendRedirect("ReviewList.do");
		}else if("/EmpUpdate.do".equals(cmd)) {
			
		}else if("/EmpDelete.do".equals(cmd)) {
			
		}//end if
		
	}//end doPost

}//end servlet class
