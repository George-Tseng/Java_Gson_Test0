package javaTest;

import java.io.Serializable;

/**
 * 物品的類別
 */

public class HDD implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*屬性*/
	private int id;
	private String productID;
	private double size;
	private String productName;
	private int hddRPM;
	private String company;
	
	/*建構子*/
	public HDD(int id, String productID, double size, String productName, int hddRPM, String company) {
		this.id = id;
		this.productID = productID;
		this.size = size;
		this.productName = productName;
		this.hddRPM = hddRPM;
		this.company = company;
	}

	/*setter & getter*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public int getHddRPM() {
		return hddRPM;
	}
	
	public void setHddRPM(int hddRPM) {
		this.hddRPM = hddRPM;
	}
	
	public String getCompany() {
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	public String toNormalString() {
		StringBuilder sb0 = new StringBuilder();
		sb0.append("id:" + id);
		sb0.append(",productID:" + productID);
		sb0.append(",size:" + size);
		sb0.append(",productName:" + productName);
		sb0.append(",hddRPM:" + hddRPM);
		sb0.append(",company:" + company);
		return sb0.toString();
	}
}
