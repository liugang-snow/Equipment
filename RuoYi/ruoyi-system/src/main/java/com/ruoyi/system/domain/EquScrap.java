package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备报废报损对象 equ_scrap
 * 
 * @author ruoyi
 * @date 2020-02-24
 */
public class EquScrap extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID 主键 */
    private Long scrId;

    /** Guid */
    private String scrGuid;
    
    /** 报废报损流水号 */
    private String scrSerial;

    /** 报废报损单编号 */
    private String scrCode;

    /** 设备id 设备档案表主键 */
    private Long equId;
    
    /** 设备流水号 */
    private String equSerial;
    
    /** 设备名称 */
    private String equName;

    /** 报废理由 */
    private String scrReason;

    /** 删除状态 （0代表存在 2代表删除） */
    private String delFlag;

    public void setScrId(Long scrId) 
    {
        this.scrId = scrId;
    }

    public Long getScrId() 
    {
        return scrId;
    }
    public void setScrGuid(String scrGuid) 
    {
        this.scrGuid = scrGuid;
    }

    public String getScrGuid() 
    {
        return scrGuid;
    }
    public void setScrSerial(String scrSerial) 
    {
        this.scrSerial = scrSerial;
    }

    public String getScrSerial() 
    {
        return scrSerial;
    }
    public void setScrCode(String scrCode) 
    {
        this.scrCode = scrCode;
    }

    public String getScrCode() 
    {
        return scrCode;
    }
    public void setEquId(Long equId) 
    {
        this.equId = equId;
    }

    public Long getEquId() 
    {
        return equId;
    }
    public void setScrReason(String scrReason) 
    {
        this.scrReason = scrReason;
    }

    public String getScrReason() 
    {
        return scrReason;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public String getEquSerial() 
    {
        return equSerial;
    }
    
    public void setEquSerial(String equSerial) 
    {
        this.equSerial = equSerial;
    }
    public void setEquName(String equName) 
    {
        this.equName = equName;
    }

    public String getEquName() 
    {
        return equName;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("scrId", getScrId())
            .append("scrGuid", getScrGuid())
            .append("scrSerial", getScrSerial())
            .append("scrCode", getScrCode())
            .append("equId", getEquId())
            .append("scrReason", getScrReason())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
