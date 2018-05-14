package model.bid;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Singleton;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.auction.AuctionItem;
import webAuctionException.WebAuctionException;

@Local @Singleton
public class BidModelImpl implements BidModel{
	
	@PersistenceContext
	private EntityManager emgr;

 public BidModelImpl() {
	 
 }

@Override
public synchronized void addBid(Bid bid) throws WebAuctionException {
	try {
		emgr.persist(bid);
	} catch (EntityExistsException ex) {
		throw new WebAuctionException("Duplicate Id : ");
	}
	
}

@SuppressWarnings("unchecked")
public BidHistory[] getBidHistory(String id) throws WebAuctionException {
	Query query = emgr.createNativeQuery("SELECT Bid.bidId, User.name, Bid.bidAmount, Bid.time,Bid.auctionId FROM Bid INNER JOIN User ON Bid.bidderId=User.userid Where Bid.auctionId ='" +  id + "'ORDER BY Bid.bidId DESC",BidHistory.class);
	List<BidHistory> auctions = new ArrayList<BidHistory>();
	auctions = (List<BidHistory>) query.getResultList();
	System.out.println("PPPPPPPPPPP: " + auctions);
	return (BidHistory[]) auctions.toArray(new BidHistory[0]);
}



@Override
public void deleteAuction(String auctionid) throws WebAuctionException {
	// TODO Auto-generated method stub
	
}
 
 

}
