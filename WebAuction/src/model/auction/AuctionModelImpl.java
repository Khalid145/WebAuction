package model.auction;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Singleton;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.user.UserModel;
import webAuctionException.WebAuctionException;

@Local @Singleton
public class AuctionModelImpl implements AuctionModel{
	
	@PersistenceContext
	private EntityManager emgr;
	
	


    public AuctionModelImpl() {

    }
    
    
    
    
    
    
    @Override
    public void addAuction(Auction auction) throws WebAuctionException {
    	System.out.println(auction);
    	try {
    		emgr.persist(auction);
    	} catch (EntityExistsException ex) {
    		throw new WebAuctionException("Duplicate Id : ");
    	}
    	
    }
    
    
    @Override
	public Auction getAuction(String id) throws WebAuctionException {
		Auction auc = emgr.find(Auction.class, id);
		
		if (auc != null) {
			emgr.refresh(auc);
			return auc;
		} else {
			throw new WebAuctionException("Auction : " + id + " not found");
		}
	}
    
    @Override
    public void updateAuction(String id, String currentbid) throws WebAuctionException {
    	int query = emgr.createNativeQuery("UPDATE Auction SET currentBid='" + currentbid + "' WHERE auctionId ='" + id + "'").executeUpdate();
    	System.out.println(query);
    }

    
    @SuppressWarnings("unchecked")
	public AuctionItem[] getUserAuction(String userid) throws WebAuctionException {
    	/* REPLACE THE LIST OF STUDENTMARK WITH THE RESULT OF SQL QUERY */ 
	  Query query = emgr.createNativeQuery("SELECT Item.itemid, Auction.auctionId, Item.itemname, Category.catName, Auction.startprice,Auction.currentbid FROM Item INNER JOIN Category on Item.catid = Category.catid INNER JOIN Auction on Item.itemid = Auction.auctionId where Item.sellerid = '" + userid + "'ORDER BY Auction.auctionId DESC",AuctionItem.class);
		List<AuctionItem> auctions = new ArrayList<AuctionItem>();
		auctions = (List<AuctionItem>) query.getResultList();
		System.out.println("PPPPPPPPPPP: " + auctions);
		return (AuctionItem[]) auctions.toArray(new AuctionItem[0]);
    }
    
    
    public void deleteAuction(String itemid) throws WebAuctionException {
    	/* REPLACE DEL OPERATION WITH JPA VERSION*/
    	 int query = emgr.createNativeQuery("DELETE Bid, Auction, Item FROM Auction INNER JOIN Bid on Auction.auctionId= Bid.auctionId INNER JOIN  Item  on Auction.itemId = Item.itemid WHERE  Auction.itemId='" + itemid + "'").executeUpdate();
    	 System.out.println("AAAAAA: " + query);
    }
    
    
    @SuppressWarnings("unchecked")
	public AuctionItem[] searchAuction(String name) throws WebAuctionException {
    	/* REPLACE THE LIST OF STUDENTMARK WITH THE RESULT OF SQL QUERY */ 
	  Query query = emgr.createNativeQuery("SELECT Item.itemid, Auction.auctionId, Item.itemname, Category.catName, Auction.startprice,Auction.currentbid FROM Item INNER JOIN Category on Item.catid = Category.catid INNER JOIN Auction on Item.itemid = Auction.auctionId where Item.itemname LIKE '%"+name+"%'",AuctionItem.class);
		List<AuctionItem> auctions = new ArrayList<AuctionItem>();
		auctions = (List<AuctionItem>) query.getResultList();
		System.out.println("PPPPPPPPPPP: " + auctions);
		return (AuctionItem[]) auctions.toArray(new AuctionItem[0]);
    }
    
    
    
    @SuppressWarnings("unchecked")
	public AuctionItem[] getSearchedAuction(String id) throws WebAuctionException {
    	/* REPLACE THE LIST OF STUDENTMARK WITH THE RESULT OF SQL QUERY */ 
	  Query query = emgr.createNativeQuery("SELECT Item.itemid, Auction.auctionId, Item.itemname, Category.catName, Auction.startprice,Auction.currentbid FROM Item INNER JOIN Category on Item.catid = Category.catid INNER JOIN Auction on Item.itemid = Auction.auctionId where Item.itemid ='" + id + "'",AuctionItem.class);
	  List<AuctionItem> auctions = new ArrayList<AuctionItem>();
		auctions = (List<AuctionItem>) query.getResultList();
		System.out.println("PPPPPPPPPPP: " + auctions);
		return (AuctionItem[]) auctions.toArray(new AuctionItem[0]);
  }
    
    @SuppressWarnings("unchecked")
	public AuctionItem[] getCategorisedAuction(String id) throws WebAuctionException {
    	/* REPLACE THE LIST OF STUDENTMARK WITH THE RESULT OF SQL QUERY */ 
	  Query query = emgr.createNativeQuery("SELECT Item.itemid, Auction.auctionId, Item.itemname, Category.catName, Auction.startprice,Auction.currentbid FROM Item INNER JOIN Category on Item.catid = Category.catid INNER JOIN Auction on Item.itemid = Auction.auctionId where Item.catid ='" + id + "'",AuctionItem.class);
	  List<AuctionItem> auctions = new ArrayList<AuctionItem>();
		auctions = (List<AuctionItem>) query.getResultList();
		System.out.println("PPPPPPPPPPP: " + auctions);
		return (AuctionItem[]) auctions.toArray(new AuctionItem[0]);
    }

}
