package com.hotsix.magazine;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.hotsix.magazine.MagazineModel;

public class MagazineValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz){
		return MagazineModel.class.isAssignableFrom(clazz);
		
	}
	@Override
	public void validate(Object target,Errors errors){
		MagazineModel magazineModel=(MagazineModel) target;
		
		if(magazineModel.getSubject()==null||magazineModel.getSubject().trim().isEmpty()){
			errors.rejectValue("subject", "subject");
		}
		if(magazineModel.getSubject2()==null||magazineModel.getSubject2().trim().isEmpty()){
			errors.rejectValue("subject2", "subject2");
		}
		if(magazineModel.getContent()==null||magazineModel.getContent().trim().isEmpty()){
			errors.rejectValue("content", "content");
		}
		if(magazineModel.getImage1()==null||magazineModel.getImage1().trim().isEmpty()){
			errors.rejectValue("image1", "image1");
		}
		if(magazineModel.getImage2()==null||magazineModel.getImage2().trim().isEmpty()){
			errors.rejectValue("image2", "image2");
		}
	}

}
