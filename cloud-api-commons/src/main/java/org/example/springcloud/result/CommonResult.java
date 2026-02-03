package org.example.springcloud.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @Author fsy
 * @Date 2023/3/3 12:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    /** 响应码 */
    private Integer code;

    /** 响应信息 */
    private String message;

    /** 响应数据 */
    private T date;

    public CommonResult(Integer code, String message) {

        this(code, message, null);
    }
}
