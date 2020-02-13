package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.TreeEntity;

/**
 * 设备分类对象 equ_class
 * 
 * @author ruoyi
 * @date 2020-02-11
 */
public class EquClass extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** ID 主键 */
    private Long classId;

    /** Guid */
    @Excel(name = "Guid")
    private String classGuid;

    /** 设备分类名称 */
    @Excel(name = "设备分类名称")
    private String className;

    /** 状态 （0正常 1停用） */
    @Excel(name = "状态 ", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除状态 （0代表存在 2代表删除） */
    private String delFlag;

    /** 父分类名称 */
    private String parentName;
    
    public void setClassId(Long classId) 
    {
        this.classId = classId;
    }

    public Long getClassId() 
    {
        return classId;
    }
    public void setClassGuid(String classGuid) 
    {
        this.classGuid = classGuid;
    }

    public String getClassGuid() 
    {
        return classGuid;
    }
    public void setClassName(String className) 
    {
        this.className = className;
    }

    public String getClassName() 
    {
        return className;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    public String getParentName()
    {
        return parentName;
    }

    public void setParentName(String parentName)
    {
        this.parentName = parentName;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("classId", getClassId())
            .append("classGuid", getClassGuid())
            .append("parentId", getParentId())
            .append("ancestors", getAncestors())
            .append("className", getClassName())
            .append("orderNum", getOrderNum())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
