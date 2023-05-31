package fr.mapper;

import fr.dtoin.*;
import fr.dtoout.*;
import fr.viewmodel.StoreOrderForm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ModelMapperCommon {
    ModelMapperCommon INSTANCE = Mappers.getMapper(ModelMapperCommon.class);
    CardIn convert(CardOut user);
    CardOut convert(CardIn user);

    PartyIn convert(PartyOut user);
    PartyOut convert(PartyIn user);

    UserIn convert(UserOut user);
    UserOut convert(UserIn user);


    StoreOrderOut convert(StoreOrderIn user);
    StoreOrderIn convert(StoreOrderOut user);



    StoreTransactionOut convert(StoreTransactionIn user);
    StoreTransactionIn convert(StoreTransactionOut user);
}