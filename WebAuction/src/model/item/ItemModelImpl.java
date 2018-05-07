package model.item;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Singleton;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.auction.Auction;
import webAuctionException.WebAuctionException;

@Local @Singleton
public class ItemModelImpl implements ItemModel {
	
	@PersistenceContext
	private EntityManager emgr;
	


 public ItemModelImpl() {
	 
 }


@Override
public void addItem(Item item) throws WebAuctionException {
	System.out.println(item);
	System.out.println(" ----- " + emgr);
	try {
		emgr.persist(item);
	} catch (EntityExistsException ex) {
		throw new WebAuctionException("Duplicate Id : ");
	}
	
}

@SuppressWarnings("unchecked")
public Item[] getLastUserItemId(String userid) throws WebAuctionException {
	/* REPLACE THE LIST OF STUDENTMARK WITH THE RESULT OF SQL QUERY */ 
	Query query = emgr.createNativeQuery("SELECT itemid FROM Item Where sellerid = '"+userid+"' ORDER BY itemid DESC LIMIT 0,1",	Item.class);
	List<Item> items = new ArrayList<Item>();
	items = (List<Item>) query.getResultList();
	System.out.println("PPPPPPPPPPP: " + items);
	if (items.size() == 0) {
		throw new WebAuctionException("You have no items.");
	} else {
		return (Item[]) items.toArray(new Item[0]);
	}
}



 
 
 
	
	

}
