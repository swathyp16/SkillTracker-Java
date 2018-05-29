package com.tracker.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.tracker.constants.CommonConstants;
import com.tracker.dao.AssociateDao;
import com.tracker.entity.AssociateEntity;
import com.tracker.entity.AssociateSkillsEntity;
import com.tracker.exception.BusinessException;
import com.tracker.model.AssociateModel;
import com.tracker.model.SkillsModel;
import com.tracker.service.intf.IAssociateService;

@Component
public class AssociateServiceImpl implements IAssociateService {

	@Autowired
	private AssociateDao associateDao;

	public String addAssociate(AssociateModel associateModel,MultipartFile file) throws BusinessException {
		AssociateEntity associateEntity = new AssociateEntity();
		AssociateSkillsEntity associateSkillsEntity = new AssociateSkillsEntity();
		setDataToAssociateEntity(associateEntity, associateModel,file);
		associateDao.addAssociate(associateEntity);
		saveAssociateSkills(associateSkillsEntity,associateModel);
		return CommonConstants.SUCCESS_STRING; 
		
	}
	
	private void setDataToAssociateEntity(AssociateEntity associateEntity,AssociateModel associateModel,MultipartFile file) throws BusinessException {
		associateEntity.setAssociateId(associateModel.getAssociateId());
		associateEntity.setName(associateModel.getName());
		associateEntity.setEmail(associateModel.getEmail());
		associateEntity.setMobile(associateModel.getMobileNum());
		associateEntity.setRemark(associateModel.getRemark());
		associateEntity.setStrength(associateModel.getStrength());
		associateEntity.setWeakness(associateModel.getWeakness());
		byte[] picInBytes;
		try {
			picInBytes = convertMultipartfileToBytes(file);
		} catch (IOException e) {
			throw new BusinessException(e.toString());
		}
		associateEntity.setPic(picInBytes);
	}
	
	private byte[] convertMultipartfileToBytes(MultipartFile file) throws IOException {
		try {
			return  file.getBytes();
		} catch (IOException e) {
			throw new IOException(e.toString());
		}
	}
	
	private void saveAssociateSkills(AssociateSkillsEntity associateSkillsEntity,AssociateModel associateModel) {
		for(SkillsModel skillModel :associateModel.getAssociateSkills()) {
			associateSkillsEntity.setAssociateId(associateModel.getAssociateId());
			associateSkillsEntity.setSkillId(skillModel.getSkillId());
			associateDao.addAssociateSkills(associateSkillsEntity);
		}
	}
}
