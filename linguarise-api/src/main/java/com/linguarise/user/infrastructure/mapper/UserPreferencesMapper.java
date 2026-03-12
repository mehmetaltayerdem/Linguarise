package com.linguarise.user.infrastructure.mapper;

import com.linguarise.user.application.dto.UserPreferencesResponse;
import com.linguarise.user.domain.model.UserPreferences;
import com.linguarise.user.infrastructure.entity.UserPreferencesJpaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserPreferencesMapper {

    @Mapping(target = "interests", expression = "java(entity.getInterests() != null ? java.util.Arrays.asList(entity.getInterests()) : new java.util.ArrayList<>())")
    UserPreferences toDomain(UserPreferencesJpaEntity entity);

    @Mapping(target = "interests", expression = "java(domain.getInterests() != null ? domain.getInterests().toArray(new String[0]) : new String[0])")
    UserPreferencesJpaEntity toEntity(UserPreferences domain);

    UserPreferencesResponse toResponse(UserPreferences domain);
}