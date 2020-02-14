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
import com.ruoyi.system.domain.EquCard;
import com.ruoyi.system.domain.EquClass;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.service.IEquCardService;
import com.ruoyi.system.service.IEquClassService;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备档案Controller
 * 
 * @author ruoyi
 * @date 2020-02-14
 */
@Controller
@RequestMapping("/system/euqcard")
public class EquCardController extends BaseController
{
    private String prefix = "system/euqcard";

    @Autowired
    private IEquCardService equCardService;
    
    @Autowired
    private IEquClassService equClassService;
    
    @Autowired
    private ISysDeptService sysDeptService;
    
    @RequiresPermissions("system:euqcard:view")
    @GetMapping()
    public String euqcard()
    {
        return prefix + "/euqcard";
    }

    /**
     * 查询设备档案列表
     */
    @RequiresPermissions("system:euqcard:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EquCard equCard)
    {
        startPage();
        List<EquCard> list = equCardService.selectEquCardList(equCard);
        return getDataTable(list);
    }

    /**
     * 导出设备档案列表
     */
    @RequiresPermissions("system:euqcard:export")
    @Log(title = "设备档案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EquCard equCard)
    {
        List<EquCard> list = equCardService.selectEquCardList(equCard);
        ExcelUtil<EquCard> util = new ExcelUtil<EquCard>(EquCard.class);
        return util.exportExcel(list, "euqcard");
    }

    /**
     * 新增设备档案
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备档案
     */
    @RequiresPermissions("system:euqcard:add")
    @Log(title = "设备档案", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EquCard equCard)
    {
    	equCard.setEquGuid(UUID.randomUUID().toString().replace("-", ""));
    	equCard.setEquSerial(equCardService.getSerialNumCard());
    	equCard.setCreateBy(ShiroUtils.getLoginName());
    	equCard.setEquPrice(equCard.getEquCount() * equCard.getEquSprice());
        return toAjax(equCardService.insertEquCard(equCard));
    }

    /**
     * 修改设备档案
     */
    @GetMapping("/edit/{equId}")
    public String edit(@PathVariable("equId") Long equId, ModelMap mmap)
    {
        EquCard equCard = equCardService.selectEquCardById(equId);     
        EquClass equClass = equClassService.selectEquClassById(equCard.getClassId());
        if (StringUtils.isNotNull(equClass))
        {
        	equCard.setClassName(equClass.getClassName());
        }
        SysDept sysDept = sysDeptService.selectDeptById(equCard.getDeptId());
        if (StringUtils.isNotNull(sysDept))
        {
        	equCard.setDeptName(sysDept.getDeptName());
        }
        mmap.put("equCard", equCard);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备档案
     */
    @RequiresPermissions("system:euqcard:edit")
    @Log(title = "设备档案", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EquCard equCard)
    {
    	equCard.setUpdateBy(ShiroUtils.getLoginName());
    	double sum = equCard.getEquCount() * equCard.getEquSprice();
    	equCard.setEquPrice(sum);    	
        return toAjax(equCardService.updateEquCard(equCard));
    }

    /**
     * 删除设备档案
     */
    @RequiresPermissions("system:euqcard:remove")
    @Log(title = "设备档案", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(equCardService.deleteEquCardByIds(ids));
    }
}
