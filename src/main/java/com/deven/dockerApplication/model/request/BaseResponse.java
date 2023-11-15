package com.deven.dockerApplication.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse {
    private String status;
    private String message;
    Object errorData;
}
