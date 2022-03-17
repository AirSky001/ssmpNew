package com.itheima.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "tb_book")
public class Book {
    private int id;
    private String type;
    private String name;
    private String description;
}
