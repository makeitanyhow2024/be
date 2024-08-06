//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.make_it_anyhow.restaurant.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

@Schema(
    name = "ResponseDto",
    description = "응답 정보"
)
public class ResponseDto<T> {
    @Schema(
        name = "status",
        title = "응답 상태(FAIL/SUCCESS)",
        requiredMode = RequiredMode.REQUIRED
    )
    String status;
    @Schema(
        name = "code",
        title = "응답 코드",
        requiredMode = RequiredMode.REQUIRED
    )
    String code;
    @Schema(
        name = "message",
        title = "응답 메세지",
        requiredMode = RequiredMode.REQUIRED
    )
    String message;
    @Schema(
        name = "result",
        title = "결과값",
        requiredMode = RequiredMode.NOT_REQUIRED
    )
    T result;

    public ResponseDto(String status, String code, String message, T result) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public static ResponseDto<Object> buildSuccessResponse() {
        return new ResponseDto(ResponseDto.ResponseStatus.SUCCESS.name(), "200", (String)null, (Object)null);
    }

    public static <T> ResponseDto<T> buildSuccessResponse(T result) {
        return new ResponseDto(ResponseDto.ResponseStatus.SUCCESS.name(), "200", (String)null, result);
    }

    public static ResponseDto<Object> buildFailResponse(String code) {
        return new ResponseDto(ResponseDto.ResponseStatus.FAIL.name(), code, (String)null, (Object)null);
    }

    public static <T> ResponseDto<T> buildFailResponse(String code, T result) {
        return new ResponseDto(ResponseDto.ResponseStatus.FAIL.name(), code, (String)null, result);
    }

    public String getStatus() {
        return this.status;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public T getResult() {
        return this.result;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setResult(final T result) {
        this.result = result;
    }

    static enum ResponseStatus {
        SUCCESS,
        FAIL;

        private ResponseStatus() {
        }
    }
}
