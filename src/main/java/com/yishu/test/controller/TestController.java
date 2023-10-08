package com.yishu.test.controller;

import com.yishu.test.controller.controllerapi.TestApi;
import com.yishu.test.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController implements TestApi {

    @Autowired
    private TestService testService;

    @Override
    public Long queryById(Long id) {
        Long data = testService.queryById(id);
        return data;
    }

    @Override
    public String useMoney(Long id) {
        String data = testService.useMoney(id);
        return data;
    }

    @Override
    public String refundMoney(Long id) {
        String data = testService.refundMoney(id);
        return data;
    }

    @Override
    public String[] queryMoneyStatement(Long id) {
        String[] data = testService.queryMoneyStatement(id);
        return data;
    }
}
