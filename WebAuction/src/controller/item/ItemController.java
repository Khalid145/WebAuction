package controller.item;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolationException;

import model.auction.Auction;
import model.auction.AuctionModel;
import model.item.Item;
import model.item.ItemModel;
import model.user.User;
import webAuctionException.WebAuctionException;


/**
 * Servlet implementation class ItemController
 */
@WebServlet(name = "ItemController", urlPatterns = {"/ItemController"})
public class ItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB private ItemModel itemModel;
	@EJB private AuctionModel auctionModel;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		            throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		            throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

	/**
	 * TO BE WRITTEN BY THE STUDENTS
	 */	
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	   			throws ServletException, IOException {
        	
        	String path = request.getServletPath();
    		if (path.equals("/ItemController")) {
    			
    			User user = new User();
    			
    			 HttpSession session = request.getSession(false);  
    			
    			String userid = (String) session.getAttribute("userid");

    		    String itemId = "";
    		    String auctionId = "";
    		    String itemName = request.getParameter("itemname");
    		    String catId = request.getParameter("category");
    		    String sellerId = userid;
    		    
    		    String startprice = request.getParameter("startprice");
    		    String currentbid = startprice;
    		    String submit = request.getParameter("submit");
    		    
    		    try {
					itemModel.addItem(new Item(itemId,itemName,catId,sellerId));
					
					Item[] item = itemModel.getLastUserItemId(userid);
					String lastItemId = null;
					for(int i = 0; i < item.length; i++){
						lastItemId = item[i].getItemid();
					}
					auctionModel.addAuction(new Auction(auctionId,lastItemId,startprice,currentbid));
					
					
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("MyAuction");
	    			dispatcher.forward(request, response);
				} catch (ConstraintViolationException | WebAuctionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
    	
    		    
    		    
        
        

        }
        }
}