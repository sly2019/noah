package com.sly.noah.core.modules.rbac.jpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Created by wj on 2020/12/13
 * @Description TODO
 */
@Data
@Entity
@Table(name = "rbac_resource")
public class RbacResource implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "pid")
    private Integer pid;

    @Column(name = "name")
    private String name;

    @Column(name = "uri")
    private String uri;

    @Column(name = "type")
    private String type;

    @Column(name = "rank")
    private Integer rank;

    @Column(name = "description")
    private String description;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "last_update_time")
    private Date lastUpdateTime;

}
