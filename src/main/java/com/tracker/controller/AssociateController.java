package com.tracker.controller;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tracker.exception.BusinessException;
import com.tracker.model.AssociateModel;
import com.tracker.service.intf.IAssociateService;

@CrossOrigin
@RestController
public class AssociateController {
	

	@Autowired
	private IAssociateService associateService;
	
	@RequestMapping(value="/addAssociate",method=RequestMethod.POST)
	public String addSkill(@RequestParam(value="data",required=true) String associateData,@RequestParam(value="file",required=true) MultipartFile file) throws BusinessException {
		ObjectMapper objectMapper = new ObjectMapper();
		AssociateModel associateModel;
		try {
			associateModel = objectMapper.readValue(associateData, AssociateModel.class);
		} catch (IOException e1) {
			throw new BusinessException(e1.toString());
		}
		String responseString = null;
		try {
			responseString = associateService.addAssociate(associateModel,file);
		}catch(Exception e) {
			throw new BusinessException(e.toString());
		}
		return responseString;
		
	}
	
	@RequestMapping(value="/getAssociatePic/{id}",method=RequestMethod.GET, produces = {MediaType.IMAGE_JPEG_VALUE , MediaType.IMAGE_PNG_VALUE})
	public byte[] getAssociatePic(@PathVariable int id) throws BusinessException {
		return associateService.getAssociatePicture(id);
		
	}
		
	
	@RequestMapping(value="/viewAllAssociates",method=RequestMethod.GET)
	public List<AssociateModel> viewAllAssociates() throws BusinessException {
		List<AssociateModel> associatesList = associateService.fetchAllAssociateDetails();
		return associatesList;
		
	}
	
	@RequestMapping(value="/deleteAssociate",method=RequestMethod.POST)
	public String deleteAssociate(@RequestBody AssociateModel associateModel) throws BusinessException {
		return associateService.deleteAssociate(associateModel.getAssociateId());
		
	}
	
	
	

}
