package com.cpe.cardgame;

import fr.dtoin.UserIn;
import fr.dtoout.UserOut;
import fr.model.UserGame;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ModelMapper {
    ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);
    UserGame convert(UserIn user);
    UserGame convert(UserOut user);
    UserIn convertToIn(UserGame user);
    UserOut convertToOut(UserGame user);
}