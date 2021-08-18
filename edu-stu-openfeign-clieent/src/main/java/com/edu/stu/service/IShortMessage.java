package com.edu.stu.service;

import edu.stu.common.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "SHORT-MESSAGE-SERVER")
public interface IShortMessage {
    @GetMapping("/getMessage")
   public CommonResult getMessage(@RequestParam("type") String type,@RequestParam("iphone") String iphone);


}
