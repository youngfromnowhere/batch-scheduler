package com.cmjc.batchscheduler.batch.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

//lombok
@Getter
@Setter
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
    private String content;

    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime modifiedAt;

    @Column(nullable = false)
    private LocalDateTime scheduledAt;

    @Column
    private RepeatMode repeatMode;

    @Column(nullable = false)
    private boolean isOngoing;

    @Column
    private LocalDateTime pausedAt;

    @Column(nullable = false)
    private boolean isActive = true;

    @Column
    private LocalDateTime deactivatedAt;

    /**
    * Constructor
    */
    @Builder
    public Batch(String title, String content, RepeatMode repeatMode) {
        this.title = title;
        this.content = content;
        this.repeatMode = repeatMode;
    }

}

