package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EquClassMapper;
import com.ruoyi.system.domain.EquClass;
import com.ruoyi.system.service.IEquClassService;
import com.ruoyi.common.core.text.Convert;

/**
 * 设备分类Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-02-11
 */
@Service
public class EquClassServiceImpl implements IEquClassService 
{
    @Autowired
    private EquClassMapper equClassMapper;

    /**
     * 查询设备分类
     * 
     * @param classId 设备分类ID
     * @return 设备分类
     */
    @Override
    public EquClass selectEquClassById(Long classId)
    {
        return equClassMapper.selectEquClassById(classId);
    }

    /**
     * 查询设备分类列表
     * 
     * @param equClass 设备分类
     * @return 设备分类
     */
    @Override
    public List<EquClass> selectEquClassList(EquClass equClass)
    {
        return equClassMapper.selectEquClassList(equClass);
    }

    /**
     * 新增设备分类
     * 
     * @param equClass 设备分类
     * @return 结果
     */
    @Override
    public int insertEquClass(EquClass equClass)
    {
        equClass.setCreateTime(DateUtils.getNowDate());
        return equClassMapper.insertEquClass(equClass);
    }

    /**
     * 修改设备分类
     * 
     * @param equClass 设备分类
     * @return 结果
     */
    @Override
    public int updateEquClass(EquClass equClass)
    {
        equClass.setUpdateTime(DateUtils.getNowDate());
        return equClassMapper.updateEquClass(equClass);
    }

    /**
     * 删除设备分类对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEquClassByIds(String ids)
    {
        return equClassMapper.deleteEquClassByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备分类信息
     * 
     * @param classId 设备分类ID
     * @return 结果
     */
    @Override
    public int deleteEquClassById(Long classId)
    {
        return equClassMapper.deleteEquClassById(classId);
    }

    /**
     * 查询设备分类树列表
     * 
     * @return 所有设备分类信息
     */
    @Override
    public List<Ztree> selectEquClassTree()
    {
        List<EquClass> equClassList = equClassMapper.selectEquClassList(new EquClass());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (EquClass equClass : equClassList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(equClass.getClassId());
            ztree.setpId(equClass.getParentId());
            ztree.setName(equClass.getClassName());
            ztree.setTitle(equClass.getClassName());
            ztrees.add(ztree);
        }
        return ztrees;
    }
    
    /**
     * 校验设备分类名称是否唯一
     * 
     * @param equClass 设备分类信息
     * @return 结果
     */
    public boolean checkClassNameUnique(EquClass equClass)
    {
    	Long classID = StringUtils.isNull(equClass.getClassId())? -1L : equClass.getClassId();
    	EquClass info = equClassMapper.checkClassNameUnique(equClass.getClassName(), equClass.getParentId());
    	if (StringUtils.isNotNull(info) && info.getClassId().longValue() != classID.longValue())
    		return false;
    	return true;    	
    }
      
    /**
     * 设备分类状态修改
     * 
     * @param equClass 设备分类信息
     * @return 结果
     */
    @Override
    public int changeStatus(EquClass equClass)
    {
        return equClassMapper.updateEquClass(equClass);
    }
}
