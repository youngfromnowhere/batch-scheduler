package com.cmjc.batchscheduler.batch.dto;

import com.cmjc.batchscheduler.batch.entity.RepeatMode;
import com.cmjc.batchScheduler.batch.entity.Batch;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

/**
* Batch 응답 Dto
*/

//lombok
@Getter
@RequiredArgsConstructor
public class BatchResponseDto {
    private final Long id;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    private final LocalDateTime scheduledAt;
    private final RepeatMode repeatMode;
    private final boolean isOngoing;
    private final LocalDateTime pausedAt;
    private final boolean isActive = true;
    private final LocalDateTime deactivatedAt;

    /**
    * 생성자
    */
    private BatchResponseDto(Batch batch) {
        this.id = batch.getId();
        this.content = batch.getContent();
        this.createdAt = batch.getCreatedAt();
        this.modifiedAt = batch.getModifiedAt();
        this.scheduledAt = batch.getScheduledAt();
        this.repeatMode = batch.getRepeatMode();
        this.isOngoing = batch.getIsOngoing();
        this.pausedAt = batch.getPausedAt();
        this.isActive = batch.getIsActive();
        this.deactivatedAt = batch.getDeactivatedAt();
    }

    public static BatchResponseDto of(Batch batch) {
        return new BatchResponseDto(batch);
    }
}
