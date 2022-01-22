package com.services.example.rest.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

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
public class RestaurantRequest {
	/** The from id. */
	@JsonProperty("from-id")
	private Integer fromId;

	/** The to id. */
	@JsonProperty("to-id")
	private Integer toId;
}
