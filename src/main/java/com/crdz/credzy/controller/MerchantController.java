package com.crdz.credzy.controller;

import com.crdz.credzy.dtos.MerchantOutputDto;
import com.crdz.credzy.dtos.OfferDto;
import com.crdz.credzy.model.Merchants;
import com.crdz.credzy.model.Offer;
import com.crdz.credzy.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "merchant")
public class MerchantController {

    @Autowired
    MerchantService merchantService;



    @GetMapping
    @RequestMapping(path = "/id")
    public MerchantOutputDto getMerchant(@RequestParam Long merchantId) {
        Merchants merchants = merchantService.getMerchantByID(merchantId);
        List<Offer> offers = merchantService.getofferbyMerchantId(merchantId);
        List<OfferDto> offerDtos = createOfferDto(offers);
        return createMerchantDto(merchants, offerDtos);
    }

    private List<OfferDto> createOfferDto(List<Offer> offers) {
        List<OfferDto> offerDtos = new ArrayList<>();
        for(Offer offer : offers) {
            OfferDto offerDto = new OfferDto();
            offerDto.setOfferImg(offer.getOfferImg());
            offerDto.setOfferName(offer.getOfferName());
            List<String> termsAndConditions = Arrays.asList(offer.getTermsAndConditions().split(","));
            offerDto.setTermsAndConditions(termsAndConditions);
            offerDtos.add(offerDto);
        }
        return offerDtos;
    }

    private MerchantOutputDto createMerchantDto(Merchants merchants, List<OfferDto> offer) {
        MerchantOutputDto merchant = new MerchantOutputDto();
        merchant.setAddress(merchants.getAddress());
        merchant.setFacebook(merchants.getFacebook());
        merchant.setGmap(merchants.getGmap());
        merchant.setLogo(merchants.getLogo());
        merchant.setFirmName(merchants.getFirmName());
        merchant.setInstagram(merchants.getInstagram());
        merchant.setWhatsapp(merchants.getWhatsapp());
        merchant.setMobile(merchants.getMobile());
        merchant.setOfferList(offer);
        return merchant;
    }

    @GetMapping
    @RequestMapping(path = "/all")
    public List<Merchants> getAllMerchants() {
        return merchantService.getAllMerchants();
    }


}