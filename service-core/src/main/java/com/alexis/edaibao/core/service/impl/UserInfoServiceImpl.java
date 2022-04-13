package com.alexis.edaibao.core.service.impl;

import com.alexis.edaibao.core.pojo.entity.UserInfo;
import com.alexis.edaibao.core.mapper.UserInfoMapper;
import com.alexis.edaibao.core.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户基本信息 服务实现类
 * </p>
 *
 * @author cc-zj
 * @since 2022-04-12
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
