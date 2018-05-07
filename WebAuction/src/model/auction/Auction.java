package model.auction;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Auction")
public class Auction implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "AUCTIONID")
	private String auctionid;
	@Column(name = "ITEMID")
	private String itemid;
	@Column(name = "STARTPRICE")
	private String startprice;
	@Column(name = "CURRENTBID")
	private String currentbid;
	
	
	public Auction(String auctionid, String itemid, String startprice, String currentbid) {
		super();
		this.auctionid = auctionid;
		this.itemid = itemid;
		this.startprice = startprice;
		this.currentbid = currentbid;
	}
	
	public Auction(){
		this(null,null,null,null);
	}

	public String getItemid() {
		return itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
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

	public String getAuctionid() {
		return auctionid;
	}

	@Override
	public String toString() {
		return "Auction [auctionid=" + auctionid + ", itemid=" + itemid + ", startprice=" + startprice + ", currentbid="
				+ currentbid + "]";
	}
	
	
	
	
	
	
	

}
