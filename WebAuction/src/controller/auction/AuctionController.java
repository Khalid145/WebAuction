package controller.auction;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.auction.Auction;
import model.auction.AuctionItem;
import model.auction.AuctionModel;
import model.bid.BidHistory;
import model.bid.BidModel;
import model.category.Category;
import model.category.CategoryModel;
import model.user.User;
import webAuctionException.WebAuctionException;

/**
 * Servlet implementation class AuctionController
 */
@WebServlet(name = "AuctionController", urlPatterns = {"/AuctionController","/MyAuction","/RemoveAuction","/SearchAuction","/AuctionOverview","/CreateAuction"})
public class AuctionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private AuctionModel model;
	
	@EJB
	private BidModel bidModel;
	
	@EJB
	private CategoryModel catModel;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuctionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
		
		if (path.equals("/MyAuction")) {
		
			HttpSession session = request.getSession(false);  
			String userid = (String) session.getAttribute("userid");
			
			try {
				Category[] cat = catModel.getCategoryList();
				request.setAttribute("category", cat);
				AuctionItem[] auction = model.getUserAuction(userid);
				request.setAttribute("auction", auction);
    			RequestDispatcher dispatcher = request.getRequestDispatcher("myAuction.jsp");
    			dispatcher.forward(request, response);
			} catch (WebAuctionException ex) {
				
				request.setAttribute("message", ex.getMessage());
				RequestDispatcher dispatcher = request.getRequestDispatcher("indexItemController");
				dispatcher.forward(request, response);
			};
		}else if(path.equals("/RemoveAuction")){
			String id = request.getParameter("id");
			System.out.println("BBBBBBBBBBB: "+ id);
			try {
				model.deleteAuction(id);
				RequestDispatcher dispatcher = request.getRequestDispatcher("MyAuction");
    			dispatcher.forward(request, response);
			} catch (WebAuctionException e) {
				e.printStackTrace();
			}
		} else if(path.equals("/SearchAuction")){
			String name = request.getParameter("name");
			System.out.println("XXXXXXXXX: "+ name);
			try {
				Category[] cat = catModel.getCategoryList();
				request.setAttribute("category", cat);
				AuctionItem[] auction = model.searchAuction(name);
				request.setAttribute("auction", auction);
    			RequestDispatcher dispatcher = request.getRequestDispatcher("searchedAuctionList.jsp");
    			dispatcher.forward(request, response);
			} catch (WebAuctionException e) {
				e.printStackTrace();
			}
		}else if(path.equals("/AuctionOverview")){
			String id = request.getParameter("id");
			try {
				Category[] cat = catModel.getCategoryList();
				request.setAttribute("category", cat);
				AuctionItem[] auction = model.getSearchedAuction(id);
				BidHistory[] bidHistory = bidModel.getBidHistory(id);
		        request.setAttribute("auction", auction);
		        request.setAttribute("bidHistory", bidHistory);
    			RequestDispatcher dispatcher = request.getRequestDispatcher("auctionOverview.jsp");
    			dispatcher.forward(request, response);
			} catch (WebAuctionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(path.equals("/CreateAuction")){
			
			try {
				Category[] cat = catModel.getCategoryList();
				request.setAttribute("category", cat);
				RequestDispatcher dispatcher = request.getRequestDispatcher("createAuction.jsp");
    			dispatcher.forward(request, response);
			} catch (WebAuctionException e) {
				e.printStackTrace();
			}
			
		}

	}
}