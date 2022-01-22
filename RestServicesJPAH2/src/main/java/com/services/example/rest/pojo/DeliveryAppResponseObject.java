package com.services.example.rest.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.services.example.rest.model.DeliveryApp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class DeliveryAppResponseObject.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(Include.NON_NULL)
public class DeliveryAppResponseObject {
	/** The delivery app list. */
	@JsonProperty("deliveryApps")
	private List<String> deliveryAppList;

	/** The delivery app. */
	@JsonProperty("deliveryApp")
	private DeliveryApp deliveryApp;

	/** The message. */
	@JsonProperty("message")
	private String message;
}
