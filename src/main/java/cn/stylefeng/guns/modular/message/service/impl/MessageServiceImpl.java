package cn.stylefeng.guns.modular.message.service.impl;

import cn.stylefeng.guns.modular.system.model.Message;
import cn.stylefeng.guns.modular.system.dao.MessageMapper;
import cn.stylefeng.guns.modular.message.service.IMessageService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhaohe
 * @since 2019-03-19
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements IMessageService {

}
