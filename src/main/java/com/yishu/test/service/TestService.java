package com.yishu.test.service;

public interface TestService {

//    1.查询用户钱包余额
Long queryById(Long id);
//    2. 用户消费100元的接口
String useMoney(Long id);
//    3. 用户退款20元接口
String refundMoney(Long id);
//    4. 查询用户钱包金额变动明细的接口
String[] queryMoneyStatement(Long id);

}
