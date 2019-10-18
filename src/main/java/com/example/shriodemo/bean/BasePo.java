package com.example.shriodemo.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/*
 * @Author liuxin
 * @Description //TODO
 **/
@Data
@MappedSuperclass
public class BasePo implements Serializable {
    private static final long serialVersionUID = 0x20161228;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


   // @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyyMMdd")
    @Column(name = "created_date")
    private LocalDate createdDate;

   // @JSONField(format="yyyy-MM-dd HH:mm:ss")
   @JsonFormat(pattern = "yyyyMMddHHmmss")
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
}