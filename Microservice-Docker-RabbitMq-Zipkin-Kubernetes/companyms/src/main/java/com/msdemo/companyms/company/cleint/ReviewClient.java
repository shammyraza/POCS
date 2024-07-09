package com.msdemo.companyms.company.cleint;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("REVIEW-SERVICE")
public interface ReviewClient {

    @GetMapping("reviews/avgRating")
    Double getAvgRatingForCompany(@RequestParam("companyId") Long companyId);
}
