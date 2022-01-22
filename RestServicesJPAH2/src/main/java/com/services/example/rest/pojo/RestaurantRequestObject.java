package com.services.example.rest.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The model class for RestaurantRequestObject.
 * 
 * @author rameasy@gmail.com
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@JsonInclude(Include.NON_NULL)
public class RestaurantRequestObject {

	/** The id. */
	@JsonProperty("id")
	private Integer id;

	/** The name. */
	@JsonProperty("name")
	private String name;

	/** The city id. */
	@JsonProperty("cityId")
	private Integer cityId;

	/** The delivery apps id. */
	@JsonProperty("deliveryAppId")
	private Integer deliveryAppId;
}
