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
 * The Class DeliveryApp.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Immutable
@Table(name = "DELIVERY_APPS")
public class DeliveryApp {

	/** The id. */
	@Id
	private Integer id;

	/** The name. */
	private String name;

	/** The is IOS available. */
	@Column(name = "IS_IOS_AVAILABLE")
	private boolean isIOSAvailable;

	/** The is andriod OS available. */
	@Column(name = "IS_ANDRIOD_OS_AVAILABLE")
	private boolean isAndriodOSAvailable;
}
