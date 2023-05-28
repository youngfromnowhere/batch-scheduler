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
        batchService.createBatch(requestDto);
    }
    
    @GetMapping("/{id}")
    public BatchResponseDto getBatch(
        @PathVariable Long id
    ) {
        return batchService.getBatch(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBatch(
        @PathVariable Long id
    ) {
        batchService.deleteBatch(id);
    }

    @PatchMapping("/{id}/content")
    public void updateBatchContent(
        @RequestBody BatchRequestDto.ContentUpdate requestDto,
        @PathVariable Long id
    ) {
        batchService.updateBatchContent(requestDto.getContent(), id);
    }

    @PatchMapping("/{id}/schedule")
    public void updateBatchSchedule(
        @RequestBody BatchRequestDto.ScheduleUpdate requestDto,
        @PathVariable Long id
    ) {
        batchService.updateBatchSchedule(requestDto.getScheduledAt(), id);
    }

    @PatchMapping("/{id}/repeat-mode")
    public void updateBatchRepeat(
        @RequestBody BatchRequestDto.RepeatUpdate requestDto,
        @PathVariable Long id
    ) {
        batchService.updateBatchRepeat(requestDto.getRepeatMode(), id);
    }

    @PatchMapping("/{id}/pause")
    public void pauseBatch(@PathVariable Long id) {
        batchService.pauseBatch(id);
    }

    @PatchMapping("/{id}/resume")
    public void resumeBatch(@PathVariable Long id) {
        batchService.resumeBatch(id);
    }

    @PatchMapping("/{id}/deactivate")
    public void deactivateBatch(@PathVariable Long id) {
        batchService.deactivateBatch(id);
    }

    @PatchMapping("/{id}/activate")
    public void activateBatch(@PathVariable Long id) {
        batchService.activateBatch(id);
    }
}
