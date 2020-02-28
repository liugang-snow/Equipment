package com.ruoyi.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EquScrapMapper;
import com.ruoyi.system.domain.EquScrap;
import com.ruoyi.system.service.IEquScrapService;
import com.ruoyi.common.core.text.Convert;

/**
 * 设备报废报损Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-02-24
 */
@Service
public class EquScrapServiceImpl implements IEquScrapService 
{
    @Autowired
    private EquScrapMapper equScrapMapper;

    /**
     * 查询设备报废报损
     * 
     * @param scrId 设备报废报损ID
     * @return 设备报废报损
     */
    @Override
    public EquScrap selectEquScrapById(Long scrId)
    {
        return equScrapMapper.selectEquScrapById(scrId);
    }

    /**
     * 查询设备报废报损列表
     * 
     * @param equScrap 设备报废报损
     * @return 设备报废报损
     */
    @Override
    public List<EquScrap> selectEquScrapList(EquScrap equScrap)
    {
        return equScrapMapper.selectEquScrapList(equScrap);
    }

    /**
     * 新增设备报废报损
     * 
     * @param equScrap 设备报废报损
     * @return 结果
     */
    @Override
    public int insertEquScrap(EquScrap equScrap)
    {
        equScrap.setCreateTime(DateUtils.getNowDate());
        return equScrapMapper.insertEquScrap(equScrap);
    }

    /**
     * 修改设备报废报损
     * 
     * @param equScrap 设备报废报损
     * @return 结果
     */
    @Override
    public int updateEquScrap(EquScrap equScrap)
    {
        equScrap.setUpdateTime(DateUtils.getNowDate());
        return equScrapMapper.updateEquScrap(equScrap);
    }

    /**
     * 删除设备报废报损对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEquScrapByIds(String ids)
    {
        return equScrapMapper.deleteEquScrapByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备报废报损信息
     * 
     * @param scrId 设备报废报损ID
     * @return 结果
     */
    @Override
    public int deleteEquScrapById(Long scrId)
    {
        return equScrapMapper.deleteEquScrapById(scrId);
    }
    
    /**
     * 生成报废报损的流水号
     * 
     * @param parameterMap 
     * @return
     */
    @Override
    public String getSerialNumScr()
    {    	
    	Map<String, String> parameterMap = new HashMap<>();
        parameterMap.put("result", "-1");
        equScrapMapper.getSerialNumScr(parameterMap);
        
    	return parameterMap.get("result").toString();
    }
}
