package edu.message.controller;

import edu.message.service.IShortMessage;
import edu.stu.common.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortMessageController {
    @Autowired
    private IShortMessage iShortMessage;

    @RequestMapping("/getMessage")
    public CommonResult getMessage(String type,String iphone){
        CommonResult message = iShortMessage.getMessage(type, iphone);
        return message;
    }
}
