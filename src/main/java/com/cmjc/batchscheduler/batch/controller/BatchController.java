package com.cmjc.batchscheduler.batch.contrller;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

//lombok
@RequiredArgsConstructor

//springframework web bind
@RestContrlloer
@RequestMapping("/api/batch")
public class BatchController {
    private final BatchServiceImpl batchService;

    @PostMapping("")
    public void createBatch(
        @RequestBody BatchRequestDto requestDto
    ) {
        batchService.createBatch(
            requestDto.getContent(),
            requestDto.getScheduledAt(),
            requestDto.getRepeatMode()
        )
    }
    
    @GetMapping("/{id}")
    public BatchResponsdDto getBatch() {
    }

}
