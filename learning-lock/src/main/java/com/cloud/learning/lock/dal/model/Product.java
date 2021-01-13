package com.cloud.learning.lock.dal.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "product")
public class Product implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column(name = "version")
    private Integer version;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "name")
    private String name;

    /**
     * 库存
     */
    @Column(name = "number")
    private Integer number;

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
     * @return product_id
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * @param productId
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取库存
     *
     * @return number - 库存
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 设置库存
     *
     * @param number 库存
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", version=").append(version);
        sb.append(", productId=").append(productId);
        sb.append(", name=").append(name);
        sb.append(", number=").append(number);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}