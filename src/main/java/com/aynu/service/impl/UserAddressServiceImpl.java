package com.aynu.service.impl;

import com.aynu.entity.User;
import com.aynu.entity.UserAddress;
import com.aynu.mapper.UserAddressMapper;
import com.aynu.service.UserAddressService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cat
 * @since 2021-05-15
 */
@Service
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements UserAddressService {
    @Autowired
    private UserAddressMapper userAddressMapper;

    @Override
    public boolean save(User user, UserAddress userAddress) {
        if (userAddress!=null){
            userAddress.setIsdefault(1);
            userAddress.setUserId(user.getId());
            //修改默认地址为0
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("isdefault",1);
            UserAddress old = userAddressMapper.selectOne(wrapper);
            old.setIsdefault(0);
            userAddressMapper.updateById(old);
            userAddressMapper.insert(userAddress);
            return true;
        }
        return false;

    }
}
