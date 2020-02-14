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
import com.ruoyi.system.domain.EquClass;
import com.ruoyi.system.service.IEquClassService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
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
    @GetMapping("/add/{parentId}")
    public String add(@PathVariable("parentId") Long parentId, ModelMap mmap)
    {
        mmap.put("equClass", equClassService.selectEquClassById(parentId));
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
    	if(!equClassService.checkClassNameUnique(equClass))
    	{
    		return error("新增设备分类'" + equClass.getClassName() + "'失败，名称已存在");
    	}
    	equClass.setClassGuid(UUID.randomUUID().toString().replace("-",""));
    	equClass.setCreateBy(ShiroUtils.getLoginName());
    	
    	EquClass info = equClassService.selectEquClassById(equClass.getParentId());
    	if (StringUtils.isNotNull(info))
    	{
    		equClass.setAncestors(info.getAncestors() + "," + equClass.getParentId());
    	}   	
        return toAjax(equClassService.insertEquClass(equClass));
    }

    /**
     * 修改设备分类
     */
    @GetMapping("/edit/{classId}")
    public String edit(@PathVariable("classId") Long classId, ModelMap mmap)
    {
        EquClass equClass = equClassService.selectEquClassById(classId);
        if (StringUtils.isNotNull(equClass) && 1L == classId)
        {
        	equClass.setParentName("无");
        }
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
        if (!equClassService.checkClassNameUnique(equClass))
        {
            return error("修改设备分类'" + equClass.getClassName() + "'失败，名称已存在");
        }
        else if (equClass.getParentId().equals(equClass.getClassId()))
        {
            return error("修改部门'" + equClass.getClassName() + "'失败，上级分类不能是自己");
        }      
    	equClass.setUpdateBy(ShiroUtils.getLoginName());
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
    
    /**
     * 设备分类状态修改
     */
    @Log(title = "设备分类管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:equclass:edit")
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(EquClass equClass)
    {
        return toAjax(equClassService.changeStatus(equClass));
    }
}
