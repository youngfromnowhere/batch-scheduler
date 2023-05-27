package com.cmjc.batchscheduler.batch.contrller;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import com.cmjc.batchscheduler.batch.service.BatchService;
import com.cmjc.batchscheduler.batch.dto.BatchRequestDto;
import com.cmjc.batchscheduler.batch.dto.BatchResponseDto;

import java.time.LocalDateTime;

//lombok
@RequiredArgsConstructor

//springframework web bind
@RestController
@RequestMapping("/api/batch")
public class BatchController {
    private final BatchService batchService;

    @PostMapping("")
    public void createBatch(
        @RequestBody BatchRequestDto requestDto
    ) {
    }
    
    @GetMapping("/{id}")
    public void getBatch() {
    }

    @DeleteMapping("/{id}")
    public void deleteBatch() {
    }

    @PatchMapping("/{id}/content")
    public void updateBatchContent() {
    }

    @PatchMapping("/{id}/schedule")
    public void updateBatchSchedule() {
    }

    @PatchMapping("/{id}/repeat-mode")
    public void updateBatchRepeat() {
    }

    @PatchMapping("/{id}/pause")
    public void pauseBatch() {
    }

    @PatchMapping("/{id}/resume")
    public void resumeBatch() {
    }

    @PatchMapping("/{id}/deactivate")
    public void deactivateBatch() {
    }

    @PatchMapping("/{id}/activate")
    public void activateBatch() {
    }
}
