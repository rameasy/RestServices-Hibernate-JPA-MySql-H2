package com.services.example.rest.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.example.rest.model.DeliveryApp;
import com.services.example.rest.repo.DeliveryAppRepository;

/**
 * The Class DeliveryAppService.
 * 
 * @author rameasy@gmail.com
 */
@Service
public class DeliveryAppService {

	/** The delivery app repository. */
	@Autowired
	DeliveryAppRepository deliveryAppRepository;

	/**
	 * Gets the all delivery apps.
	 *
	 * @return the all delivery apps
	 */
	public List<String> getAllDeliveryApps() {
		return deliveryAppRepository.findAll().stream().map(DeliveryApp::getName).collect(Collectors.toList());
	}
	/**
	 * Gets the all delivery apps.
	 *
	 * @return the all delivery apps
	 */
	public Optional<DeliveryApp> getDeliveryAppDetail(Integer id) {
		return deliveryAppRepository.findById(id);
	}
}
