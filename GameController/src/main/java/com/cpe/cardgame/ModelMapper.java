package com.cpe.cardgame;

import com.cpe.cardgame.model.PlayParty;
import fr.dtoin.CardIn;
import fr.dtoin.PartyIn;
import fr.dtoin.UserIn;
import fr.dtoout.CardOut;
import fr.dtoout.PartyOut;
import fr.dtoout.UserOut;
import fr.viewmodel.CardForm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ModelMapper {
    ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);
    PlayParty convert(PartyIn user);

    PlayParty convert(PartyOut user);

    PartyIn convertToIn(PlayParty user);

    PartyOut convertToOut(PlayParty user);
}