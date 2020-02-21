package com.ruoyi.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EquCardMapper;
import com.ruoyi.system.domain.EquCard;
import com.ruoyi.system.service.IEquCardService;
import com.ruoyi.common.core.text.Convert;

/**
 * 设备档案Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-02-14
 */
@Service
public class EquCardServiceImpl implements IEquCardService 
{
    @Autowired
    private EquCardMapper equCardMapper;

    /**
     * 查询设备档案
     * 
     * @param equId 设备档案ID
     * @return 设备档案
     */
    @Override
    public EquCard selectEquCardById(Long equId)
    {
        return equCardMapper.selectEquCardById(equId);
    }

    /**
     * 查询设备档案列表
     * 
     * @param equCard 设备档案
     * @return 设备档案
     */
    @Override
    public List<EquCard> selectEquCardList(EquCard equCard)
    {
        return equCardMapper.selectEquCardList(equCard);
    }

    /**
     * 新增设备档案
     * 
     * @param equCard 设备档案
     * @return 结果
     */
    @Override
    public int insertEquCard(EquCard equCard)
    {
        equCard.setCreateTime(DateUtils.getNowDate());
        return equCardMapper.insertEquCard(equCard);
    }

    /**
     * 修改设备档案
     * 
     * @param equCard 设备档案
     * @return 结果
     */
    @Override
    public int updateEquCard(EquCard equCard)
    {
        equCard.setUpdateTime(DateUtils.getNowDate());
        return equCardMapper.updateEquCard(equCard);
    }

    /**
     * 删除设备档案对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEquCardByIds(String ids)
    {
        return equCardMapper.deleteEquCardByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备档案信息
     * 
     * @param equId 设备档案ID
     * @return 结果
     */
    @Override
    public int deleteEquCardById(Long equId)
    {
        return equCardMapper.deleteEquCardById(equId);
    }
    
    /**
     * 生成设备档案的流水号
     * 
     * @param parameterMap 
     * @return
     */
    @Override
    public String getSerialNumCard()
    {    	
    	Map<String, String> parameterMap = new HashMap<>();
        parameterMap.put("result", "-1");
        equCardMapper.getSerialNumCard(parameterMap);
        
    	return parameterMap.get("result").toString();
    }
    
    /**
     * 查询设备档案列表-供应商-已选择
     * 
     * @param equCard 设备档案
     * @return 设备档案
     */
    @Override
    public List<EquCard> selectSupList(EquCard equCard)
    {
        return equCardMapper.selectSupList(equCard);
    }
    
    /**
     * 查询设备档案列表-合同-已选择
     * 
     * @param equCard 设备档案
     * @return 设备档案
     */
    @Override
    public List<EquCard> selectConList(EquCard equCard)
    {
        return equCardMapper.selectConList(equCard);
    }
    
    /**
     * 移除设备档案对象-供应商
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSups(String ids)
    {
        return equCardMapper.deleteSups(Convert.toStrArray(ids));
    }

    /**
     * 移除设备档案信息-供应商
     * 
     * @param equId 设备档案ID
     * @return 结果
     */
    @Override
    public int deleteSup(Long equId)
    {
        return equCardMapper.deleteSup(equId);
    }
    
    /**
     * 移除设备档案对象-合同
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCons(String ids)
    {
        return equCardMapper.deleteCons(Convert.toStrArray(ids));
    }

    /**
     * 移除设备档案信息-合同
     * 
     * @param equId 设备档案ID
     * @return 结果
     */
    @Override
    public int deleteCon(Long equId)
    {
        return equCardMapper.deleteCon(equId);
    }
    
    /**
     * 查询设备档案列表-供应商-未已选择
     * 
     * @param equCard 设备档案
     * @return 设备档案
     */
    @Override
    public List<EquCard> selectSupListNo(EquCard equCard)
    {
        return equCardMapper.selectSupListNo(equCard);
    }
    
    /**
     * 查询设备档案列表-合同-未已选择
     * 
     * @param equCard 设备档案
     * @return 设备档案
     */
    @Override
    public List<EquCard> selectConListNo(EquCard equCard)
    {
        return equCardMapper.selectConListNo(equCard);
    }
    
    /**
     * 添加设备档案-供应商
     * 
     * @param ids 需要添加的数据ID
     * @return 结果
     */
    @Override
    public int selectCardsSup(String ids, Long mId)
    {
        return equCardMapper.selectCardsSup(Convert.toStrArray(ids), mId);
    }
    
    /**
     * 添加设备档案-合同
     * 
     * @param ids 需要添加的数据ID
     * @return 结果
     */
    @Override
    public int selectCardsCon(String ids, Long mId)
    {
        return equCardMapper.selectCardsCon(Convert.toStrArray(ids), mId);
    }
}
