package cn.stylefeng.guns.modular.web.controller;

import cn.hutool.core.util.StrUtil;
import cn.stylefeng.guns.modular.message.service.IMessageService;
import cn.stylefeng.guns.modular.system.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/web")
public class WebController {
    private String PREFIX = "/web/";
    @Autowired
    private IMessageService messageService;

    @RequestMapping(value = "/{id}/{openid}")
    public Object getWeb(@PathVariable("id") Integer id, @PathVariable("openid") String openid, Model model){
        Message message = messageService.selectById(id);
        if(StrUtil.isBlank(message.getInfo())){
            message.setInfo("ID填写错误");
        }
        model.addAttribute("item",message);
        return PREFIX + "web.html";
    }
}
