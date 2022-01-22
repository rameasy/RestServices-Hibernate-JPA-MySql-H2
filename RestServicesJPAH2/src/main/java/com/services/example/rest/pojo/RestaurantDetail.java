package com.services.example.rest.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class RestaurantDetail.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(Include.NON_NULL)
public class RestaurantDetail {
	
	/** The restaurant name. */
	@JsonProperty("name")
	private String restaurantName;

	/** The city name. */
	@JsonProperty("city")
	private String cityName;

	/** The country. */
	@JsonProperty("country")
	private String country;

	/** The delivery app. */
	@JsonProperty("app")
	private String deliveryApp;
}
