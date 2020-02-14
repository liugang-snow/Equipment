package com.ruoyi.system.service;

import com.ruoyi.system.domain.EquCard;
import java.util.List;

/**
 * 设备档案Service接口
 * 
 * @author ruoyi
 * @date 2020-02-14
 */
public interface IEquCardService 
{
    /**
     * 查询设备档案
     * 
     * @param equId 设备档案ID
     * @return 设备档案
     */
    public EquCard selectEquCardById(Long equId);

    /**
     * 查询设备档案列表
     * 
     * @param equCard 设备档案
     * @return 设备档案集合
     */
    public List<EquCard> selectEquCardList(EquCard equCard);

    /**
     * 新增设备档案
     * 
     * @param equCard 设备档案
     * @return 结果
     */
    public int insertEquCard(EquCard equCard);

    /**
     * 修改设备档案
     * 
     * @param equCard 设备档案
     * @return 结果
     */
    public int updateEquCard(EquCard equCard);

    /**
     * 批量删除设备档案
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEquCardByIds(String ids);

    /**
     * 删除设备档案信息
     * 
     * @param equId 设备档案ID
     * @return 结果
     */
    public int deleteEquCardById(Long equId);
    
    /**
     * 生成设备档案的流水号
     * 
     * @param parameterMap 
     * @return
     */
    public String getSerialNumCard();
}
