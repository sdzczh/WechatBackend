package cn.stylefeng.guns.modular.Consumer.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.TUser;
import cn.stylefeng.guns.modular.Consumer.service.ITUserService;

/**
 * Consumer控制器
 *
 * @author fengshuonan
 * @Date 2019-03-18 17:25:32
 */
@Controller
@RequestMapping("/tUser")
public class TUserController extends BaseController {

    private String PREFIX = "/Consumer/tUser/";

    @Autowired
    private ITUserService tUserService;

    /**
     * 跳转到Consumer首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "tUser.html";
    }

    /**
     * 跳转到添加Consumer
     */
    @RequestMapping("/tUser_add")
    public String tUserAdd() {
        return PREFIX + "tUser_add.html";
    }

    /**
     * 跳转到修改Consumer
     */
    @RequestMapping("/tUser_update/{tUserId}")
    public String tUserUpdate(@PathVariable Integer tUserId, Model model) {
        TUser tUser = tUserService.selectById(tUserId);
        model.addAttribute("item",tUser);
        LogObjectHolder.me().set(tUser);
        return PREFIX + "tUser_edit.html";
    }

    /**
     * 获取Consumer列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return tUserService.selectList(null);
    }

    /**
     * 新增Consumer
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(TUser tUser) {
        tUserService.insert(tUser);
        return SUCCESS_TIP;
    }

    /**
     * 删除Consumer
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer tUserId) {
        tUserService.deleteById(tUserId);
        return SUCCESS_TIP;
    }

    /**
     * 修改Consumer
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(TUser tUser) {
        tUserService.updateById(tUser);
        return SUCCESS_TIP;
    }

    /**
     * Consumer详情
     */
    @RequestMapping(value = "/detail/{tUserId}")
    @ResponseBody
    public Object detail(@PathVariable("tUserId") Integer tUserId) {
        return tUserService.selectById(tUserId);
    }
}
