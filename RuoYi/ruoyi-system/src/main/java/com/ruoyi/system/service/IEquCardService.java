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
    
    /**
     * 查询设备档案列表-供应商-已选择
     * 
     * @param equCard 设备档案
     * @return 设备档案集合
     */
    public List<EquCard> selectSupList(EquCard equCard);
    
    /**
     * 查询设备档案列表-合同-已选择
     * 
     * @param equCard 设备档案
     * @return 设备档案集合
     */
    public List<EquCard> selectConList(EquCard equCard);
    
    /**
     * 移除设备档案-供应商
     * 
     * @param equId 设备档案ID
     * @return 结果
     */
    public int deleteSup(Long equId);

    /**
     * 批量移除设备档案-供应商
     * 
     * @param equIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSups(String ids);
    
    /**
     * 移除设备档案-合同
     * 
     * @param equId 设备档案ID
     * @return 结果
     */
    public int deleteCon(Long equId);

    /**
     * 批量移除设备档案-合同
     * 
     * @param equIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCons(String ids);
    
    /**
     * 查询设备档案列表-供应商-未已选择
     * 
     * @param equCard 设备档案
     * @return 设备档案集合
     */
    public List<EquCard> selectSupListNo(EquCard equCard);
    
    /**
     * 查询设备档案列表-合同-未已选择
     * 
     * @param equCard 设备档案
     * @return 设备档案集合
     */
    public List<EquCard> selectConListNo(EquCard equCard);
    
    /**
     * 添加设备档案-供应商
     * 
     * @param equIds 需要添加的数据ID
     * @param mId 供应商ID
     * @return 结果
     */
    public int selectCardsSup(String ids, Long mId);
    
    /**
     * 添加设备档案-合同
     * 
     * @param equIds 需要添加的数据ID
     * @param mId 合同ID
     * @return 结果
     */
    public int selectCardsCon(String ids, Long mId);
      
    /**
     * 设置设备档案状态
     * 
     * @param equId 需要添加的数据ID
     * @param status 状态
     * @return 结果
     */
    public int setStatus(Long equId, char status);
      
    /**
     * 批量设置设备档案状态
     * 
     * @param equIds 需要添加的数据ID
     * @param status 状态 
     * @return 结果
     */
    public int setStatuses(String ids, char status);
}
