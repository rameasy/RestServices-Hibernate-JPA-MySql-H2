package com.services.example.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.services.example.rest.model.DeliveryApp;
import com.services.example.rest.pojo.DeliveryAppResponseObject;
import com.services.example.rest.pojo.RestaurantResponseObject;
import com.services.example.rest.service.DeliveryAppService;

/**
 * This class lists all the methods that are required to get the delivery Apps
 * details.
 * 
 * @author rameaasy@gmail.com
 *
 */
@RestController
@RequestMapping(value = "/rest")
public class DeliveryAppController {

	/** The delivery app service. */
	@Autowired
	DeliveryAppService deliveryAppService;

	/**
	 * Gets the all DeliveryApps.
	 *
	 * @return the all Delivery Apps
	 */
	@GetMapping("/v0.1/list-all-apps")
	ResponseEntity<DeliveryAppResponseObject> getAllDeliveryApps() {
		List<String> deliveryAppList = deliveryAppService.getAllDeliveryApps();
		DeliveryAppResponseObject deliveryAppResponseObject = new DeliveryAppResponseObject();
		deliveryAppResponseObject.setDeliveryAppList(deliveryAppList);
		ResponseEntity<DeliveryAppResponseObject> response = new ResponseEntity<DeliveryAppResponseObject>(
				deliveryAppResponseObject, HttpStatus.OK);
		return response;
	}
	/**
	 * Gets the DeliveryApp based on the id passed.
	 *
	 * @return the all Delivery Apps
	 */
	@GetMapping("/v0.1/app-detail/{id}")
	ResponseEntity<DeliveryAppResponseObject> getDeliveryAppDetail(@PathVariable Integer id) {
		Optional<DeliveryApp> deliveryApp = deliveryAppService.getDeliveryAppDetail(id);
		DeliveryAppResponseObject deliveryAppResponseObject = new DeliveryAppResponseObject();
		if(deliveryApp.isEmpty()) {
			deliveryAppResponseObject.setMessage("Record not available");
			ResponseEntity<DeliveryAppResponseObject> response = new ResponseEntity<DeliveryAppResponseObject>(
					deliveryAppResponseObject, HttpStatus.OK);
			return response;
		}
		deliveryAppResponseObject.setDeliveryApp(deliveryApp.get());
		ResponseEntity<DeliveryAppResponseObject> response = new ResponseEntity<DeliveryAppResponseObject>(
				deliveryAppResponseObject, HttpStatus.OK);
		return response;
	}
}
