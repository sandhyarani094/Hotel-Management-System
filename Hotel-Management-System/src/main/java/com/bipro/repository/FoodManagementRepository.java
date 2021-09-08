package com.bipro.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bipro.model.FoodManagement;

public interface FoodManagementRepository extends JpaRepository<FoodManagement, Integer> {

	@Modifying
	@Transactional
	@Query(value = "update fooditems set foodcategory=?1,itemname=?2,mealtype=?3,price=?4,status=?5 where itemid=?6", nativeQuery = true)
	public int updateFoodDetails(String foodCategory, String itemName, String mealType, double price, boolean status,
			int itemId);

	@Modifying
	@Transactional
	@Query(value = "delete from fooditems where itemid=?", nativeQuery = true)
	public int deleteFoodDetailsById(int itemId);

	@Query(value = "select count(*) from fooditems where upper(itemname)=?", nativeQuery = true)
	public int checkItemName(String itemName);

	@Query(value = "select * from fooditems where foodcategory=?", nativeQuery = true)
	public List<FoodManagement> getAllFoodDetailsByCategory(String type);

}
