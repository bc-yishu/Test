package com.yishu.test.dao.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "yishu_user")
public class TestPo {

    @Column(name = "test_id")
    private Long id;

    @Column(name = "money")
    private Long money;

    @Column(name = "money_statement")
    private String moneyStatement;


}
