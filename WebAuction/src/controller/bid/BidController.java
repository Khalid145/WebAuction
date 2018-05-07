package controller.bid;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.auction.Auction;
import model.auction.AuctionModel;
import model.bid.Bid;
import model.bid.BidModel;
import webAuctionException.WebAuctionException;

/**
 * Servlet implementation class BidController
 */
@WebServlet({ "/BidController", "/PlaceBid" })
public class BidController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private BidModel bidModel;
	
	@EJB
	private AuctionModel auctionModel;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BidController() {
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

		    		HttpSession session = request.getSession(false);  
       		
        	   
        	   if(path.equals("/PlaceBid")){
        		   if(session.getAttribute("userid") == null){
        			   RequestDispatcher dispatcher = request.getRequestDispatcher("LoginBuffer");
	   				   dispatcher.forward(request, response);
        		   }else{
        		   try {
        		   		    	
        		   		    	String id = request.getParameter("id");
        		   		    	Auction auc = auctionModel.getAuction(id);
        		   		    	
        		   		    	String bid = request.getParameter("bid");
        		   		    	String webBid = request.getParameter("webBid");
        		   		    	String dbBid = auc.getCurrentbid();

        		   		        System.out.println("Wesbite Bid Amount: " + webBid);
        		   		    	System.out.println("Database Bid Amount: " + dbBid);
        		   		    	System.out.println("Your Proposed Bid: " + bid);
        		   		    	
        		   		    	double IntBid = Double.parseDouble(bid);
        		   		    	double IntWebBid = Double.parseDouble(dbBid);
        		   		    	double IntDbBid = Double.parseDouble(webBid);
        		   		    	
        		   		    	if(IntDbBid != IntWebBid){
        		   		    		System.out.println("UNSYCHRNOISED!!!!!!");
        		   		    		request.setAttribute("message", "A user has just bidded. Bid quick!");
        		   		    	}else if (IntDbBid == IntWebBid && IntWebBid < IntBid){
        		   		    		
        		   		   
        		   					String userid = (String) session.getAttribute("userid");
        		   					
        		   					DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        		   				Date today = Calendar.getInstance().getTime(); 
        		   				String reportDate = df.format(today);
        		   				
        		   		    		bidModel.addBid(new Bid("0",id,userid,bid,reportDate));
        		   		    		auctionModel.updateAuction(id,bid);
        		   		    		request.setAttribute("message", "Successful Bid!!");
        		   		    		
        		   		    	} else {
        		   		    		request.setAttribute("message", "Your bid must be higher than the current price.");
        		   		    	}
        		   		    	
        		   			     request.setAttribute("auction", auc);
        		   			     RequestDispatcher dispatcher = request.getRequestDispatcher("AuctionOverview");
        		   				   dispatcher.forward(request, response);

        		   		    } catch (WebAuctionException ex) {
        		   		        request.setAttribute("message", ex.getMessage());
        		   		        }
        		   		}
        	   }
        		   		 

           }

}
