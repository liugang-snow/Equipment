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
import com.ruoyi.system.service.IEquCardService;
import com.ruoyi.system.service.IEquContractService;
import com.ruoyi.system.service.IEquSupplierService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
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
@RequestMapping("/system/equcard")
public class EquCardController extends BaseController
{
    private String prefix = "system/equcard";

    @Autowired
    private IEquCardService equCardService;
    
    @Autowired
    private IEquContractService equContractService;
    
    @Autowired
    private IEquSupplierService equSupplierService;
    
    @RequiresPermissions("system:equcard:view")
    @GetMapping()
    public String equcard()
    {
        return prefix + "/equcard";
    }
    
    /**
     * 设备档案查看
     */
    @GetMapping("/detail/{equId}")
    public String detail(@PathVariable("equId") Long equId, ModelMap mmap)
    {
        EquCard equCard = equCardService.selectEquCardById(equId);     
        mmap.put("equCard", equCard);
        return prefix + "/detail";
    }
  
    /**
     * 设备查询
     */
    @RequiresPermissions("system:equcard:search")
    @GetMapping("/search")
    public String equcardsearch()
    {
        return prefix + "/search";
    }
    
    /**
     * 设备查询-查看
     */
    @RequiresPermissions("system:equcard:search")
    @GetMapping("/searchView/{equId}")
    public String searchView(@PathVariable("equId") Long equId, ModelMap mmap)
    {    
    	EquCard equCard = equCardService.selectEquCardById(equId);    	
        mmap.put("equCard", equCard);
        mmap.put("equContract", equContractService.selectEquContractById(equCard.getContractId()));
        mmap.put("equSupplier", equSupplierService.selectEquSupplierById(equCard.getSupplierId()));
        return prefix + "/searchView";
    }

    /**
     * 查询设备档案列表
     */
    @RequiresPermissions("system:equcard:list")
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
    @RequiresPermissions("system:equcard:export")
    @Log(title = "设备档案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EquCard equCard)
    {
        List<EquCard> list = equCardService.selectEquCardList(equCard);
        ExcelUtil<EquCard> util = new ExcelUtil<EquCard>(EquCard.class);
        return util.exportExcel(list, "equcard");
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
    @RequiresPermissions("system:equcard:add")
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
        mmap.put("equCard", equCard);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备档案
     */
    @RequiresPermissions("system:equcard:edit")
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
    @RequiresPermissions("system:equcard:remove")
    @Log(title = "设备档案", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(equCardService.deleteEquCardByIds(ids));
    }
    
    /**
     * 选择设备
     */
    @RequiresPermissions("system:equcard:edit")
    @GetMapping("/selectEqus/{id}/{type}")
    public String selectEqus(@PathVariable("id") Long id, @PathVariable("type") String type, ModelMap mmap)
    {
        mmap.put("mId", id);
        mmap.put("mType", type);      
        return prefix + "/selectEqus";
    }
    
    /**
     * 设备列表-供应商-已添加
     */
    @RequiresPermissions("system:equcard:list")
    @PostMapping("/selectEqus/selectSupList")
    @ResponseBody
    public TableDataInfo selectSupList(EquCard equCard)
    {
        startPage();
        List<EquCard> list = equCardService.selectSupList(equCard);
        return getDataTable(list);
    }
    
    /**
     * 设备列表-合同-已添加
     */
    @RequiresPermissions("system:equcard:list")
    @PostMapping("/selectEqus/selectConList")
    @ResponseBody
    public TableDataInfo selectConList(EquCard equCard)
    {
        startPage();
        List<EquCard> list = equCardService.selectConList(equCard);
        return getDataTable(list);
    }
    
    /**
     * 移除设备档案
     */
    @RequiresPermissions("system:equcard:remove")
    @Log(title = "设备档案", businessType = BusinessType.DELETE)
    @PostMapping( "/selectEqus/cancel")
    @ResponseBody
    public AjaxResult cancel(Long id, String type)
    {
    	if (type.equals("sup"))
    		return toAjax(equCardService.deleteSup(id));
    	else
    		return toAjax(equCardService.deleteCon(id));
    }
    
    /**
     * 批量移除设备档案
     */
    @RequiresPermissions("system:equcard:remove")
    @Log(title = "设备档案", businessType = BusinessType.DELETE)
    @PostMapping( "/selectEqus/cancels")
    @ResponseBody
    public AjaxResult cancels(String ids, String type)
    {
    	if (type.equals("sup"))
    		return toAjax(equCardService.deleteSups(ids));
    	else
    		return toAjax(equCardService.deleteCons(ids));
    }
    
    /**
     * 设备列表-供应商-未已添加
     */
    @RequiresPermissions("system:equcard:list")
    @PostMapping("/selectEqus/selectSupListNo")
    @ResponseBody
    public TableDataInfo selectSupListNo(EquCard equCard)
    {
        startPage();
        List<EquCard> list = equCardService.selectSupListNo(equCard);
        return getDataTable(list);
    }
    
    /**
     * 设备列表-合同-未已添加
     */
    @RequiresPermissions("system:equcard:list")
    @PostMapping("/selectEqus/selectConListNo")
    @ResponseBody
    public TableDataInfo selectConListNo(EquCard equCard)
    {
        startPage();
        List<EquCard> list = equCardService.selectConListNo(equCard);
        return getDataTable(list);
    }  
    
    /**
     * 选择设备-添加设备
     */
    @GetMapping("/selectEqus/selectEquCards/{id}/{type}")
    public String selectEquCards(@PathVariable("id") Long id, @PathVariable("type") String type, ModelMap mmap)
    {
        mmap.put("mId", id);
        mmap.put("mType", type);      
        return prefix + "/selectEquCards";
    }
    
    /**
     * 选择设备-添加设备-提交
     */
    @RequiresPermissions("system:equcard:update")
    @Log(title = "设备档案", businessType = BusinessType.DELETE)
    @PostMapping( "/selectEqus/selectCards")
    @ResponseBody
    public AjaxResult selectCards(String ids, Long mId, String mType)
    {
    	if (mType.equals("sup"))
    		return toAjax(equCardService.selectCardsSup(ids, mId));
    	else
    		return toAjax(equCardService.selectCardsCon(ids, mId));
    }
}
