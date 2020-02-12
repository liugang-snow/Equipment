package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.EquClass;
import java.util.List;

/**
 * 设备分类Mapper接口
 * 
 * @author ruoyi
 * @date 2020-02-11
 */
public interface EquClassMapper 
{
    /**
     * 查询设备分类
     * 
     * @param classId 设备分类ID
     * @return 设备分类
     */
    public EquClass selectEquClassById(Long classId);

    /**
     * 查询设备分类列表
     * 
     * @param equClass 设备分类
     * @return 设备分类集合
     */
    public List<EquClass> selectEquClassList(EquClass equClass);

    /**
     * 新增设备分类
     * 
     * @param equClass 设备分类
     * @return 结果
     */
    public int insertEquClass(EquClass equClass);

    /**
     * 修改设备分类
     * 
     * @param equClass 设备分类
     * @return 结果
     */
    public int updateEquClass(EquClass equClass);

    /**
     * 删除设备分类
     * 
     * @param classId 设备分类ID
     * @return 结果
     */
    public int deleteEquClassById(Long classId);

    /**
     * 批量删除设备分类
     * 
     * @param classIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteEquClassByIds(String[] classIds);
}
