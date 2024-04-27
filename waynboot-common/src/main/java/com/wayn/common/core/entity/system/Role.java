package com.wayn.common.core.entity.system;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wayn.common.base.entity.BaseEntity;
import com.wayn.util.constant.SysConstants;
import com.wayn.util.converter.StatusConverter;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;

import java.io.Serial;
import java.util.List;

/**
 * 角色表 sys_role
 */
@Data
@TableName("sys_role")
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -1024364179363548873L;
    /**
     * 角色ID
     */
    @TableId(type = IdType.AUTO)
    @ExcelProperty(value = "角色编号")
    private Long roleId;

    /**
     * 角色名称
     */
    @NotBlank(message = "角色名称不能为空")
    @ExcelProperty(value = "角色名称")
    private String roleName;

    /**
     * 权限字符
     */
    @NotBlank(message = "权限字符不能为空")
    @ExcelProperty(value = "权限字符")
    private String roleKey;

    /**
     * 角色排序
     */
    @DecimalMin(value = "0", message = "角色排序不能小于0")
    @ExcelProperty(value = "角色排序")
    private Integer sort;

    /**
     * 角色状态（0正常 1停用）
     */
    @ExcelProperty(value = "角色状态", converter = StatusConverter.class)
    private Integer roleStatus;

    /**
     * 关联菜单id集合
     */
    @TableField(exist = false)
    private List<Long> menuIds;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private Boolean delFlag;

    public Role(Long roleId) {
        this.roleId = roleId;
    }

    public Role() {
    }


    public static boolean isAdmin(String roleKey) {
        return StringUtils.isNotBlank(roleKey) && SysConstants.SUPER_ADMIN.equals(roleKey);
    }

    public boolean isAdmin() {
        return isAdmin(this.roleKey);
    }

}
