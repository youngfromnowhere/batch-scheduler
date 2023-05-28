package com.cmjc.batchscheduler.batch.contrller;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import com.cmjc.batchscheduler.batch.service.BatchService;
import com.cmjc.batchscheduler.batch.dto.BatchRequestDto;
import com.cmjc.batchscheduler.batch.dto.BatchResponseDto;

import java.time.LocalDateTime;
import java.util.List;

//lombok
@RequiredArgsConstructor

//springframework web bind
@RestController
@RequestMapping("/api/batch")
public class BatchController {
    private final BatchService batchService;

    /**
     * 새로운 Batch를 생성하는 메서드
     * [POST] /api/batch
     *
     * @param requestDto 요청 DTO(내용, 예정일, 반복모드)
     */
    @PostMapping("")
    public void createBatch(
        @RequestBody BatchRequestDto requestDto
    ) {
        batchService.createBatch(requestDto);
    }
    
    /**
     * 대상 Batch를 조회하는 메서드
     * [GET] /api/batch/{id}
     *
     * @param id 대상 Batch ID
     */
    @GetMapping("/{id}")
    public BatchResponseDto getBatch(
        @PathVariable Long id
    ) {
        return batchService.getBatch(id);
    }

    /**
     * 모든 Batch를 조회하는 메서드
     * [GET] /api/batch/list
     *
     * @param id 대상 Batch ID
     */
    @GetMapping("list")
    public List<BatchResponseDto> getBatchList() {
        return batchService.getBatchList();
    }

    /**
     * 대상 Batch를 삭제하는 메서드
     * [DELETE] /api/batch/{id}
     *
     * @param id 대상 Batch ID
     */
    @DeleteMapping("/{id}")
    public void deleteBatch(
        @PathVariable Long id
    ) {
        batchService.deleteBatch(id);
    }

    /**
     * 대상 Batch의 내용을 수정하는 메서드
     * [PATCH] /api/batch/{id}/content
     *
     * @param requestDto 요청 DTO(내용)
     * @param id 대상 Batch ID
     */
    @PatchMapping("/{id}/content")
    public void updateBatchContent(
        @RequestBody BatchRequestDto.ContentUpdate requestDto,
        @PathVariable Long id
    ) {
        batchService.updateBatchContent(requestDto.getContent(), id);
    }

    /**
     * 대상 Batch의 예정일을 수정하는 메서드
     * [PATCH] /api/batch/{id}/schedule
     *
     * @param requestDto 요청 DTO(예정일)
     * @param id 대상 Batch ID
     */
    @PatchMapping("/{id}/schedule")
    public void updateBatchSchedule(
        @RequestBody BatchRequestDto.ScheduleUpdate requestDto,
        @PathVariable Long id
    ) {
        batchService.updateBatchSchedule(requestDto.getScheduledAt(), id);
    }

    /**
     * 대상 Batch의 반복모드를 수정하는 메서드
     * [PATCH] /api/batch/{id}/repeat-mode
     *
     * @param requestDto 요청 DTO(반복모드)
     * @param id 대상 Batch ID
     */
    @PatchMapping("/{id}/repeat-mode")
    public void updateBatchRepeat(
        @RequestBody BatchRequestDto.RepeatUpdate requestDto,
        @PathVariable Long id
    ) {
        batchService.updateBatchRepeat(requestDto.getRepeatMode(), id);
    }

    /**
     * 대상 Batch를 일시정지하는 메서드
     * [PATCH] /api/batch/{id}/pause
     *
     * @param id 대상 Batch ID
     */
    @PatchMapping("/{id}/pause")
    public void pauseBatch(@PathVariable Long id) {
        batchService.pauseBatch(id);
    }

    /**
     * 대상 Batch를 재개하는 메서드
     * [PATCH] /api/batch/{id}/resume
     *
     * @param id 대상 Batch ID
     */
    @PatchMapping("/{id}/resume")
    public void resumeBatch(@PathVariable Long id) {
        batchService.resumeBatch(id);
    }

    /**
     * 대상 Batch를 비활성화하는 메서드
     * [PATCH] /api/batch/{id}/deactivate
     *
     * @param id 대상 Batch ID
     */
    @PatchMapping("/{id}/deactivate")
    public void deactivateBatch(@PathVariable Long id) {
        batchService.deactivateBatch(id);
    }

    /**
     * 대상 Batch를 비활성화하는 메서드
     * [PATCH] /api/batch/{id}/activate
     *
     * @param id 대상 Batch ID
     */
    @PatchMapping("/{id}/activate")
    public void activateBatch(@PathVariable Long id) {
        batchService.activateBatch(id);
    }
}
