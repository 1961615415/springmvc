package com.duchunxia.domain;

import java.io.Serializable;

public class Gongnv implements Serializable {
    /**
     * @mbggenerated
     */
    private Integer id;

    /**
     * @mbggenerated
     */
    private String sname;

    /**
     * @mbggenerated
     */
    private Integer age;

    /**
     * @mbggenerated
     */
    private String createtime;

    /**
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @mbggenerated
     */
    public String getSname() {
        return sname;
    }

    /**
     * @mbggenerated
     */
    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    /**
     * @mbggenerated
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @mbggenerated
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @mbggenerated
     */
    public String getCreatetime() {
        return createtime;
    }

    /**
     * @mbggenerated
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }
}