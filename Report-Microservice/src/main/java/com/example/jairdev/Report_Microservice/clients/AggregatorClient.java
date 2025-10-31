package com.example.jairdev.Report_Microservice.clients;

import com.example.jairdev.Report_Microservice.dto.CombinedInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "aggregator-service")
public interface AggregatorClient {

    @GetMapping("/api/aggregate/{userId}/")
    CombinedInfoResponse getCombinedInfo(
        @PathVariable("userId") String userId

    );
}
