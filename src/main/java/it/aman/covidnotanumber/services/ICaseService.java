package it.aman.covidnotanumber.services;

import it.aman.covidnotanumber.util.exception.EthException;
import it.aman.wearenotnumbers.swagger.model.RequestSaveCase;

public interface ICaseService {

    public void saveCase(RequestSaveCase caseItem) throws EthException;

    public void getCaseById(Integer caseId) throws EthException;

    public void getAllCases() throws EthException;
}
