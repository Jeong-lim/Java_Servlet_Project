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
		String view = "/select.jsp";	// 초기화면

		
		if("/Main.do".equalsIgnoreCase(cmd)) {		//name 선택하면 main 페이지로 이동
			String name = request.getParameter("name");			
			request.setAttribute("name", name);
			request.setAttribute("namelist", dao.getReviewerNames());
			view = "main.jsp";
		}else if("/ReviewInsert.do".equals(cmd)) {		//Create
			System.out.println("리뷰 작성");
			request.setAttribute("reviewNumber", dao.setReviewNumber());
			request.setAttribute("namelist", dao.getReviewerNames());
			view = "/WEB-INF/views/review/reviewform.jsp";
		}else if("/ReviewDetails.do".equals(cmd)) {		//상세보기
			System.out.println("리뷰 상세조회");
			String reviewerName = request.getParameter("reviewerName");
			request.setAttribute("name", reviewerName);
			request.setAttribute("namelist", dao.getReviewerNames());
			request.setAttribute("reviewlist", dao.getReviewDetails(reviewerName));			
			view = "/WEB-INF/views/review/reviewlist.jsp";
		}else if("/ReviewUpdate.do".equals(cmd)) {		//Update
			System.out.println("리뷰 수정");			
			int reviewNum = Integer.parseInt(request.getParameter("reviewNumber"));
			System.out.println(reviewNum+"진짜리뷰넘버");
			request.setAttribute("reviewNumber", reviewNum);
			request.setAttribute("namelist", dao.getReviewerNames());			
			request.setAttribute("review", dao.getReview(reviewNum));			
			view = "/WEB-INF/views/review/reviewupdateform.jsp";
		}else if("/ReviewDelete.do".equals(cmd)) {		//Delete
			view = "/WEB-INF/views/review/reviewdeleteform.jsp";
		}else if("/ReviewAll.do".equals(cmd)) {			//Read
			System.out.println("전체");
			request.setAttribute("namelist", dao.getReviewerNames());	
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
		
		//Insertform 양식으로 revuewVo 파라미터 받아서 다른 컨트롤러로 redirect
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
			
		//Updateform 양식으로 revuewVo 파라미터 받아서 다른 컨트롤러로 redirect
		}else if("/ReviewUpdate.do".equals(cmd)) {

			String reviewNumber = request.getParameter("reviewNumber");
			String reviewerName = request.getParameter("reviewerName");
			int reviewerId = dao.getReviewerId(reviewerName); 
			String bookType = request.getParameter("type");
			String bookTitle = request.getParameter("bookTitle");
			String author = request.getParameter("author");
			String memo = request.getParameter("content");
			ReviewVo review = new ReviewVo();
			review.setReviewerId(reviewerId);
			review.setReviewerName(reviewerName);
			review.setReviewNumber(Integer.parseInt(reviewNumber));
			review.setBookType(bookType);
			review.setBookTitle(bookTitle);
			review.setAuthor(author);
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
