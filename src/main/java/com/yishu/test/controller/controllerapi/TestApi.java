package com.yishu.test.controller.controllerapi;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface TestApi {

    //    1.查询用户钱包余额
//    Long queryById(Long id);
    //    2. 用户消费100元的接口
//    String useMoney(Long id);
    //    3. 用户退款20元接口
//    String refundMoney(Long id);
    //    4. 查询用户钱包金额变动明细的接口
//    void queryMoneyStatement(Long id);

    /**
     * 1.查询用户钱包余额
     * @param id 用户编号
     * @return
     */
    @PostMapping("/test/query-by-id")
    Long queryById(Long id);

    /**
     * 2. 用户消费100元的接口
     * @param id
     * @return
     */
    @PostMapping("/test/user/add")
    String useMoney(@RequestBody  Long id);

    /**
     * 3. 用户退款20元接口
     * @param id
     * @return
     */
    @PostMapping("/test/refund/money")
    String refundMoney(@RequestBody Long id);

    /**
     * 4. 查询用户钱包金额变动明细的接口
     * @param id
     * @return
     */
    @PostMapping("/test/query/money_statement")
    String[] queryMoneyStatement(@RequestBody Long id);


}
