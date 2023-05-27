package com.cmjc.batchscheduler.batch.dto;

import com.cmjc.batchscheduler.batch.entity.RepeatMode;
import com.cmjc.batchscheduler.batch.entity.Batch;
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
    private final boolean ongoing;
    private final LocalDateTime pausedAt;
    private final boolean active;
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
        this.ongoing = batch.isOngoing();
        this.pausedAt = batch.getPausedAt();
        this.active = batch.isActive();
        this.deactivatedAt = batch.getDeactivatedAt();
    }

    public static BatchResponseDto of(Batch batch) {
        return new BatchResponseDto(batch);
    }
}
