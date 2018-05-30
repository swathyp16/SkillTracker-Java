package com.tracker.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.tracker.constants.CommonConstants;
import com.tracker.dao.AssociateDao;
import com.tracker.dao.SkillsDao;
import com.tracker.entity.AssociateEntity;
import com.tracker.entity.AssociateSkillsEntity;
import com.tracker.entity.SkillsEntity;
import com.tracker.exception.BusinessException;
import com.tracker.model.AssociateModel;
import com.tracker.model.SkillsModel;
import com.tracker.service.intf.IAssociateService;

@Component
public class AssociateServiceImpl implements IAssociateService {

	@Autowired
	private AssociateDao associateDao;
	
	@Autowired
	private SkillsDao skillsDao;

	public String addAssociate(AssociateModel associateModel,MultipartFile file) throws BusinessException {
		AssociateEntity associateEntity = new AssociateEntity();
		AssociateSkillsEntity associateSkillsEntity = new AssociateSkillsEntity();
		setDataToAssociateEntity(associateEntity, associateModel,file);
		associateDao.addAssociate(associateEntity);
		saveAssociateSkills(associateSkillsEntity,associateModel);
		return CommonConstants.SUCCESS_STRING; 
		
	}
	
	public byte[] getAssociatePicture(int id) {
		return associateDao.getPicUploaded(id);
	}
	
	public List<AssociateModel> fetchAllAssociateDetails() {
		List<AssociateEntity> associateEntities = associateDao.fetchAllAssociateDetails();
		List<AssociateModel> associatesList = new ArrayList<AssociateModel>();
		AssociateModel associateModel = null;
		for(AssociateEntity associateEntity: associateEntities) {
			associateModel = new AssociateModel();
			associateModel.setAssociateId(associateEntity.getAssociateId());
			associateModel.setName(associateEntity.getName());
			associateModel.setEmail(associateEntity.getEmail());
			associateModel.setMobileNum(associateEntity.getMobile());
			associateModel.setRemark(associateEntity.getRemark());
			associateModel.setStrength(associateEntity.getStrength());
			associateModel.setWeakness(associateEntity.getWeakness());
			associateModel.setStatusGreen(associateEntity.isStatusGreen());
			associateModel.setStatusBlue(associateEntity.isStatusBlue());
			associateModel.setStatusRed(associateEntity.isStatusRed());
			associateModel.setLevel1(associateEntity.isLevel1());
			associateModel.setLevel2(associateEntity.isLevel2());
			associateModel.setLevel3(associateEntity.isLevel3());
			mapAssociateSkillsToModel(associateModel,associateEntity);
			associatesList.add(associateModel);
		}
		return associatesList;
	}
	
	
	private void mapAssociateSkillsToModel(AssociateModel associateModel,AssociateEntity associateEntity) {
		List<AssociateSkillsEntity> associateSkillsEntities = associateDao.fetchAssociateSkills();
		List<SkillsModel> associateSkillList = new ArrayList<SkillsModel>();
		for(AssociateSkillsEntity associateSkillsEntity: associateSkillsEntities) {
			if(associateSkillsEntity.getAssociateId() == associateEntity.getAssociateId()) {
				List<SkillsEntity> skillList = skillsDao.fetchAssociateSkillNamesById(associateSkillsEntity.getSkillId());
				mapAssociateSkills(skillList,associateSkillList);
			}
		}
	}
	
	private void mapAssociateSkills(List<SkillsEntity> skillList,List<SkillsModel> associateSkillList) {
		SkillsModel skillsModel = null;
		for(SkillsEntity skillsEntity:skillList) {
			skillsModel = new SkillsModel();
			skillsModel.setSkillId(skillsEntity.getSkillId());
			skillsModel.setSkillName(skillsEntity.getSkillName());
			associateSkillList.add(skillsModel);
		}
	}
	
	private void setDataToAssociateEntity(AssociateEntity associateEntity,AssociateModel associateModel,MultipartFile file) throws BusinessException {
		associateEntity.setAssociateId(associateModel.getAssociateId());
		associateEntity.setName(associateModel.getName());
		associateEntity.setEmail(associateModel.getEmail());
		associateEntity.setMobile(associateModel.getMobileNum());
		associateEntity.setRemark(associateModel.getRemark());
		associateEntity.setStrength(associateModel.getStrength());
		associateEntity.setWeakness(associateModel.getWeakness());
		associateEntity.setStatusGreen(associateModel.isStatusGreen());
		associateEntity.setStatusBlue(associateModel.isStatusBlue());
		associateEntity.setStatusRed(associateModel.isStatusRed());
		associateEntity.setLevel1(associateModel.isLevel1());
		associateEntity.setLevel2(associateModel.isLevel2());
		associateEntity.setLevel3(associateModel.isLevel3());
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
