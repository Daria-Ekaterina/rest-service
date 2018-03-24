package com.morgen.utils;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Response {

    private ResponseStatus status;
    private List<ResponseError> errors = new ArrayList<>();
    private Object result;

    public Response() {
        this.status = ResponseStatus.SUCCESS;
    }

    public Response(ResponseError error) {
        this.status = ResponseStatus.ERROR;
        errors.add(error);
    }

    public Response(Object result) {
        this.status = ResponseStatus.SUCCESS;
        this.result = result;
    }
}
