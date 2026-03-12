package com.linguarise.user.infrastructure.mapper;

import com.linguarise.user.application.dto.UserProfileResponse;
import com.linguarise.user.domain.model.User;
import com.linguarise.user.infrastructure.entity.UserJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toDomain(UserJpaEntity entity);
    UserJpaEntity toEntity(User user);
    UserProfileResponse toResponse(User user);
}
