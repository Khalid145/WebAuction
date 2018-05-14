package model.bid;

import webAuctionException.WebAuctionException;

public interface BidModel {
	
	public void addBid(Bid bid) throws WebAuctionException;
	
	 public BidHistory[] getBidHistory(String id)
			 throws WebAuctionException; 
	 
	 
	
	 public void deleteAuction(String auctionid)
	            throws WebAuctionException;

}
