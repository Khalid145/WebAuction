package model.auction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AuctionItem {

	@Column(name = "ITEMID")
	private String itemid;
	@Id
	@Column(name = "AUCTIONID")
	private String auctionid;
	@Column(name = "ITEMNAME")
	private String itemname;
	@Column(name = "CATNAME")
	private String catName;
	@Column(name = "STARTPRICE")
	private String startprice;
	@Column(name = "CURRENTBID")
	private String currentbid;
	
	
	public AuctionItem(String itemid, String auctionid, String itemname, String catName, String startprice,
			String currentbid) {
		super();
		this.itemid = itemid;
		this.auctionid = auctionid;
		this.itemname = itemname;
		this.catName = catName;
		this.startprice = startprice;
		this.currentbid = currentbid;
	}
	
	
	public AuctionItem(){
		this(null,null,null,null,null,null);
	}


	public String getItemid() {
		return itemid;
	}


	public void setItemid(String itemid) {
		this.itemid = itemid;
	}


	public String getAuctionid() {
		return auctionid;
	}


	public void setAuctionid(String auctionid) {
		this.auctionid = auctionid;
	}


	public String getItemname() {
		return itemname;
	}


	public void setItemname(String itemname) {
		this.itemname = itemname;
	}


	public String getCatName() {
		return catName;
	}


	public void setCatName(String catName) {
		this.catName = catName;
	}


	public String getStartprice() {
		return startprice;
	}


	public void setStartprice(String startprice) {
		this.startprice = startprice;
	}


	public String getCurrentbid() {
		return currentbid;
	}


	public void setCurrentbid(String currentbid) {
		this.currentbid = currentbid;
	}


	@Override
	public String toString() {
		return "AuctionItem [itemid=" + itemid + ", auctionid=" + auctionid + ", itemname=" + itemname + ", catName="
				+ catName + ", startprice=" + startprice + ", currentbid=" + currentbid + "]";
	}
	
	
	
	
	
	
	
}