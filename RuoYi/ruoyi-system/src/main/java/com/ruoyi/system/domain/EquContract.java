package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 设备合同对象 equ_contract
 * 
 * @author ruoyi
 * @date 2020-02-18
 */
public class EquContract extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID 主键 */
    private Long conId;

    /** Guid */
    private String conGuid;

    /** 合同编号 */
    @Excel(name = "合同编号")
    private String conCode;

    /** 合同名称 */
    @Excel(name = "合同名称")
    private String conName;

    /** 合同金额 */
    @Excel(name = "合同金额")
    private Double conAmount;

    /** 签订日期 */
    @Excel(name = "签订日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date conTime;

    /** 合同甲方 */
    private String conFirst;

    /** 甲方联系人 */
    private String firstContacts;

    /** 甲方联系方式 */
    private String firstPhone;

    /** 合同乙方 */
    private String conSecond;

    /** 乙方联系人 */
    private String secondContacts;

    /** 乙方联系方式 */
    private String secondPhone;

    /** 删除状态 （0代表存在 2代表删除） */
    private String delFlag;

    public void setConId(Long conId) 
    {
        this.conId = conId;
    }

    public Long getConId() 
    {
        return conId;
    }
    public void setConGuid(String conGuid) 
    {
        this.conGuid = conGuid;
    }

    public String getConGuid() 
    {
        return conGuid;
    }
    public void setConCode(String conCode) 
    {
        this.conCode = conCode;
    }

    public String getConCode() 
    {
        return conCode;
    }
    public void setConName(String conName) 
    {
        this.conName = conName;
    }

    public String getConName() 
    {
        return conName;
    }
    public void setConAmount(Double conAmount) 
    {
        this.conAmount = conAmount;
    }

    public Double getConAmount() 
    {
        return conAmount;
    }
    public void setConTime(Date conTime) 
    {
        this.conTime = conTime;
    }

    public Date getConTime() 
    {
        return conTime;
    }
    public void setConFirst(String conFirst) 
    {
        this.conFirst = conFirst;
    }

    public String getConFirst() 
    {
        return conFirst;
    }
    public void setFirstContacts(String firstContacts) 
    {
        this.firstContacts = firstContacts;
    }

    public String getFirstContacts() 
    {
        return firstContacts;
    }
    public void setFirstPhone(String firstPhone) 
    {
        this.firstPhone = firstPhone;
    }

    public String getFirstPhone() 
    {
        return firstPhone;
    }
    public void setConSecond(String conSecond) 
    {
        this.conSecond = conSecond;
    }

    public String getConSecond() 
    {
        return conSecond;
    }
    public void setSecondContacts(String secondContacts) 
    {
        this.secondContacts = secondContacts;
    }

    public String getSecondContacts() 
    {
        return secondContacts;
    }
    public void setSecondPhone(String secondPhone) 
    {
        this.secondPhone = secondPhone;
    }

    public String getSecondPhone() 
    {
        return secondPhone;
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
            .append("conId", getConId())
            .append("conGuid", getConGuid())
            .append("conCode", getConCode())
            .append("conName", getConName())
            .append("conAmount", getConAmount())
            .append("conTime", getConTime())
            .append("conFirst", getConFirst())
            .append("firstContacts", getFirstContacts())
            .append("firstPhone", getFirstPhone())
            .append("conSecond", getConSecond())
            .append("secondContacts", getSecondContacts())
            .append("secondPhone", getSecondPhone())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
