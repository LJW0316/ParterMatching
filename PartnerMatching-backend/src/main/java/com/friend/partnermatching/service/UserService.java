package com.friend.partnermatching.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.friend.partnermatching.model.domain.User;
import com.friend.partnermatching.model.vo.UserVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户服务
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @return 新用户 id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * 用户登录
     * @param userAccount  用户账户
     * @param userPassword 用户密码
     * @param request
     * @return 脱敏后的用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏
     * @param originUser
     * @return
     */
    User getSafetyUser(User originUser);


    /**
     * 用户注销
     * @param request
     * @return
     */
    int userLogout(HttpServletRequest request);

    /**
     * 根据标签查询用户
     * @param tagList 用户要拥有的标签
     * @return
     */
    List<User> searchUserByTags(List<String> tagList);

    /**
     * 更新用户信息
     * @param user 用户信息
     * @return
     */
    int updateUser(User user, User loginUser);

    /**
     * 获取当前登录的用户信息
     * @param request
     * @return 登录用户
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * 是否为管理员
     * @param request
     * @return
     */
    boolean isAdmin(HttpServletRequest request);

    boolean isAdmin(User user);

    /**
     * 获取匹配用户
     * @param num 匹配的个数
     * @param loginUser 登录用户
     * @return 匹配用户列表
     */
    List<UserVo> matchUsers(long num, User loginUser);
}
