package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.EquScrap;
import java.util.List;
import java.util.Map;

/**
 * 设备报废报损Mapper接口
 * 
 * @author ruoyi
 * @date 2020-02-24
 */
public interface EquScrapMapper 
{
    /**
     * 查询设备报废报损
     * 
     * @param scrId 设备报废报损ID
     * @return 设备报废报损
     */
    public EquScrap selectEquScrapById(Long scrId);

    /**
     * 查询设备报废报损列表
     * 
     * @param equScrap 设备报废报损
     * @return 设备报废报损集合
     */
    public List<EquScrap> selectEquScrapList(EquScrap equScrap);

    /**
     * 新增设备报废报损
     * 
     * @param equScrap 设备报废报损
     * @return 结果
     */
    public int insertEquScrap(EquScrap equScrap);

    /**
     * 修改设备报废报损
     * 
     * @param equScrap 设备报废报损
     * @return 结果
     */
    public int updateEquScrap(EquScrap equScrap);

    /**
     * 删除设备报废报损
     * 
     * @param scrId 设备报废报损ID
     * @return 结果
     */
    public int deleteEquScrapById(Long scrId);

    /**
     * 批量删除设备报废报损
     * 
     * @param scrIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteEquScrapByIds(String[] scrIds);
    
    /**
     * 生成报废报损流水号的流水号
     * 
     * @param parameterMap 
     * @return
     */
    public int getSerialNumScr(Map<String, String> parameterMap);
}
