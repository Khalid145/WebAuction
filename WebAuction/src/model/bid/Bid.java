package model.bid;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Bid")
public class Bid implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "BIDID")
	private String bidId;
	@Column(name = "AUCTIONID")
	private String auctionId;
	@Column(name = "BIDDERID")
	private String bidderId;
	@Column(name = "BIDAMOUNT")
	private String bidAmount;
	@Column(name = "TIME")
	private String time;
	
	public Bid(String bidId, String auctionId, String bidderId, String bidAmount, String time) {
		super();
		this.bidId = bidId;
		this.auctionId = auctionId;
		this.bidderId = bidderId;
		this.bidAmount = bidAmount;
		this.time = time;
	}
	
	public Bid(){
		this(null,null,null,null,null);
	}

	public String getBidId() {
		return bidId;
	}

	public void setBidId(String bidId) {
		this.bidId = bidId;
	}

	public String getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(String auctionId) {
		this.auctionId = auctionId;
	}

	public String getBidderId() {
		return bidderId;
	}

	public void setBidderId(String bidderId) {
		this.bidderId = bidderId;
	}

	public String getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(String bidAmount) {
		this.bidAmount = bidAmount;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Bid [bidId=" + bidId + ", auctionId=" + auctionId + ", bidderId=" + bidderId + ", bidAmount="
				+ bidAmount + ", time=" + time + "]";
	}
	
	
	
	
	

}
