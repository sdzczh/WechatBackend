package cn.stylefeng.guns.modular.Consumer.service.impl;

import cn.stylefeng.guns.modular.system.model.TUser;
import cn.stylefeng.guns.modular.system.dao.TUserMapper;
import cn.stylefeng.guns.modular.Consumer.service.ITUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhaohe
 * @since 2019-03-18
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

}
