package controller.user;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.category.Category;
import model.category.CategoryModel;
import model.user.User;
import model.user.UserModel;
import webAuctionException.WebAuctionException;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController","/LogOut","/MyDetails","/LoginBuffer"})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private UserModel model;
	
	@EJB
	private CategoryModel catModel;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getServletPath();

		HttpSession session = request.getSession(); //Creating a session
		
		if(path.equals("/LoginBuffer")){
			try {
				Category[] cat = catModel.getCategoryList();
				request.setAttribute("category", cat);
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
				
			} catch (WebAuctionException e) {
				e.printStackTrace();
			}
			
			
		} if(path.equals("/MyDetails")){
			HttpSession sessionRequest = request.getSession(false);  
			String userid = (String) sessionRequest.getAttribute("userid");
			try {
				Category[] cat = catModel.getCategoryList();
				request.setAttribute("category", cat);
				User[] user = model.getUserDetails(userid);
				request.setAttribute("user", user);
				RequestDispatcher dispatcher = request.getRequestDispatcher("myDetails.jsp");
				dispatcher.forward(request, response);
				
			} catch (WebAuctionException e) {
				e.printStackTrace();
			}
			
			
			
		} if (path.equals("/LoginController")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			System.out.println(username + " : " + password);
			try {
				User[] user = model.checkLogin(username, password);
				request.setAttribute("user", user);
				
				String userid = null;
				for(int i = 0; i < user.length; i++){
					userid = user[i].getUserid();
				}
				
				System.out.println("DDDDDDDDDDD: " + userid);
    			session.setAttribute("userid", userid);
    			RequestDispatcher dispatcher = request.getRequestDispatcher("indexItemController");
    			
    			dispatcher.forward(request, response);
			} catch (WebAuctionException ex) {
				request.setAttribute("message", ex.getMessage());
				RequestDispatcher dispatcher = request.getRequestDispatcher("LoginBuffer");
				dispatcher.forward(request, response);
			};
		}else if (path.equals("/LogOut")){
			session.invalidate();
			RequestDispatcher dispatcher = request.getRequestDispatcher("indexItemController");
			dispatcher.forward(request, response);
			
		}

	}
}