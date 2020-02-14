package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.EquCard;
import java.util.List;
import java.util.Map;

/**
 * 设备档案Mapper接口
 * 
 * @author ruoyi
 * @date 2020-02-14
 */
public interface EquCardMapper 
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
     * 删除设备档案
     * 
     * @param equId 设备档案ID
     * @return 结果
     */
    public int deleteEquCardById(Long equId);

    /**
     * 批量删除设备档案
     * 
     * @param equIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteEquCardByIds(String[] equIds);
    
    /**
     * 生成设备档案的流水号
     * 
     * @param parameterMap 
     * @return
     */
    public int getSerialNumCard(Map<String, String> parameterMap);

}
