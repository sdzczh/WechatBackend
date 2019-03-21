package cn.stylefeng.guns.modular.browseRecord.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.BrowseRecord;
import cn.stylefeng.guns.modular.browseRecord.service.IBrowseRecordService;

/**
 * 浏览记录控制器
 *
 * @author fengshuonan
 * @Date 2019-03-20 13:57:31
 */
@Controller
@RequestMapping("/browseRecord")
public class BrowseRecordController extends BaseController {

    private String PREFIX = "/browseRecord/browseRecord/";

    @Autowired
    private IBrowseRecordService browseRecordService;

    /**
     * 跳转到浏览记录首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "browseRecord.html";
    }

    /**
     * 跳转到添加浏览记录
     */
    @RequestMapping("/browseRecord_add")
    public String browseRecordAdd() {
        return PREFIX + "browseRecord_add.html";
    }

    /**
     * 跳转到修改浏览记录
     */
    @RequestMapping("/browseRecord_update/{browseRecordId}")
    public String browseRecordUpdate(@PathVariable Integer browseRecordId, Model model) {
        BrowseRecord browseRecord = browseRecordService.selectById(browseRecordId);
        model.addAttribute("item",browseRecord);
        LogObjectHolder.me().set(browseRecord);
        return PREFIX + "browseRecord_edit.html";
    }

    /**
     * 获取浏览记录列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return browseRecordService.selectList(null);
    }

    /**
     * 新增浏览记录
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(BrowseRecord browseRecord) {
        browseRecordService.insert(browseRecord);
        return SUCCESS_TIP;
    }

    /**
     * 删除浏览记录
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer browseRecordId) {
        browseRecordService.deleteById(browseRecordId);
        return SUCCESS_TIP;
    }

    /**
     * 修改浏览记录
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(BrowseRecord browseRecord) {
        browseRecordService.updateById(browseRecord);
        return SUCCESS_TIP;
    }

    /**
     * 浏览记录详情
     */
    @RequestMapping(value = "/detail/{browseRecordId}")
    @ResponseBody
    public Object detail(@PathVariable("browseRecordId") Integer browseRecordId) {
        return browseRecordService.selectById(browseRecordId);
    }
}
