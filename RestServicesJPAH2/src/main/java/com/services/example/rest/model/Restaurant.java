package com.services.example.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The model class for Restaurant.
 * 
 * @author rameasy@gmail.com
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Immutable
@Table(name = "Restaurants")
public class Restaurant {

	/** The id. */
	@Id
	private Integer id;

	/** The name. */
	private String name;

	/** The city id. */
	@Column(name="CITY_ID")
	private Integer cityId;

	/** The delivery apps id. */
	@Column(name="DELIVERY_APP_ID")
	private Integer deliveryAppId;
}
