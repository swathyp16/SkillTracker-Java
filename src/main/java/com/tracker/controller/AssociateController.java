package com.tracker.controller;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tracker.exception.BusinessException;
import com.tracker.model.AssociateModel;
import com.tracker.service.intf.IAssociateService;

// TODO: Auto-generated Javadoc
/**
 * The Class AssociateController.
 */
@CrossOrigin
@RestController
public class AssociateController {
	

	/** The associate service. */
	@Autowired
	private IAssociateService associateService;
	
	/**
	 * Adds the associate.
	 *
	 * @param associateData the associate data
	 * @param file the file
	 * @return the string
	 * @throws BusinessException the business exception
	 */
	@RequestMapping(value="/addAssociate",method=RequestMethod.POST)
	public String addAssociate(@RequestParam(value="data",required=true) String associateData,@RequestParam(value="file",required=false) MultipartFile file) throws BusinessException {
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
	
	/**
	 * Gets the associate pic.
	 *
	 * @param id the id
	 * @return the associate pic
	 * @throws BusinessException the business exception
	 */
	@RequestMapping(value="/getAssociatePic/{id}",method=RequestMethod.GET, produces = {MediaType.IMAGE_JPEG_VALUE , MediaType.IMAGE_PNG_VALUE})
	public byte[] getAssociatePic(@PathVariable int id) throws BusinessException {
		return associateService.getAssociatePicture(id);
		
	}
		
	
	/**
	 * View all associates.
	 *
	 * @return the list
	 * @throws BusinessException the business exception
	 */
	@RequestMapping(value="/viewAllAssociates",method=RequestMethod.GET)
	public List<AssociateModel> viewAllAssociates() throws BusinessException {
		List<AssociateModel> associatesList = associateService.fetchAllAssociateDetails();
		return associatesList;
		
	}

	
	/**
	 * Delete associate.
	 *
	 * @param associateId the associate id
	 * @return the string
	 * @throws BusinessException the business exception
	 */
	@RequestMapping(value="/deleteAssociate/{associateId}",method=RequestMethod.GET)
	public String deleteAssociate(@PathVariable int associateId) throws BusinessException {
		return associateService.deleteAssociate(associateId);
		
	}
	
	
	

}
