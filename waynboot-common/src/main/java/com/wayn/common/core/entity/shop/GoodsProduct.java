package com.wayn.common.core.entity.shop;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.wayn.common.base.entity.ShopBaseEntity;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品货品表
 */
@Data
@TableName(value = "shop_goods_product", autoResultMap = true)
@EqualsAndHashCode(callSuper = false)
public class GoodsProduct extends ShopBaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1472445142327045417L;
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 商品表的商品ID
     */
    private Long goodsId;

    /**
     * 商品规格值列表，采用JSON数组格式
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    @Size(min = 1, message = "商品规格值列表不能小于1")
    private String[] specifications;

    /**
     * 商品货品价格
     */
    @DecimalMin(value = "0.0001", message = "货品售价不能小于0")
    private BigDecimal price;

    /**
     * 是否默认选中（0代表选中 1代表未选中）
     */
    private Boolean defaultSelected;

    /**
     * 商品货品数量
     */
    @Min(value = 0, message = "商品货品数量不能小于0")
    private Integer number;

    /**
     * 商品货品图片
     */
    private String url;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private Boolean delFlag;


}
