package com.nimoh.hotel.errors.board;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum BoardErrorResult {
    UNKNOWN_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "Unknown Exception"),
    BOARD_NOT_FOUND(HttpStatus.BAD_REQUEST,"Board not found "),
    REQUEST_VALUE_INVALID(HttpStatus.BAD_REQUEST, "Request value invalid"),
    NO_PERMISSION(HttpStatus.FORBIDDEN,"No Permission")
;
    private final HttpStatus httpStatus;
    private final String message;
}
