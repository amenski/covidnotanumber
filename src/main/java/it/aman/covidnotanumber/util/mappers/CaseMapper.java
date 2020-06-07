package it.aman.covidnotanumber.util.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import it.aman.covidnotanumber.dal.entity.Deceased;
import it.aman.wearenotnumbers.swagger.model.ModelCase;
import it.aman.wearenotnumbers.swagger.model.RequestSaveCase;

@Mapper
public interface CaseMapper {

    CaseMapper INSTANCE = Mappers.getMapper(CaseMapper.class);

    ModelCase entityToModelMapper(Deceased data);

    Deceased modelToEntityMapper(ModelCase data);
    
    Deceased modelToEntityMapper(RequestSaveCase data);

}
