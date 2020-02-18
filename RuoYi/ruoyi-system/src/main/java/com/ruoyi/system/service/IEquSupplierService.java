package com.ruoyi.system.service;

import com.ruoyi.system.domain.EquSupplier;
import java.util.List;

/**
 * 设备供应商Service接口
 * 
 * @author ruoyi
 * @date 2020-02-17
 */
public interface IEquSupplierService 
{
    /**
     * 查询设备供应商
     * 
     * @param supId 设备供应商ID
     * @return 设备供应商
     */
    public EquSupplier selectEquSupplierById(Long supId);

    /**
     * 查询设备供应商列表
     * 
     * @param equSupplier 设备供应商
     * @return 设备供应商集合
     */
    public List<EquSupplier> selectEquSupplierList(EquSupplier equSupplier);

    /**
     * 新增设备供应商
     * 
     * @param equSupplier 设备供应商
     * @return 结果
     */
    public int insertEquSupplier(EquSupplier equSupplier);

    /**
     * 修改设备供应商
     * 
     * @param equSupplier 设备供应商
     * @return 结果
     */
    public int updateEquSupplier(EquSupplier equSupplier);

    /**
     * 批量删除设备供应商
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEquSupplierByIds(String ids);

    /**
     * 删除设备供应商信息
     * 
     * @param supId 设备供应商ID
     * @return 结果
     */
    public int deleteEquSupplierById(Long supId);
}
