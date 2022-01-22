package com.services.example.rest.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.services.example.rest.model.Restaurant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class RestaurantResponseObject.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(Include.NON_NULL)
public class RestaurantResponseObject {
	/** The restaurant list. */
	@JsonProperty("restaurants")
	private List<String> restaurantList;

	/** The restaurant. */
	@JsonProperty("restaurant")
	private Restaurant restaurant;

	/** The delivery app. */
	@JsonProperty("restaurant-detail")
	private RestaurantDetail restaurantDetail;

	/** The message. */
	@JsonProperty("restaurant-details")
	private List<RestaurantDetail> restaurantDetails;

	/** The message. */
	@JsonProperty("message")
	private String message;
}
