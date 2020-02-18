package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.EquContract;
import java.util.List;

/**
 * 设备合同Mapper接口
 * 
 * @author ruoyi
 * @date 2020-02-18
 */
public interface EquContractMapper 
{
    /**
     * 查询设备合同
     * 
     * @param conId 设备合同ID
     * @return 设备合同
     */
    public EquContract selectEquContractById(Long conId);

    /**
     * 查询设备合同列表
     * 
     * @param equContract 设备合同
     * @return 设备合同集合
     */
    public List<EquContract> selectEquContractList(EquContract equContract);

    /**
     * 新增设备合同
     * 
     * @param equContract 设备合同
     * @return 结果
     */
    public int insertEquContract(EquContract equContract);

    /**
     * 修改设备合同
     * 
     * @param equContract 设备合同
     * @return 结果
     */
    public int updateEquContract(EquContract equContract);

    /**
     * 删除设备合同
     * 
     * @param conId 设备合同ID
     * @return 结果
     */
    public int deleteEquContractById(Long conId);

    /**
     * 批量删除设备合同
     * 
     * @param conIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteEquContractByIds(String[] conIds);
}
