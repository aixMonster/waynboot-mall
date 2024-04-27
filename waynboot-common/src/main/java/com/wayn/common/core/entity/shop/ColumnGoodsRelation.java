package com.wayn.common.core.entity.shop;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

/**
 * 栏目商品关联表
 */
@Data
@TableName("shop_column_goods_relation")
@EqualsAndHashCode(callSuper = false)
public class ColumnGoodsRelation implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 栏目ID
     */
    private Long columnId;

    /**
     * 商品ID
     */
    private Long goodsId;


}
