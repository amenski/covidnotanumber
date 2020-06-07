package it.aman.covidnotanumber.services.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.aman.covidnotanumber.annotations.EthLoggable;
import it.aman.covidnotanumber.dal.entity.Deceased;
import it.aman.covidnotanumber.dal.repository.DeceasedCaseRepository;
import it.aman.covidnotanumber.services.ICaseService;
import it.aman.covidnotanumber.util.exception.EthException;
import it.aman.covidnotanumber.util.exception.EthExceptionEnums;
import it.aman.covidnotanumber.util.mappers.CaseMapper;
import it.aman.wearenotnumbers.swagger.model.RequestSaveCase;

@Service
public class CaseServiceImpl implements ICaseService {

    @Autowired
    private DeceasedCaseRepository deceaseCaseRepository;

    @Override
    @EthLoggable
    public void saveCase(RequestSaveCase caseItem) throws EthException {
        try {
            if(Objects.isNull(caseItem) || (Integer.signum(caseItem.getAge()) != 1))
                throw EthExceptionEnums.VALIDATION_EXCEPTION.get();
            
            Deceased caseData = CaseMapper.INSTANCE.modelToEntityMapper(caseItem);
            deceaseCaseRepository.save(caseData);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    @EthLoggable
    public void getCaseById(Integer caseId) throws EthException {

    }

    @Override
    @EthLoggable
    public void getAllCases() throws EthException {

    }

}
