package com.backendbigdata.controller;

import com.backendbigdata.dto.RestResponseDto;
import com.backendbigdata.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController extends BaseController{

    @Autowired
    CategoryService categoryService;

    @Autowired
    COOService cooService;

    @Autowired
    VendorService vendorService;

    @Autowired
    PartService partService;

    @Autowired
    ChatService chatService;

    @GetMapping("/categories")
    public ResponseEntity<RestResponseDto> getAllCategories(){
     return response(categoryService.getAllCategories());
    }

    @GetMapping("/coo")
    public ResponseEntity<RestResponseDto> getAllCOO(){
        return response(cooService.getAllCOO());
    }

    @GetMapping("/vendorWithMostProducts/{categoryId}")
    public ResponseEntity<RestResponseDto> getVendorProducingMostProducts(@PathVariable("categoryId") Integer categoryId){
        return response(vendorService.getVendorWithMostProducts(categoryId));
    }

    @GetMapping("/priceStats/{categoryId}")
    public ResponseEntity<RestResponseDto> getPriceStats(@PathVariable("categoryId") Integer categoryId){
        return response(categoryService.getPriceStats(categoryId));
    }

    @GetMapping("/avgWeight/{cacit}")
    public ResponseEntity<RestResponseDto> getAvgWeight(@PathVariable("cacit") String cacit){
        return response(partService.getPartAvgWeight(cacit));
    }

    @GetMapping("/pricePerGram/{cacit}")
    public ResponseEntity<RestResponseDto> getPricePerGram(@PathVariable("cacit") String cacit){
        return response(partService.getPricePerGram(cacit));
    }

    @GetMapping("/highPricedProductVendor/{cacit}")
    public ResponseEntity<RestResponseDto> getHighPricedProductVendor(@PathVariable("cacit") String cacit){
        return response(vendorService.getHighPricedProductVendor(cacit));
    }

    @GetMapping("/productsByCountry/{countryId}")
    public ResponseEntity<RestResponseDto> getProductsByCountry(@PathVariable("countryId") String countryId){
        return response(partService.getProductsByCountry(countryId));
    }

    @GetMapping("/categoryWithMostProducts")
    public ResponseEntity<RestResponseDto> getCategoryWithMostProducts(){
        return response(categoryService.getCategoryWithMostProducts());
    }

    @GetMapping("/vendorsByProductCategory/{categoryId}")
    public ResponseEntity<RestResponseDto> getVendorsByProductCategory(@PathVariable("categoryId") Integer categoryId){
        return response(vendorService.getVendorsByProductCategory(categoryId));
    }

    @GetMapping("/vendors")
    public ResponseEntity<RestResponseDto> getAllVendors(){
        return response(vendorService.getAllVendors());
    }

    @GetMapping("/countryWiseProductsCount")
    public ResponseEntity<RestResponseDto> getCountryWiseProductsCount(){
        return response(partService.getCountryWiseProductsCount());
    }

    @GetMapping("partsByCategory/{categoryId}")
    public ResponseEntity<RestResponseDto> getPartsByCategory(@PathVariable("categoryId") Integer categoryId){
        return response(partService.getPartsByCategory(categoryId));
    }

    @GetMapping("partsByCategoryAndCoo/{categoryId}/{cooId}")
    public ResponseEntity<RestResponseDto> getPartsByCategoryAndCoo(@PathVariable("categoryId") Integer categoryId, @PathVariable("cooId") String cooId){
        return response(partService.getPartsByCategoryAndCoo(categoryId,cooId));
    }

    @GetMapping("mostActiveUser")
    public ResponseEntity<RestResponseDto> getMostActiveUser(){
        return response(chatService.getMostActiveUser());
    }

    @GetMapping("leastActiveUser")
    public ResponseEntity<RestResponseDto> getLeastActiveUser(){
        return response(chatService.getLeastActiveUser());
    }

    @GetMapping("mostActiveInitiator")
    public ResponseEntity<RestResponseDto> getMostActiveInitiator(){
        return response(chatService.getMostActiveInitiator());
    }

    @GetMapping("mostActiveChatter")
    public ResponseEntity<RestResponseDto> getMostActiveChatter(){
        return response(chatService.getMostActiveChatter());
    }

    @GetMapping("mostActiveOppChatter")
    public ResponseEntity<RestResponseDto> getMostActiveOppChatter(){
        return response(chatService.getMostActiveOppChatter());
    }

    @GetMapping("mostActiveCaseChatter")
    public ResponseEntity<RestResponseDto> getMostActiveCaseChatter(){
        return response(chatService.getMostActiveCaseChatter());
    }
}
