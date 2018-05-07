package model.item;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Item")
public class Item implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ITEMID")
	private String itemid;
	@Column(name = "ITEMNAME")
	private String itemname;
	@Column(name = "CATID")
	private String catid;
	@Column(name = "SELLERID")
	private String sellerid;
	
	
	public Item(String itemid,String itemname, String catid,String sellerid){
		super();
		this.itemid = itemid;
		this.itemname = itemname;
		this.catid = catid;
		this.sellerid = sellerid;
	}
	
	public Item(){
		this(null, null, null, null);
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getCatid() {
		return catid;
	}

	public void setCatid(String catid) {
		this.catid = catid;
	}

	public String getSellerid() {
		return sellerid;
	}

	public void setSellerid(String sellerid) {
		this.sellerid = sellerid;
	}

	public String getItemid() {
		return itemid;
	}

	@Override
	public String toString() {
		return "Item [itemid=" + itemid + ", itemname=" + itemname + ", catid=" + catid + ", sellerid=" + sellerid
				+ "]";
	}

	
	
	

}
