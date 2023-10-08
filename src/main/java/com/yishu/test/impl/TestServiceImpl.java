package com.yishu.test.impl;

import com.yishu.test.dao.TestDao;
import com.yishu.test.dao.po.TestPo;
import com.yishu.test.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    //    1.查询用户钱包余额
    @Override
    public Long queryById(Long id) {
        TestPo queryPo = new TestPo();
        queryPo.setId(id);
        TestPo data = testDao.selectOne(queryPo);
        if(data == null){
            //这里可以写个自定义异常，抛出未查找到用户的情况
        }
        return data.getMoney();

    }

    //   2. 用户消费100元的接口
    @Override
    public String useMoney(Long id) {
        TestPo queryPo = new TestPo();
        queryPo.setId(id);
        TestPo data = testDao.selectOne(queryPo);
        if(data == null){
            //这里可以写个自定义异常，抛出未查找到用户的情况
        }
        TestPo result = new TestPo();
        if(data.getMoney() >= 100){
            result.setMoney(data.getMoney()-100);
        }else{
            return "余额不足";
        }
        // 记录流水
        result.setMoneyStatement(data.getMoneyStatement() + "|-" + 100);
        result.setId(data.getId());

        //写入新数据
        testDao.updateByPrimaryKey(result);
        return "消费100元成功";
    }

    //    3. 用户退款20元接口
    @Override
    public String refundMoney(Long id) {
        TestPo queryPo = new TestPo();
        queryPo.setId(id);
        TestPo data = testDao.selectOne(queryPo);
        if(data == null){
            //这里可以写个自定义异常，抛出未查找到用户的情况
        }
        TestPo result = new TestPo();
        result.setMoney(data.getMoney()+20);
        // 记录流水
        result.setMoneyStatement(data.getMoneyStatement() + "|+" + 20);
        result.setId(data.getId());

        //写入新数据
        testDao.updateByPrimaryKey(result);
        return "退款20元成功";
    }

    //    4. 查询用户钱包金额变动明细的接口
    @Override
    public String[] queryMoneyStatement(Long id) {
        TestPo queryPo = new TestPo();
        queryPo.setId(id);
        TestPo data = testDao.selectOne(queryPo);
        if(data == null){
            //这里可以写个自定义异常，抛出未查找到用户的情况
        }
        String moneyStatement = data.getMoneyStatement();
        String [] result = moneyStatement.split("\\|");
        // 这里根据需求返回对应数据类型或对应数据类即可，我这里使用String数组
        return result;
    }

    public static void main(String[] args) {
        String str = "0|+100|-20";
        String [] result = str.split("\\|");
        for (String i:result) {
            System.out.println(i);
        }

    }
}
