package com.services.example.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.services.example.rest.model.DeliveryApp;

public interface DeliveryAppRepository extends JpaRepository<DeliveryApp, Integer> {

}
