package com.bipro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FOODITEMS")
public class FoodManagement {
	@Id
	@Column(name = "ITEMID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;
	@Column(name = "FOODCATEGORY")
	private String foodCategory;
	@Column(name = "ITEMNAME")
	private String itemName;
	@Column(name = "MEALTYPE")
	private String mealType;
	@Column(name = "PRICE")
	private double price;
	@Column(name = "STATUS")
	private boolean status;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public FoodManagement(int itemId, String foodCategory, String itemName, String mealType, double price,
			boolean status) {
		super();
		this.itemId = itemId;
		this.foodCategory = foodCategory;
		this.itemName = itemName;
		this.mealType = mealType;
		this.price = price;
		this.status = status;
	}

	@Override
	public String toString() {
		return "FoodManagement [itemId=" + itemId + ", foodCategory=" + foodCategory + ", itemName=" + itemName
				+ ", mealType=" + mealType + ", price=" + price + ", status=" + status + "]";
	}

	public FoodManagement() {
		super();

	}
}
