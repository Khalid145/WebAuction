package model.user;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import webAuctionException.WebAuctionException;


@Local @Singleton
public class UserModelImpl implements UserModel {
	
	@PersistenceContext
	private EntityManager emgr;
	
	   private static UserModel instance = new UserModelImpl();

	    public static UserModel getInstance() {
	        return instance;
	    }


    public UserModelImpl() {

    }
    
    @SuppressWarnings("unchecked")
  		public User[] checkLogin(String username, String password) throws WebAuctionException {
    	System.out.println(" ----- " + emgr);
    	System.out.println("A: " + username + " : " + password);
  		  Query query = emgr.createNativeQuery("SELECT * FROM User WHERE username = '"+username+"' AND password = '"+password+"'",	User.class);
  			List<User> user = new ArrayList<User>();
  			user = (List<User>) query.getResultList();
  			System.out.println("PPPPPPPPPPP: " + user);
  			if (user.size() == 0) {
  				throw new WebAuctionException("Invalid Credential");
  			} else {
  				return (User[]) user.toArray(new User[0]);
  			}
  	    }
    
    @SuppressWarnings("unchecked")
		public User[] getUserDetails(String id) throws WebAuctionException {
		  Query query = emgr.createNativeQuery("SELECT * FROM User WHERE userid = '"+id+"'",	User.class);
			List<User> user = new ArrayList<User>();
			user = (List<User>) query.getResultList();
			System.out.println("PPPPPPPPPPP: " + user);
			if (user.size() == 0) {
				throw new WebAuctionException("Invalid Credential");
			} else {
				return (User[]) user.toArray(new User[0]);
			}
	    }
  	  

}
