package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备供应商对象 equ_supplier
 * 
 * @author ruoyi
 * @date 2020-02-17
 */
public class EquSupplier extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID 主键 */
    private Long supId;

    /** Guid */
    private String supGuid;

    /** 统一社会信用代码 */
    @Excel(name = "统一社会信用代码")
    private String supCode;

    /** 企业名称 */
    @Excel(name = "企业名称")
    private String supName;

    /** 法定代表人 */
    @Excel(name = "法定代表人")
    private String supLeg;

    /** 住所 */
    private String supAdder;

    /** 联系人 */
    @Excel(name = "联系人")
    private String supContact;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String supPhone;

    /** 状态 （0代表正常 1代表拉黑） */
    @Excel(name = "状态 ", readConverterExp = "0=代表正常,1=代表拉黑")
    private String status;

    /** 删除状态 （0代表存在 2代表删除） */
    private String delFlag;

    public void setSupId(Long supId) 
    {
        this.supId = supId;
    }

    public Long getSupId() 
    {
        return supId;
    }
    public void setSupGuid(String supGuid) 
    {
        this.supGuid = supGuid;
    }

    public String getSupGuid() 
    {
        return supGuid;
    }
    public void setSupCode(String supCode) 
    {
        this.supCode = supCode;
    }

    public String getSupCode() 
    {
        return supCode;
    }
    public void setSupName(String supName) 
    {
        this.supName = supName;
    }

    public String getSupName() 
    {
        return supName;
    }
    public void setSupLeg(String supLeg) 
    {
        this.supLeg = supLeg;
    }

    public String getSupLeg() 
    {
        return supLeg;
    }
    public void setSupAdder(String supAdder) 
    {
        this.supAdder = supAdder;
    }

    public String getSupAdder() 
    {
        return supAdder;
    }
    public void setSupContact(String supContact) 
    {
        this.supContact = supContact;
    }

    public String getSupContact() 
    {
        return supContact;
    }
    public void setSupPhone(String supPhone) 
    {
        this.supPhone = supPhone;
    }

    public String getSupPhone() 
    {
        return supPhone;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("supId", getSupId())
            .append("supGuid", getSupGuid())
            .append("supCode", getSupCode())
            .append("supName", getSupName())
            .append("supLeg", getSupLeg())
            .append("supAdder", getSupAdder())
            .append("supContact", getSupContact())
            .append("supPhone", getSupPhone())
            .append("remark", getRemark())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
