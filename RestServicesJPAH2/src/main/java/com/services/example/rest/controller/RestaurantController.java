package com.services.example.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.services.example.rest.pojo.RestaurantDetail;
import com.services.example.rest.pojo.RestaurantRequest;
import com.services.example.rest.pojo.RestaurantRequestObject;
import com.services.example.rest.pojo.RestaurantResponseObject;
import com.services.example.rest.service.RestaurantService;

/**
 * This class lists all the methods that are required to get the restaurant
 * details.
 * 
 * @author rameaasy@gmail.com
 *
 */
@RestController
@RequestMapping(value = "/rest")
public class RestaurantController {

	/** The restaurant service. */
	@Autowired
	RestaurantService restaurantService;

	/**
	 * Gets the all restaurants.
	 *
	 * @return theRestaurantResponseObject
	 */
	@GetMapping("/v0.1/list-all-restaurants")
	ResponseEntity<RestaurantResponseObject> getAllRestaurants() {
		List<String> restaurantList = restaurantService.getAllRestaurants();
		RestaurantResponseObject restaurantResponseObject = new RestaurantResponseObject();
		restaurantResponseObject.setRestaurantList(restaurantList);
		ResponseEntity<RestaurantResponseObject> response = new ResponseEntity<RestaurantResponseObject>(
				restaurantResponseObject, HttpStatus.OK);
		return response;
	}

	/**
	 * Gets the restaurant Detail.
	 *
	 * @return the RestaurantResponseObject
	 */
	@GetMapping("/v0.1/restaurant-detail")
	ResponseEntity<RestaurantResponseObject> getRestaurantDetail(@RequestParam Integer id) {
		RestaurantDetail restaurantDetail = restaurantService.getRestaurantDetail(id);
		RestaurantResponseObject restaurantResponseObject = new RestaurantResponseObject();
		if (restaurantDetail == null) {
			restaurantResponseObject.setMessage("Record not available");
			ResponseEntity<RestaurantResponseObject> response = new ResponseEntity<RestaurantResponseObject>(
					restaurantResponseObject, HttpStatus.OK);
			return response;
		}
		restaurantResponseObject.setRestaurantDetail(restaurantDetail);
		ResponseEntity<RestaurantResponseObject> response = new ResponseEntity<RestaurantResponseObject>(
				restaurantResponseObject, HttpStatus.OK);
		return response;
	}

	/**
	 * Gets the restaurant Detail.
	 *
	 * @return the RestaurantResponseObject
	 */
	@PostMapping(path = "/v0.1/restaurant-details", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	ResponseEntity<RestaurantResponseObject> getRestaurantDetails(@RequestBody RestaurantRequest restaurantRequest) {
		RestaurantResponseObject restaurantResponseObject = new RestaurantResponseObject();
		List<RestaurantDetail> restaurantDetailsList = restaurantService
				.getSubsetRestaurantDetails(restaurantRequest.getFromId(), restaurantRequest.getToId());
		if (restaurantDetailsList.isEmpty()) {
			restaurantResponseObject.setMessage("Records not available for the given subset");
			ResponseEntity<RestaurantResponseObject> response = new ResponseEntity<RestaurantResponseObject>(
					restaurantResponseObject, HttpStatus.OK);
			return response;
		}
		restaurantResponseObject.setRestaurantDetails(restaurantDetailsList);
		ResponseEntity<RestaurantResponseObject> response = new ResponseEntity<RestaurantResponseObject>(
				restaurantResponseObject, HttpStatus.OK);
		return response;
	}

	/**
	 * Inserts the restaurant Detail object in Restaurant table.
	 *
	 * @return the RestaurantResponseObject
	 */
	@PutMapping(path = "/v0.1/restaurant-detail/{id}")
	ResponseEntity<RestaurantResponseObject> insertRestaurant(
			@RequestBody RestaurantRequestObject restaurantRequestObject, @PathVariable Integer id) {
		RestaurantResponseObject restaurantResponseObject = new RestaurantResponseObject();
		RestaurantDetail restaurantDetail = restaurantService.getRestaurantDetail(id);
		if (restaurantDetail != null) {
			restaurantResponseObject.setMessage("Record already available");
			ResponseEntity<RestaurantResponseObject> response = new ResponseEntity<RestaurantResponseObject>(
					restaurantResponseObject, HttpStatus.OK);
			return response;
		}
		restaurantService.saveRestaurantDetail(restaurantRequestObject);
		restaurantDetail = restaurantService.getRestaurantDetail(id);
		restaurantResponseObject.setRestaurantDetail(restaurantDetail);
		ResponseEntity<RestaurantResponseObject> response = new ResponseEntity<RestaurantResponseObject>(
				restaurantResponseObject, HttpStatus.OK);
		return response;
	}

	/**
	 * Inserts the restaurant Detail object in Restaurant table.
	 *
	 * @return the RestaurantResponseObject
	 */
	@DeleteMapping(path = "/v0.1/remove-restaurant-detail/{id}")
	ResponseEntity<RestaurantResponseObject> removeRestaurant(@PathVariable Integer id) {
		RestaurantResponseObject restaurantResponseObject = new RestaurantResponseObject();
		RestaurantDetail restaurantDetail = restaurantService.getRestaurantDetail(id);
		ResponseEntity<RestaurantResponseObject> response = new ResponseEntity<RestaurantResponseObject>(
				restaurantResponseObject, HttpStatus.OK);
		if (restaurantDetail == null) {
			restaurantResponseObject.setMessage("Record not available");
			return response;
		}
		restaurantService.removeRestaurantDetail(id);
		restaurantResponseObject.setMessage("Record removed successfully");
		return response;
	}
}
