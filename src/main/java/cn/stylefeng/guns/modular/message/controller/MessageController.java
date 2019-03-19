package cn.stylefeng.guns.modular.message.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.Message;
import cn.stylefeng.guns.modular.message.service.IMessageService;

/**
 * 广告管理控制器
 *
 * @author fengshuonan
 * @Date 2019-03-19 16:13:45
 */
@Controller
@RequestMapping("/message")
public class MessageController extends BaseController {

    private String PREFIX = "/message/message/";

    @Autowired
    private IMessageService messageService;

    /**
     * 跳转到广告管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "message.html";
    }

    /**
     * 跳转到添加广告管理
     */
    @RequestMapping("/message_add")
    public String messageAdd() {
        return PREFIX + "message_add.html";
    }

    /**
     * 跳转到修改广告管理
     */
    @RequestMapping("/message_update/{messageId}")
    public String messageUpdate(@PathVariable Integer messageId, Model model) {
        Message message = messageService.selectById(messageId);
        model.addAttribute("item",message);
        LogObjectHolder.me().set(message);
        return PREFIX + "message_edit.html";
    }

    /**
     * 获取广告管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return messageService.selectList(null);
    }

    /**
     * 新增广告管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Message message) {
        String content = message.getInfo();
        content = content.replaceAll("& ", "&");
        message.setInfo(content);
        messageService.insert(message);
        return SUCCESS_TIP;
    }

    /**
     * 删除广告管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer messageId) {
        messageService.deleteById(messageId);
        return SUCCESS_TIP;
    }

    /**
     * 修改广告管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Message message) {
        String content = message.getInfo();
        content = content.replaceAll("& ", "&");
        message.setInfo(content);
        messageService.updateById(message);
        return SUCCESS_TIP;
    }

    /**
     * 广告管理详情
     */
    @RequestMapping(value = "/detail/{messageId}")
    @ResponseBody
    public Object detail(@PathVariable("messageId") Integer messageId) {
        return messageService.selectById(messageId);
    }
}
