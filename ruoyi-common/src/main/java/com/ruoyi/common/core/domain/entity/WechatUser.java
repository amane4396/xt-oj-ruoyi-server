package com.ruoyi.common.core.domain.entity;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

public class WechatUser extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 自增主键 */
//    @TableId
    private Long id;

    /** 用户的唯一标识 */
    @Excel(name = "用户的唯一标识")
    private String openid;

    /** 微信会话秘钥 */
//    @TableField(exist = false)
    private String sessionKey;

    /** 公众号的唯一标识 */
    @Excel(name = "公众号的唯一标识")
    private String unionid;

    /** 昵称 */
    @Excel(name = "昵称")
    private String nickname;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phonenumber;

    /** 性别，0-未知 1-男性，2-女性 */
    @Excel(name = "性别，0-未知 1-男性，2-女性")
    private Integer gender;

    /** 地区 */
    @Excel(name = "地区")
    private String region;

    /** 用户头像URL */
    @Excel(name = "用户头像URL")
    private String avatarUrl;
    // 后面跟数据库设计一致
}
