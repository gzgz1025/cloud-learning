package com.cloud.learning.lock.dal.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "account")
public class Account implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column(name = "version")
    private Integer version;

    @Column(name = "biz_id")
    private Long bizId;

    /**
     * 存款
     */
    @Column(name = "deposit")
    private BigDecimal deposit;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return version
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * @param version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * @return biz_id
     */
    public Long getBizId() {
        return bizId;
    }

    /**
     * @param bizId
     */
    public void setBizId(Long bizId) {
        this.bizId = bizId;
    }

    /**
     * 获取存款
     *
     * @return deposit - 存款
     */
    public BigDecimal getDeposit() {
        return deposit;
    }

    /**
     * 设置存款
     *
     * @param deposit 存款
     */
    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", version=").append(version);
        sb.append(", bizId=").append(bizId);
        sb.append(", deposit=").append(deposit);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}