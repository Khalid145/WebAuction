package model.user;

import webAuctionException.WebAuctionException;

public interface UserModel {
	
	 public User[] checkLogin(String name, String password)
	            throws WebAuctionException; 
	 
	 public User[] getUserDetails(String id)
	            throws WebAuctionException; 

}
