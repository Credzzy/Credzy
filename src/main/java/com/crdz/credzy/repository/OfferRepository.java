package com.crdz.credzy.repository;

import com.crdz.credzy.model.Offer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
    List<Offer> findAllByMerchantId(Long merchantId);
}
