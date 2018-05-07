package model.category;

import webAuctionException.WebAuctionException;

public interface CategoryModel {
	
	public Category[] getCategoryList() throws WebAuctionException; 

}
