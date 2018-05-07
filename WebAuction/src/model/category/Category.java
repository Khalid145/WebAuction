package model.category;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "CATID")
	private String catid;
	@Column(name = "CATNAME")
	private String catName;
	
	public Category(String catid, String catName) {
		super();
		this.catid = catid;
		this.catName = catName;
	}
	
	public Category(){
		this(null,null);
	}

	public String getCatid() {
		return catid;
	}

	public void setCatid(String catid) {
		this.catid = catid;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	@Override
	public String toString() {
		return "Category [catid=" + catid + ", catName=" + catName + "]";
	}
	
	
	

}
