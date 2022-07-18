package com.CamperLand.CT.mapper;

import com.CamperLand.CT.logic.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User userInfo(String id);
}
