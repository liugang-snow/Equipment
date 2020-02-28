package com.ruoyi.web.controller.system;

import java.util.List;
import java.util.UUID;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.EquScrap;
import com.ruoyi.system.service.IEquCardService;
import com.ruoyi.system.service.IEquScrapService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备报废报损Controller
 * 
 * @author ruoyi
 * @date 2020-02-24
 */
@Controller
@RequestMapping("/system/equscrap")
public class EquScrapController extends BaseController
{
    private String prefix = "system/equscrap";

    @Autowired
    private IEquScrapService equScrapService;

    @Autowired
    private IEquCardService equCardService;
    
    @RequiresPermissions("system:equscrap:view")
    @GetMapping()
    public String equscrap()
    {
        return prefix + "/equscrap";
    }
    
    /**
     * 设备报废报损查看
     */
    @GetMapping("/detail/{scrId}")
    public String detail(@PathVariable("scrId") Long scrId, ModelMap mmap)
    {
        EquScrap equScrap = equScrapService.selectEquScrapById(scrId);
        mmap.put("equScrap", equScrap);
        return prefix + "/detail";
    }

    /**
     * 查询设备报废报损列表
     */
    @RequiresPermissions("system:equscrap:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EquScrap equScrap)
    {
        startPage();
        List<EquScrap> list = equScrapService.selectEquScrapList(equScrap);
        return getDataTable(list);
    }

    /**
     * 导出设备报废报损列表
     */
    @RequiresPermissions("system:equscrap:export")
    @Log(title = "设备报废报损", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EquScrap equScrap)
    {
        List<EquScrap> list = equScrapService.selectEquScrapList(equScrap);
        ExcelUtil<EquScrap> util = new ExcelUtil<EquScrap>(EquScrap.class);
        return util.exportExcel(list, "equscrap");
    }

    /**
     * 新增设备报废报损
     */
    @GetMapping("/add/{equId}")
    public String add(@PathVariable("equId") Long equId, ModelMap mmap)
    {
    	mmap.put("equCard", equCardService.selectEquCardById(equId)); 
        return prefix + "/add";
    }

    /**
     * 新增保存设备报废报损
     */
    @RequiresPermissions("system:equscrap:add")
    @Log(title = "设备报废报损", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EquScrap equScrap)
    {
    	equScrap.setScrSerial(equScrapService.getSerialNumScr());
    	equScrap.setScrGuid(UUID.randomUUID().toString().replace("-", ""));
    	equScrap.setCreateBy(ShiroUtils.getLoginName());
    	int result = equScrapService.insertEquScrap(equScrap);
    	equCardService.setStatus(equScrap.getEquId(), '3');
        return toAjax(result);
    }

    /**
     * 修改设备报废报损
     */
    @GetMapping("/edit/{scrId}")
    public String edit(@PathVariable("scrId") Long scrId, ModelMap mmap)
    {
        EquScrap equScrap = equScrapService.selectEquScrapById(scrId);
        mmap.put("equScrap", equScrap);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备报废报损
     */
    @RequiresPermissions("system:equscrap:edit")
    @Log(title = "设备报废报损", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EquScrap equScrap)
    {
        return toAjax(equScrapService.updateEquScrap(equScrap));
    }

    /**
     * 删除设备报废报损
     */
    @RequiresPermissions("system:equscrap:remove")
    @Log(title = "设备报废报损", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(equScrapService.deleteEquScrapByIds(ids));
    }
    
    /**
     * 设备报废报损 作废
     */
    @Log(title = "设备报废报损", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:equscrap:edit")
    @PostMapping("/cancelScrap")
    @ResponseBody
    public AjaxResult changeStatus(EquScrap equScrap)
    {
    	int result = equScrapService.deleteEquScrapById(equScrap.getScrId());
    	equCardService.setStatus(equScrap.getEquId(), '0');   	
        return toAjax(result);
    }
}
