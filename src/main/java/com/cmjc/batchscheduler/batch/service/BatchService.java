package com.cmjc.batchscheduler.batch.service;

import com.cmjc.batchscheduler.batch.dto.BatchRequestDto;
import com.cmjc.batchscheduler.batch.dto.BatchResponseDto;
import com.cmjc.batchscheduler.batch.entity.RepeatMode;

import java.time.LocalDateTime;

public interface BatchService {

    /**
     * Batch 생성 method
     *
     * @param requestDto 생성할 Batch 정보가 담긴 DTO
     */
    void createBatch(BatchRequestDto requestDto);

    /**
     * 대상 Batch를 조회
     * @param batchId 조회할 Batch의 id
     */
    BatchResponseDto getBatch(Long batchId);

    /**
     * 대상 Batch를 삭제
     * @param batchId 삭제할 Batch의 id
     */
    void deleteBatch(Long batchId);

    /**
     * 대상 Batch의 Content 수정
     *
     * @param content 수정할 내용
     * @param batchId 수정할 Batch의 id
     */
    void updateBatchContent(String content, Long batchId);

    /**
     * 대상 Batch의 Schedule 수정
     *
     * @param content 수정할 내용
     * @param batchId 수정할 Batch의 id
     */
    void updateBatchSchedule(LocalDateTime scheduledAt, Long batchId);

    /**
     * 대상 Batch의 RepeatMode 수정
     *
     * @param content 수정할 내용
     * @param batchId 수정할 Batch의 id
     */
    void updateBatchRepeat(RepeatMode repeatMode, Long batchId);

    /**
     * 대상 Batch 일시정지
     *
     * @param batchId 일시정지할 Batch의 id
     */
    void pauseBatch(Long batchId);
    
    /**
     * 대상 Batch 재개
     *
     * @param batchId 재개할 Batch의 id
     */
    void resumeBatch(Long batchId);

    /**
     * 대상 Batch 비활성화
     *
     * @param batchId 비활성화할 Batch의 id
     */
    void deactivateBatch(Long batchId);

    /**
     * 대상 Batch 활성화
     *
     * @param batchId 활성화 할 Batch의 id
     */
    void activateBatch(Long batchId);


}
