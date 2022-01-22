package com.services.example.rest.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.example.rest.model.Restaurant;
import com.services.example.rest.pojo.RestaurantDetail;
import com.services.example.rest.pojo.RestaurantRequestObject;
import com.services.example.rest.repo.RestaurantRepository;

/**
 * The Class RestaurantServiceImpl.
 * 
 * @author rameasy@gmail.com
 */
@Service
public class RestaurantService {

	/** The restaurant repository. */
	@Autowired
	RestaurantRepository restaurantRepository;

	/**
	 * Gets the all restaurants.
	 *
	 * @return the all restaurants
	 */
	public List<String> getAllRestaurants() {
		return restaurantRepository.findAll().stream().map(Restaurant::getName).collect(Collectors.toList());
	}

	/**
	 * Gets the restaurant detail.
	 *
	 * @return the object
	 */
	public RestaurantDetail getRestaurantDetail(Integer id) {
		Optional<Object> restaurantDetailOptionalObject = restaurantRepository.findRestaurantDetail(id);
		if (restaurantDetailOptionalObject.isEmpty()) {
			return null;
		}
		RestaurantDetail restaurantDetail = new RestaurantDetail();
		Object[] restaurantDetails = (Object[]) restaurantDetailOptionalObject.get();
		restaurantDetail.setRestaurantName(restaurantDetails[0].toString());
		restaurantDetail.setCityName(restaurantDetails[1].toString());
		restaurantDetail.setDeliveryApp(restaurantDetails[2].toString());
		restaurantDetail.setCountry(restaurantDetails[3].toString());
		return restaurantDetail;
	}

	/**
	 * Gets the restaurant details subset.
	 *
	 * @return the object
	 */
	public List<RestaurantDetail> getSubsetRestaurantDetails(Integer fromId, Integer toId) {
		List<Optional<Object>> restaurantDetails = restaurantRepository.findSubsetRestaurantDetail(fromId, toId);
		List<RestaurantDetail> restaurantDetailsList = new ArrayList<>();
		if (restaurantDetails.isEmpty()) {
			return Collections.emptyList();
		}
		restaurantDetails.forEach(restaurantDetailOptionalObject -> {
			Object[] restaurantDetailObject = (Object[]) restaurantDetailOptionalObject.get();
			RestaurantDetail restaurantDetail = new RestaurantDetail();
			restaurantDetail.setRestaurantName(restaurantDetailObject[0].toString());
			restaurantDetail.setCityName(restaurantDetailObject[1].toString());
			restaurantDetail.setDeliveryApp(restaurantDetailObject[2].toString());
			restaurantDetail.setCountry(restaurantDetailObject[3].toString());
			restaurantDetailsList.add(restaurantDetail);
		});
		return restaurantDetailsList;
	}

	/**
	 * This method helps to save the restuarant detail.
	 *
	 * @return the object
	 */
	public void saveRestaurantDetail(RestaurantRequestObject rro) {
		Restaurant restaurant = new Restaurant(rro.getId(), rro.getName(), rro.getCityId(), rro.getDeliveryAppId());
		restaurantRepository.saveAndFlush(restaurant);
	}

	/**
	 * This method helps to delete the restuarant detail for the received id value.
	 *
	 * @return the object
	 */
	public void removeRestaurantDetail(Integer id) {
		restaurantRepository.deleteById(id);
	}
}
