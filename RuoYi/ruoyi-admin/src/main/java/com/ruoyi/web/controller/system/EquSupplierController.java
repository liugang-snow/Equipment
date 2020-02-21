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
import com.ruoyi.system.domain.EquSupplier;
import com.ruoyi.system.service.IEquSupplierService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备供应商Controller
 * 
 * @author ruoyi
 * @date 2020-02-17
 */
@Controller
@RequestMapping("/system/equsupplier")
public class EquSupplierController extends BaseController
{
    private String prefix = "system/equsupplier";

    @Autowired
    private IEquSupplierService equSupplierService;

    @RequiresPermissions("system:equsupplier:view")
    @GetMapping()
    public String equsupplier()
    {
        return prefix + "/equsupplier";
    }

    /**
     * 查询设备供应商列表
     */
    @RequiresPermissions("system:equsupplier:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EquSupplier equSupplier)
    {
        startPage();
        List<EquSupplier> list = equSupplierService.selectEquSupplierList(equSupplier);
        return getDataTable(list);
    }

    /**
     * 导出设备供应商列表
     */
    @RequiresPermissions("system:equsupplier:export")
    @Log(title = "设备供应商", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EquSupplier equSupplier)
    {
        List<EquSupplier> list = equSupplierService.selectEquSupplierList(equSupplier);
        ExcelUtil<EquSupplier> util = new ExcelUtil<EquSupplier>(EquSupplier.class);
        return util.exportExcel(list, "equsupplier");
    }

    /**
     * 新增设备供应商
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备供应商
     */
    @RequiresPermissions("system:equsupplier:add")
    @Log(title = "设备供应商", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EquSupplier equSupplier)
    {
    	equSupplier.setSupGuid(UUID.randomUUID().toString().replace("-", ""));
    	equSupplier.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(equSupplierService.insertEquSupplier(equSupplier));
    }

    /**
     * 修改设备供应商
     */
    @GetMapping("/edit/{supId}")
    public String edit(@PathVariable("supId") Long supId, ModelMap mmap)
    {
        EquSupplier equSupplier = equSupplierService.selectEquSupplierById(supId);
        mmap.put("equSupplier", equSupplier);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备供应商
     */
    @RequiresPermissions("system:equsupplier:edit")
    @Log(title = "设备供应商", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EquSupplier equSupplier)
    {
    	equSupplier.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(equSupplierService.updateEquSupplier(equSupplier));
    }

    /**
     * 删除设备供应商
     */
    @RequiresPermissions("system:equsupplier:remove")
    @Log(title = "设备供应商", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(equSupplierService.deleteEquSupplierByIds(ids));
    }
    
    /**
     * 设备档案-选择供应商
     */
    @GetMapping("/selectSups")
    public String selectSups()
    {
        return prefix + "/selectSups";
    }
}
