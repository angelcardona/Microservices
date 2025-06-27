package com.marketplace.users.infrastructure.adapters.input.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.marketplace.users.domain.User;
import com.marketplace.users.infrastructure.adapters.input.model.request.UserCreateRequest;
import com.marketplace.users.infrastructure.adapters.input.model.response.UserResponse;


@Mapper(componentModel = "spring")
public interface UserRestMapper {

    UserResponse toUserResponse(User user);
    User toDomainUser(UserCreateRequest request);

    List <UserResponse> toUserResponseList(List<User> users);

}
