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
    private boolean ongoing = true;

    @Column
    private LocalDateTime pausedAt;

    @Column(nullable = false)
    private boolean active = true;

    @Column
    private LocalDateTime deactivatedAt;

    /**
    * Constructor
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

}

