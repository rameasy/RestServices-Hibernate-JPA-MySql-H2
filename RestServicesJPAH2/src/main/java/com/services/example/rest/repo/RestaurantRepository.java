package com.services.example.rest.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.services.example.rest.model.Restaurant;

/**
 * The Class RestaurantRepositoryImpl.
 * 
 * @author rameasy@gmail.com
 */
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
	@Query(value = "select restaurant.name, city.name, deliveryApp.name, country.name from Restaurant restaurant, City city, Country country, "
			+ "DeliveryApp deliveryApp  where restaurant.cityId = city.id and city.countryId =country.id  "
			+ "and restaurant.deliveryAppId = deliveryApp.id and restaurant.id = ?1")
	Optional<Object> findRestaurantDetail(Integer id);

	@Query(value = "select restaurant.name, city.name, deliveryApp.name, country.name from Restaurant restaurant, City city, Country country, "
			+ "DeliveryApp deliveryApp  where restaurant.cityId = city.id and city.countryId =country.id  "
			+ "and restaurant.deliveryAppId = deliveryApp.id and restaurant.id between ?1 and ?2")
	List<Optional<Object>> findSubsetRestaurantDetail(Integer fromId, Integer toId);
}
