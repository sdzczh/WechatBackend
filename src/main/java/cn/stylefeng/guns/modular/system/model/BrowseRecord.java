package cn.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhoahe
 * @since 2019-03-20
 */
@TableName("browse_record")
public class BrowseRecord extends Model<BrowseRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 广告ID
     */
    @TableField("msg_id")
    private Integer msgId;
    /**
     * 用户open_id
     */
    @TableField("user_open_id")
    private String userOpenId;
    /**
     * 邀请人open_id
     */
    @TableField("invite_open_id")
    private String inviteOpenId;
    /**
     * 点击数量
     */
    private Integer number;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public String getUserOpenId() {
        return userOpenId;
    }

    public void setUserOpenId(String userOpenId) {
        this.userOpenId = userOpenId;
    }

    public String getInviteOpenId() {
        return inviteOpenId;
    }

    public void setInviteOpenId(String inviteOpenId) {
        this.inviteOpenId = inviteOpenId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "BrowseRecord{" +
        ", id=" + id +
        ", msgId=" + msgId +
        ", userOpenId=" + userOpenId +
        ", inviteOpenId=" + inviteOpenId +
        ", number=" + number +
        ", createTime=" + createTime +
        "}";
    }
}
