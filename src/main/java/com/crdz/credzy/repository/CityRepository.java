package com.crdz.credzy.repository;

import com.crdz.credzy.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    @Query(value = "SELECT id FROM city WHERE city_name = ?1", nativeQuery = true)
    Long getReferenceByCityName(String city);
}