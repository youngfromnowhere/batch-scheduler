package com.cmjc.batchscheduler.common.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    // 일반 오류 (100)
    INVALID_CODE(HttpStatus.BAD_REQUEST, 101, "Invalid Code"),
    RESOURCE_NOT_FOUND(HttpStatus.NO_CONTENT, 102, "Resource not found"),
    EXPIRED_CODE(HttpStatus.BAD_REQUEST, 103, "Expired Code"),

    // Batch 오류 (1000)
    BAD_REQUEST_BATCH_CONTENT(HttpStatus.BAD_REQUEST, 1001, "Batch content에 공백을 입력할 수 없습니다."),
    BATCH_NOT_FOUND(HttpStatus.NOT_FOUND, 1004, "Batch를 찾을 수 없습니다.");

    private HttpStatus status;
    private int code;
    private String message;

    ErrorCode(HttpStatus status, int code, String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

}
