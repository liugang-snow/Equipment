package com.ruoyi.web.controller.system;

import java.util.List;
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
import com.ruoyi.system.domain.EquClass;
import com.ruoyi.system.service.IEquClassService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.core.domain.Ztree;

/**
 * 设备分类Controller
 * 
 * @author ruoyi
 * @date 2020-02-11
 */
@Controller
@RequestMapping("/system/equclass")
public class EquClassController extends BaseController
{
    private String prefix = "system/equclass";

    @Autowired
    private IEquClassService equClassService;

    @RequiresPermissions("system:equclass:view")
    @GetMapping()
    public String equclass()
    {
        return prefix + "/equclass";
    }

    /**
     * 查询设备分类树列表
     */
    @RequiresPermissions("system:equclass:list")
    @PostMapping("/list")
    @ResponseBody
    public List<EquClass> list(EquClass equClass)
    {
        List<EquClass> list = equClassService.selectEquClassList(equClass);
        return list;
    }

    /**
     * 导出设备分类列表
     */
    @RequiresPermissions("system:equclass:export")
    @Log(title = "设备分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EquClass equClass)
    {
        List<EquClass> list = equClassService.selectEquClassList(equClass);
        ExcelUtil<EquClass> util = new ExcelUtil<EquClass>(EquClass.class);
        return util.exportExcel(list, "equclass");
    }

    /**
     * 新增设备分类
     */
    @GetMapping(value = { "/add/{classId}", "/add/" })
    public String add(@PathVariable(value = "classId", required = false) Long classId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(classId))
        {
            mmap.put("equClass", equClassService.selectEquClassById(classId));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存设备分类
     */
    @RequiresPermissions("system:equclass:add")
    @Log(title = "设备分类", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EquClass equClass)
    {
        return toAjax(equClassService.insertEquClass(equClass));
    }

    /**
     * 修改设备分类
     */
    @GetMapping("/edit/{classId}")
    public String edit(@PathVariable("classId") Long classId, ModelMap mmap)
    {
        EquClass equClass = equClassService.selectEquClassById(classId);
        mmap.put("equClass", equClass);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备分类
     */
    @RequiresPermissions("system:equclass:edit")
    @Log(title = "设备分类", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EquClass equClass)
    {
        return toAjax(equClassService.updateEquClass(equClass));
    }

    /**
     * 删除
     */
    @RequiresPermissions("system:equclass:remove")
    @Log(title = "设备分类", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{classId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("classId") Long classId)
    {
        return toAjax(equClassService.deleteEquClassById(classId));
    }

    /**
     * 选择设备分类树
     */
    @GetMapping(value = { "/selectEquclassTree/{classId}", "/selectEquclassTree/" })
    public String selectEquclassTree(@PathVariable(value = "classId", required = false) Long classId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(classId))
        {
            mmap.put("equClass", equClassService.selectEquClassById(classId));
        }
        return prefix + "/tree";
    }

    /**
     * 加载设备分类树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = equClassService.selectEquClassTree();
        return ztrees;
    }
}
