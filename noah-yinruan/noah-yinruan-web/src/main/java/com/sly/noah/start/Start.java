package com.sly.noah.start;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Created by wj on 2021/2/21
 * @Description: TODO
 */
@Component
@Order(value = 1)
public class Start implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 加载字典缓存
        {

        }
    }


}
