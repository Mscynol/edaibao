package com.alexis.edaibao.core.service.impl;

import com.alexis.edaibao.core.pojo.entity.UserLoginRecord;
import com.alexis.edaibao.core.mapper.UserLoginRecordMapper;
import com.alexis.edaibao.core.service.UserLoginRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户登录记录表 服务实现类
 * </p>
 *
 * @author cc-zj
 * @since 2022-04-12
 */
@Service
public class UserLoginRecordServiceImpl extends ServiceImpl<UserLoginRecordMapper, UserLoginRecord> implements UserLoginRecordService {

}
