package controller.category;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.auction.AuctionItem;
import model.auction.AuctionModel;
import model.category.Category;
import model.category.CategoryModel;
import model.item.ItemModel;
import webAuctionException.WebAuctionException;

/**
 * Servlet implementation class CategoryController
 */
@WebServlet(name = "CategoryController", urlPatterns = {"/CategoryController","/indexItemController"})
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB private CategoryModel catModel;
	
	@EJB
	private AuctionModel model;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryController() {
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
        	   HttpSession session = request.getSession();
        	   
        	   
        	   if(path.equals("/indexItemController")){
				try {
					Category[] cat = catModel.getCategoryList();
					request.setAttribute("category", cat);
	   				RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
	       			dispatcher.forward(request, response);
				} catch (WebAuctionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
   				
        		   
        	   }else if(path.equals("/CategoryController")){
        		   String catid = request.getParameter("catid");
        		   System.out.println("DDDDDDDD: " + catid);
        		   try {
        			   
        			   
        			   String sess = "";
            		   
            		    if(session == null){
            		    	sess="AAAAAAAAAA: NO SESSION";
            		    }else{
            		    	sess="BBBBBBBB: YESSSS SESSION";
            		    }
            		    
            		    
            		    
        			   
            		    Category[] cat = catModel.getCategoryList();
    					request.setAttribute("category", cat);
					AuctionItem[] auction = model.getCategorisedAuction(catid);
					request.setAttribute("auction", auction);
					request.setAttribute("sess", sess);
	    			RequestDispatcher dispatcher = request.getRequestDispatcher("categorisedAuction.jsp");
	    			dispatcher.forward(request, response);
				} catch (WebAuctionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		   
        		   
        	   }
        	   
        	   
        	   
        	   
           }

}
