package com.bridgelabz.lmscandidate.service;

import com.bridgelabz.lmscandidate.dto.CandidateDTO;
import com.bridgelabz.lmscandidate.model.CandidateModel;
import com.bridgelabz.lmscandidate.util.Response;

import java.util.List;

public interface ICandidateService {

    Response addCandidate(String token, CandidateDTO candidateDTO, Long techStackId);

    List<CandidateModel> getAllCandidates(String token);

    Response updateCandidateDetails(String token, CandidateDTO candidateDTO, Long id, Long techStackId);

    Response deleteCandidate(String token, Long id);

    List<CandidateModel> getCandidatesByStatus(String status, String s);

    Response changeStatus(String status, Long id, String token);

    Long getCountByStatus(String token, String status);

}
