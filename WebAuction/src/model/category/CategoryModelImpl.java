package model.category;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.item.Item;
import webAuctionException.WebAuctionException;

@Local @Singleton
public class CategoryModelImpl implements CategoryModel{
	
	@PersistenceContext
	private EntityManager emgr;
	


 public CategoryModelImpl() {
	 
 }

	@SuppressWarnings("unchecked")
	public Category[] getCategoryList() throws WebAuctionException {
		Query query = emgr.createNativeQuery("SELECT * FROM Category",	Category.class);
		List<Category> items = new ArrayList<Category>();
		items = (List<Category>) query.getResultList();
		System.out.println("PPPPPPPPPPP: " + items);
		if (items.size() == 0) {
			throw new WebAuctionException("You have no categories.");
		} else {
			return (Category[]) items.toArray(new Category[0]);
		}
	}

}
