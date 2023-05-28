package com.cmjc.batchscheduler.batch.service;

import com.cmjc.batchscheduler.batch.repository.BatchRepository;
import com.cmjc.batchscheduler.batch.entity.Batch;
import com.cmjc.batchscheduler.batch.entity.RepeatMode;
import com.cmjc.batchscheduler.batch.dto.BatchRequestDto;
import com.cmjc.batchscheduler.batch.dto.BatchResponseDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.time.LocalDateTime;

//lombok
@RequiredArgsConstructor

//springframework stereotype
@Service

//springframework transaction
@Transactional
public class BatchServiceImpl implements BatchService {

    private final BatchRepository batchRepository;

    @Override
    public void createBatch(BatchRequestDto requestDto) {
        Batch newBatch = Batch.builder()
                .content(requestDto.getContent())
                .scheduledAt(requestDto.getScheduledAt())
                .repeatMode(requestDto.getRepeatMode())
                .build();
        batchRepository.save(newBatch);
    }

    @Override
    public BatchResponseDto getBatch(Long batchId) {
        Batch foundBatch = validateBatch(batchId);
        return BatchResponseDto.of(foundBatch);
    }

    @Override
    public List<BatchResponseDto> getBatchList() {
        List<Batch> batchList = batchRepository.findAll();
        return BatchResponseDto.toDtoList(batchList);
    }

    @Override
    public void deleteBatch(Long batchId) {
        Batch foundBatch = validateBatch(batchId);
        batchRepository.delete(foundBatch);
    }
    

    @Override
    public void updateBatchContent(String content, Long batchId) {
        Batch foundBatch = validateBatch(batchId);
        foundBatch.setContent(content);
    }


    @Override
    public void updateBatchSchedule(LocalDateTime scheduledAt, Long batchId) {
        Batch foundBatch = validateBatch(batchId);
        foundBatch.setScheduledAt(scheduledAt);
    }


    @Override
    public void updateBatchRepeat(RepeatMode repeatMode, Long batchId) {
        Batch foundBatch = validateBatch(batchId);
        foundBatch.setRepeatMode(repeatMode);
    }


    @Override
    public void pauseBatch(Long batchId) {
        Batch foundBatch = validateBatch(batchId);
        foundBatch.pauseBatch();
    }

    @Override
    public void resumeBatch(Long batchId) {
        Batch foundBatch = validateBatch(batchId);
        foundBatch.resumeBatch();
    }

    @Override
    public void deactivateBatch(Long batchId) {
        Batch foundBatch = validateBatch(batchId);
        foundBatch.deactivateBatch();
    }


    @Override
    public void activateBatch(Long batchId) {
        Batch foundBatch = validateBatch(batchId);
        foundBatch.activateBatch();
    }

    //해당 id의 Batch를 조회하는 내부 method
    public Batch validateBatch(Long batchId) {
        return batchRepository.findById(batchId).orElseThrow(
            () -> new IllegalStateException("Batch를 찾을 수 없습니다.")
        );
    }

}
