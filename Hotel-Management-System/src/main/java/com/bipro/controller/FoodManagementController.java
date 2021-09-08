package com.bipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bipro.model.FoodManagement;
import com.bipro.model.Response;
import com.bipro.repository.FoodManagementRepository;

@RestController
public class FoodManagementController {
	@Autowired
	FoodManagementRepository foodRepo;

	@PostMapping("/saveFoodItem")
	public Response saveFoodItem(@RequestBody FoodManagement foods) {
		Response resp = new Response();
		int count = foodRepo.checkItemName(foods.getItemName().toUpperCase());
		if (count == 0) {
			foodRepo.save(foods);
			resp.setResponseValue("Food item saved successfully");
		} else {
			resp.setResponseValue("Food item already exist");
		}
		return resp;
	}

	@PostMapping("/updateFoodDetails")
	public Response updateFoodDetails(@RequestBody FoodManagement foods) {
		Response resp = new Response();
		int updateCount = foodRepo.updateFoodDetails(foods.getFoodCategory(), foods.getItemName(), foods.getMealType(),
				foods.getPrice(), foods.isStatus(), foods.getItemId());
		if (updateCount > 0) {
			resp.setResponseValue("Food item saved successfully");
		} else {
			resp.setResponseValue("Unable to update food item");
		}
		return resp;
	}

	@PostMapping("/deleteFoodDetailsById")
	public Response deleteFoodDetailsById(@RequestBody int itemId) {
		Response resp = new Response();
		int deleteCount = foodRepo.deleteFoodDetailsById(itemId);
		System.out.println(deleteCount);
		if (deleteCount > 0) {
			resp.setResponseValue("Food item deleted successfully");
		} else {
			resp.setResponseValue("Unable to delete food item");
		}
		return resp;
	}

	@GetMapping("/getAllFoodDetails")
	public List<FoodManagement> getAllFoodDetails() {
		return foodRepo.findAll();

	}

	@PostMapping("/getAllFoodDetailsByCategory")
	public List<FoodManagement> getAllFoodDetailsByCategory(@RequestBody String type) {
		return foodRepo.getAllFoodDetailsByCategory(type);

	}

	@PostMapping("/getFoodDetailsById")
	public FoodManagement getFoodDetailsById(int itemId) {
		return foodRepo.findById(itemId).get();
	}

}
