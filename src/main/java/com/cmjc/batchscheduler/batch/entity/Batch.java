package com.cmjc.batchscheduler.batch.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

//lombok
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//jpa
@Entity
@Table(name = "batch")
public class Batch {
    /**
     * Columns
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @Setter
    private String content;

    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime modifiedAt;

    @Column(nullable = false)
    @Setter
    private LocalDateTime scheduledAt;

    @Column
    @Setter
    private RepeatMode repeatMode;

    @Column(nullable = false)
    private boolean ongoing = true;

    @Column
    private LocalDateTime pausedAt;

    @Column(nullable = false)
    private boolean active = true;

    @Column
    private LocalDateTime deactivatedAt;

    /**
     * Constructor
     *
     * @param content 내용
     * @param scheduledAt 예정일
     * @param repeatMode 반복모드
     */
    @Builder
    public Batch(
        String content,
        LocalDateTime scheduledAt,
        RepeatMode repeatMode
    ) {
        this.content = content;
        this.scheduledAt = scheduledAt;
        this.repeatMode = repeatMode;
    }

    /**
     * 서비스 메소드
     */
    public void pauseBatch() {
        this.ongoing = false;
        this.pausedAt = LocalDateTime.now();
    }

    /**
     * 서비스 메소드
     */
    public void resumeBatch() {
        this.ongoing = true;
    }

    /**
     * 서비스 메소드
     */
    public void deactivateBatch() {
        this.active = false;
        this.deactivatedAt = LocalDateTime.now();
    }

    /**
     * 서비스 메소드
     */
    public void activateBatch() {
        this.active = true;
    }

}

