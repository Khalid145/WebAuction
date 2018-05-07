package model.bid;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BidHistory {
	
	@Id
	@Column(name = "BIDID")
	private String bidId;
	@Column(name = "AUCTIONID")
	private String auctionId;
	@Column(name = "NAME")
	private String name;
	@Column(name = "BIDAMOUNT")
	private String bidAmount;
	@Column(name = "TIME")
	private String time;
	
	public BidHistory(String bidId, String auctionId, String name, String bidAmount, String time) {
		super();
		this.bidId = bidId;
		this.auctionId = auctionId;
		this.name = name;
		this.bidAmount = bidAmount;
		this.time = time;
	}
	
	public BidHistory(){
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "BidHistory [bidId=" + bidId + ", auctionId=" + auctionId + ", name=" + name + ", bidAmount=" + bidAmount
				+ ", time=" + time + "]";
	}
	
	
	
}
