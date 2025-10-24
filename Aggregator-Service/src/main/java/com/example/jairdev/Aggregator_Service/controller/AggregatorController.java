package com.example.jairdev.Aggregator_Service.controller;


import com.example.jairdev.Aggregator_Service.dto.CombinedInfoResponse;
import com.example.jairdev.Aggregator_Service.service.AggregationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aggregate")
@RequiredArgsConstructor
public class AggregatorController {

    private final AggregationService aggregationService;

    @GetMapping("/{userId}/")
    public ResponseEntity<CombinedInfoResponse> getCombinedInfo(
            @PathVariable String userId) {
        return ResponseEntity.ok(aggregationService.combineData(userId));
    }
}
