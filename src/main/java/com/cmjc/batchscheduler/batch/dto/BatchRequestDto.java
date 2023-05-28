package com.cmjc.batchscheduler.batch.dto;

import com.cmjc.batchscheduler.batch.entity.RepeatMode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Batch 생성 or 수정 Dto
 */
//lombok
@Getter
@NoArgsConstructor
public class BatchRequestDto {

    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime scheduledAt;

    private RepeatMode repeatMode;

    @Getter
    @NoArgsConstructor
    public static class ContentUpdate {
        private String content;
    }

    @Getter
    @NoArgsConstructor
    public static class ScheduleUpdate {
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime scheduledAt;
    }

    @Getter
    @NoArgsConstructor
    public static class RepeatUpdate {
        private RepeatMode repeatMode;
    }

}
