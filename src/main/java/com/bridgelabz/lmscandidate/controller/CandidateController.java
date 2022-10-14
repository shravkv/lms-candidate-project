package com.bridgelabz.lmscandidate.controller;

import com.bridgelabz.lmscandidate.dto.CandidateDTO;
import com.bridgelabz.lmscandidate.model.CandidateModel;
import com.bridgelabz.lmscandidate.service.ICandidateService;
import com.bridgelabz.lmscandidate.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/candidates")
public class CandidateController {

    @Autowired
    ICandidateService candidateService;

    /*
     * Purpose : Create Candidate Details
     * @author : Sravan Kumar
     * @Param :  token,techStackId and candidateDTO
     * */

    @PostMapping("/addCandidate")
    public ResponseEntity<Response> addCandidate(@RequestHeader String token,
                                                 @Valid @RequestBody CandidateDTO candidateDTO,
                                                 @RequestParam Long techStackId) {
        Response response = candidateService.addCandidate(token, candidateDTO, techStackId);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    /*
     * Purpose : Retrieve all Candidates Details
     * @author : Sravan Kumar
     * @Param :  token
     * */


    @GetMapping("/getAllCandidates")
    public ResponseEntity<List<?>> getAllCandidates(@RequestHeader String token) {
        List<CandidateModel> response = candidateService.getAllCandidates(token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /*
     * Purpose : Update Existing Candidate Details
     * @author : Sravan Kumar
     * @Param :  token,candidateDTO,id and techStackId
     * */


    @PutMapping("/updateCandidateDetails/{id}")
    public ResponseEntity<Response> updateCandidateDetails(@RequestHeader String token,
                                                           @Valid @RequestBody CandidateDTO candidateDTO,
                                                           @PathVariable Long id,
                                                           @RequestParam Long techStackId) {
        Response response = candidateService.updateCandidateDetails(token, candidateDTO, id, techStackId);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    /*
     * Purpose : Delete Existing Candidate Details
     * @author : Sravan Kumar
     * @Param : token and id
     * */


    @DeleteMapping("/deleteCandidateDetails/{id}")
    public ResponseEntity<Response> deleteCandidate(@RequestHeader String token,
                                                    @PathVariable Long id) {
        Response response = candidateService.deleteCandidate(token, id);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    /*
     * Purpose : Retrieve the Candidate By Status
     * @author : Sravan Kumar
     * @Param :  token and status
     * */


    @GetMapping("/getCandidatesByStatus")
    public ResponseEntity<List<?>> getCandidatesByStatus(@RequestHeader String token,
                                                         @RequestParam String status) {
        List<CandidateModel> response = candidateService.getCandidatesByStatus(token, status);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /*
     * Purpose : Change the Candidate Status
     * @author : Sravan Kumar
     * @Param :  id,token and status
     * */


    @PutMapping("/changeCandidateStatus/{id}")
    public ResponseEntity<Response> changeCandidateStatus(@RequestHeader String token,
                                                          @PathVariable Long id,
                                                          @RequestParam String status) {
        Response response = candidateService.changeStatus(token, id, status);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    /*
     * Purpose : Retrieve the Count By Candidate Status
     * @author : Sravan Kumar
     * @Param :  token and status
     * */



    @GetMapping("/getCountByStatus")
    public ResponseEntity<Long> getCountByStatus(@RequestHeader String token,
                                                 @RequestParam String status) {
        Long response = candidateService.getCountByStatus(token, status);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
