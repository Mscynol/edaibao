package com.alexis.edaibao.core.service.impl;

import com.alexis.edaibao.core.pojo.entity.UserAccount;
import com.alexis.edaibao.core.mapper.UserAccountMapper;
import com.alexis.edaibao.core.service.UserAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户账户 服务实现类
 * </p>
 *
 * @author cc-zj
 * @since 2022-04-12
 */
@Service
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements UserAccountService {

}
