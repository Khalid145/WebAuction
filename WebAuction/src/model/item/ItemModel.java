package model.item;

import webAuctionException.WebAuctionException;

public interface ItemModel {
	
	 public void addItem(Item item) throws WebAuctionException; 
	 
	 public Item[] getLastUserItemId(String userid) throws WebAuctionException; 
	 
	 

}
