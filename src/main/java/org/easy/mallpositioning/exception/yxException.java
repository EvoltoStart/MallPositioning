package org.easy.mallpositioning.exception;


import lombok.Data;
import org.easy.mallpositioning.result.ResultCodeEnum;

@Data
public class yxException extends RuntimeException{
    private Integer code;//异常状态码

    public yxException(Integer code, String message) {

        super(message);
        this.code = code;
    }
    public yxException(ResultCodeEnum resultCodeEnum) {

        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

}
