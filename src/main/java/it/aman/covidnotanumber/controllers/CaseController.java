package it.aman.covidnotanumber.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiParam;
import it.aman.covidnotanumber.annotations.EthLoggable;
import it.aman.covidnotanumber.services.ICaseService;
import it.aman.covidnotanumber.util.exception.EthException;
import it.aman.wearenotnumbers.swagger.api.CaseApi;
import it.aman.wearenotnumbers.swagger.model.RequestSaveCase;
import it.aman.wearenotnumbers.swagger.model.ResponseBase;
import it.aman.wearenotnumbers.swagger.model.ResponseCaseList;
import it.aman.wearenotnumbers.swagger.model.ResponseCaseSingle;

@RestController
public class CaseController extends AbstractController implements CaseApi {

    @Autowired
    private ICaseService caseService;
    
    @Override
    @EthLoggable
    public ResponseEntity<ResponseBase> addCase(
            @ApiParam(value = ""  )  @Valid @RequestBody RequestSaveCase data) 
    {

        Class<ResponseBase> responseClass = ResponseBase.class;
        ResponseBase response = null;
        HttpStatus status = HttpStatus.OK;
        try{
            caseService.saveCase(data);
            response = fillSuccessResponse(new ResponseBase());
        } catch(EthException ex) {
            status = ex.getHttpCode();
            response = fillFailResponseEthException(responseClass, ex);
        } catch (Exception ex) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            response = fillFailResponseGeneric(responseClass);
        }
        
        return new ResponseEntity<>(response, status);
    }

    @Override
    public ResponseEntity<ResponseCaseList> getAllCases(@Valid Integer page) {
        // TODO Auto-generated method stub
        return CaseApi.super.getAllCases(page);
    }

    @Override
    public ResponseEntity<ResponseCaseSingle> getCaseById(Integer id) {
        // TODO Auto-generated method stub
        return CaseApi.super.getCaseById(id);
    }

}
