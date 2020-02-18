package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EquSupplierMapper;
import com.ruoyi.system.domain.EquSupplier;
import com.ruoyi.system.service.IEquSupplierService;
import com.ruoyi.common.core.text.Convert;

/**
 * 设备供应商Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-02-17
 */
@Service
public class EquSupplierServiceImpl implements IEquSupplierService 
{
    @Autowired
    private EquSupplierMapper equSupplierMapper;

    /**
     * 查询设备供应商
     * 
     * @param supId 设备供应商ID
     * @return 设备供应商
     */
    @Override
    public EquSupplier selectEquSupplierById(Long supId)
    {
        return equSupplierMapper.selectEquSupplierById(supId);
    }

    /**
     * 查询设备供应商列表
     * 
     * @param equSupplier 设备供应商
     * @return 设备供应商
     */
    @Override
    public List<EquSupplier> selectEquSupplierList(EquSupplier equSupplier)
    {
        return equSupplierMapper.selectEquSupplierList(equSupplier);
    }

    /**
     * 新增设备供应商
     * 
     * @param equSupplier 设备供应商
     * @return 结果
     */
    @Override
    public int insertEquSupplier(EquSupplier equSupplier)
    {
        equSupplier.setCreateTime(DateUtils.getNowDate());
        return equSupplierMapper.insertEquSupplier(equSupplier);
    }

    /**
     * 修改设备供应商
     * 
     * @param equSupplier 设备供应商
     * @return 结果
     */
    @Override
    public int updateEquSupplier(EquSupplier equSupplier)
    {
        equSupplier.setUpdateTime(DateUtils.getNowDate());
        return equSupplierMapper.updateEquSupplier(equSupplier);
    }

    /**
     * 删除设备供应商对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEquSupplierByIds(String ids)
    {
        return equSupplierMapper.deleteEquSupplierByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备供应商信息
     * 
     * @param supId 设备供应商ID
     * @return 结果
     */
    @Override
    public int deleteEquSupplierById(Long supId)
    {
        return equSupplierMapper.deleteEquSupplierById(supId);
    }
}
