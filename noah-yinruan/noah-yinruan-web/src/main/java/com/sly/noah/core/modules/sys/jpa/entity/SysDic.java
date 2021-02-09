package com.sly.noah.core.modules.sys.jpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: wj
 * @Date: 2021/2/8 15:24:04
 * @Description: TODO
 */
@Data
@Entity
@Table(name = "sys_dic")
public class SysDic implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "pid")
    private Integer pid;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "rank")
    private Integer rank;

    @Column(name = "description")
    private String description;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "last_update_time")
    private Date lastUpdateTime;

}
