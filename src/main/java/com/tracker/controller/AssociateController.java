package com.tracker.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tracker.exception.BusinessException;
import com.tracker.model.AssociateModel;
import com.tracker.model.SkillsModel;
import com.tracker.service.intf.IAssociateService;
import com.tracker.service.intf.ISkillService;

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
		System.out.println("*****************************************");
		System.out.println("associateModel : " + associateModel +" file : "+ file.getName());
		System.out.println("*****************************************");
		String responseString = null;
		try {
			responseString = associateService.addAssociate(associateModel,file);
		}catch(Exception e) {
			throw new BusinessException(e.toString());
		}
		return responseString;
		
	}

}
