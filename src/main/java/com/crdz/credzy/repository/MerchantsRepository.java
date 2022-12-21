package com.crdz.credzy.repository;

import com.crdz.credzy.model.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantsRepository extends JpaRepository<Merchants, Long> {
}
