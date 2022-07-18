package com.CamperLand.CT.logic;

import com.CamperLand.CT.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public User userInfo(String id) {
        return userMapper.userInfo(id);
    }
}
