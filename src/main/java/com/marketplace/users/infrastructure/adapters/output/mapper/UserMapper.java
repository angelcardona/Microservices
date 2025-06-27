package com.marketplace.users.infrastructure.adapters.output.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.marketplace.users.domain.User;
import com.marketplace.users.infrastructure.adapters.output.entity.UserEntity;

@Mapper(componentModel = "spring")

public interface UserMapper {

   UserEntity toUserEntity(User user);

   User toUser(UserEntity userEntity);

   List<User> toUserList(List<UserEntity> userEntities);

}
