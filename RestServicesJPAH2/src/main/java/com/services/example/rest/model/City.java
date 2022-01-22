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
 * The Class City.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Immutable
@Table(name = "Cities")
public class City {

	/** The id. */
	@Id
	private Integer id;

	/** The name. */
	private String name;

	/** The country id. */
	@Column(name="COUNTRY_ID")
	private Integer countryId;
}
