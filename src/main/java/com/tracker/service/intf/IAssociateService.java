package com.tracker.service.intf;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.tracker.exception.BusinessException;
import com.tracker.model.AssociateModel;

public interface IAssociateService {

	String addAssociate(AssociateModel associateModel,MultipartFile file) throws BusinessException;
	
	byte[] getAssociatePicture(int id);
	
	List<AssociateModel> fetchAllAssociateDetails();
}
