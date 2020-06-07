package it.aman.covidnotanumber.services;

import javax.validation.Valid;

import it.aman.covidnotanumber.util.exception.EthException;
import it.aman.wearenotnumbers.swagger.model.ModelCase;
import it.aman.wearenotnumbers.swagger.model.ModelCaseList;
import it.aman.wearenotnumbers.swagger.model.RequestSaveCase;

public interface ICaseService {

    public void saveCase(RequestSaveCase caseItem) throws EthException;

    public ModelCase getCaseById(Integer caseId) throws EthException;

    public ModelCaseList getAllCases(Integer page) throws EthException;
}
