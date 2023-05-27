package com.cmjc.batchscheduler.batch.dto;

import com.cmjc.batchscheduler.batch.entity.RepeatMode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
* Batch 생성 or 수정 Dto
*/
//lombok
@Getter
@NoArgsConstructor
public class BatchRequestDto {

    private String content;

    private LocalDateTime scheduledAt;

    private RepeatMode repeatMode;

    public static class ContentUpdate {
        private String content;
    }

    public static class ScheduleUpdate {
        private LocalDateTime scheduledAt;
    }

    public static class RepeatUpdate {
        private RepeatMode repeatMode;
    }

}
