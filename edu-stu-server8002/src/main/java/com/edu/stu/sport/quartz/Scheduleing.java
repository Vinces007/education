package com.edu.stu.sport.quartz;

import com.edu.stu.sport.dao.CaheMap;
import com.edu.stu.sport.dao.MyRun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class Scheduleing {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Scheduled(cron = "0/3 * * * * *")
    public void startTask(){
       CaheMap caheMap = CaheMap.getInstance();
       Set<String> valueList = caheMap.getValueList();
        MyRun myRun = null;
        for (String name :valueList
             ) {
            myRun = new MyRun();
            myRun.setName(name);
            myRun.setJdbcTemplate(jdbcTemplate);
            myRun.setWhere(caheMap.getValueStr(name));
            new Thread(myRun,"线程"+name).start();

        }

    }
}
