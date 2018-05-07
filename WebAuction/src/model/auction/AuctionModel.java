package model.auction;

import java.util.List;

import webAuctionException.WebAuctionException;

public interface AuctionModel {
	
	
	 public void addAuction(Auction auction)
           throws WebAuctionException; 
	 
	 public Auction getAuction(String id)
	            throws WebAuctionException;
	
	 public AuctionItem[] getUserAuction(String userid)
			 throws WebAuctionException; 
	 
	 public void deleteAuction(String itemid)
	            throws WebAuctionException;
	 
	 public AuctionItem[] searchAuction(String name)
			 throws WebAuctionException; 
	 
	 public AuctionItem[] getSearchedAuction(String id)
	            throws WebAuctionException;

	public void updateAuction(String id, String currentbid) 
			throws WebAuctionException;
	
	public AuctionItem[] getCategorisedAuction(String id) throws WebAuctionException;
	
	

}
