package edu.message.service.impl;

import edu.message.service.IShortMessage;
import edu.stu.common.CommonResult;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ShortMessage implements IShortMessage {
    @Override
    public CommonResult getMessage(String type, String iphone) {
        String code = String.valueOf((int)((Math.random()*9+1)*Math.pow(10,5)));
        String message = "sss"+code+"sss";
      switch (type){
          case "0":
              message = "0ss"+code+"ss0";
              break;
          case "1":
              message = "1ss"+code+"ss1";
              break;
      }
        Map<String,Object> map = new HashMap<>();
        map.put("code",code);
        map.put("message",message);
        map.put("iphone",iphone);
        return CommonResult.success(map);
    }
}
