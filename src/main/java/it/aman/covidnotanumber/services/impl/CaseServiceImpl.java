package it.aman.covidnotanumber.services.impl;

import java.util.List;
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
import it.aman.wearenotnumbers.swagger.model.ModelCase;
import it.aman.wearenotnumbers.swagger.model.ModelCaseList;
import it.aman.wearenotnumbers.swagger.model.RequestSaveCase;

@Service
public class CaseServiceImpl implements ICaseService {

    @Autowired
    private DeceasedCaseRepository deceaseCaseRepository;

    @Override
    @EthLoggable
    public void saveCase(RequestSaveCase caseItem) throws EthException {
        try {
            if (Objects.isNull(caseItem) || (Integer.signum(caseItem.getAge()) != 1))
                throw EthExceptionEnums.VALIDATION_EXCEPTION.get();

            Deceased caseData = CaseMapper.INSTANCE.modelToEntityMapper(caseItem);
            deceaseCaseRepository.save(caseData);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    @EthLoggable
    public ModelCase getCaseById(Integer caseId) throws EthException {
        try {
            if (Objects.isNull(caseId) || (Integer.signum(caseId) != 1))
                throw EthExceptionEnums.VALIDATION_EXCEPTION.get();

            Deceased caseData = deceaseCaseRepository.findById(caseId).orElseThrow(EthExceptionEnums.CASE_NOT_FOUND);

            return CaseMapper.INSTANCE.entityToModelMapper(caseData);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    @EthLoggable
    public ModelCaseList getAllCases(Integer page) throws EthException {
        try {
            if (Objects.isNull(page) || (Integer.signum(page) != 1))
                throw EthExceptionEnums.VALIDATION_EXCEPTION.get().message("Invalid page number found.");
            
            ModelCaseList caseList = new ModelCaseList();
            List<Deceased> caseDataList = deceaseCaseRepository.findAll();
            for(Deceased deceased : caseDataList) {
                ModelCase model = CaseMapper.INSTANCE.entityToModelMapper(deceased);
                caseList.addCasesItem(model);
            }
            return caseList;
        } catch (Exception ex) {
            throw ex;
        }
    }

}
