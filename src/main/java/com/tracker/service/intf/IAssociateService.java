package com.tracker.service.intf;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.tracker.exception.BusinessException;
import com.tracker.model.AssociateModel;

// TODO: Auto-generated Javadoc
/**
 * The Interface IAssociateService.
 */
public interface IAssociateService {

	/**
	 * Adds the associate.
	 *
	 * @param associateModel the associate model
	 * @param file the file
	 * @return the string
	 * @throws BusinessException the business exception
	 */
	String addAssociate(AssociateModel associateModel,MultipartFile file) throws BusinessException;
	
	/**
	 * Gets the associate picture.
	 *
	 * @param id the id
	 * @return the associate picture
	 */
	byte[] getAssociatePicture(int id);
	
	/**
	 * Fetch all associate details.
	 *
	 * @return the list
	 */
	List<AssociateModel> fetchAllAssociateDetails();
	
	/**
	 * Delete associate.
	 *
	 * @param id the id
	 * @return the string
	 */
	String deleteAssociate(int id);
}
