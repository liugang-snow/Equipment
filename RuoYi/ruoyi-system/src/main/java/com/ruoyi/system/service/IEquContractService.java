package com.ruoyi.system.service;

import com.ruoyi.system.domain.EquContract;
import java.util.List;

/**
 * 设备合同Service接口
 * 
 * @author ruoyi
 * @date 2020-02-18
 */
public interface IEquContractService 
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
     * 批量删除设备合同
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEquContractByIds(String ids);

    /**
     * 删除设备合同信息
     * 
     * @param conId 设备合同ID
     * @return 结果
     */
    public int deleteEquContractById(Long conId);
}
