package com.hotsix.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.hotsix.movie.MovieModel;

public class MovieValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz){
		return MovieModel.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target,Errors errors){
		
		MovieModel movieModel=(MovieModel) target;
		
		if(movieModel.getMovie_name()==null||movieModel.getMovie_name().trim().isEmpty()){
			errors.rejectValue("movie_name", "movie_name");
		}
		if(movieModel.getDirector()==null||movieModel.getDirector().trim().isEmpty()){
			errors.rejectValue("director", "director");
		}
		if(movieModel.getActor()==null||movieModel.getActor().trim().isEmpty()){
			errors.rejectValue("actor", "actor");
		}
		if(movieModel.getShow_date()==null){
			errors.rejectValue("show_date", "show_date");
		}
		if(movieModel.getStory()==null||movieModel.getStory().trim().isEmpty()){
			errors.rejectValue("story", "story");
		}
		if(movieModel.getSummary()==null||movieModel.getSummary().trim().isEmpty()){
			errors.rejectValue("summary", "summary");
		}
		
		
		/*
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "movie_name", "movie_name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "director", "director");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "actor", "actor");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "show_date", "show_date");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "story", "story");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "poster", "poster");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "summary", "summary");
		*/
	}

}
