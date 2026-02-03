package com.springcloud.controller.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.example.springcloud.result.CommonResult;

public class CustomerBlockHandler {
	public static CommonResult handlerException(BlockException exception) {
		return new CommonResult(444,"客户自定义全局处理-1");
	}

	public static CommonResult handlerException2(BlockException exception) {
		return new CommonResult(444,"客户自定义全局处理-2");
	}
}
