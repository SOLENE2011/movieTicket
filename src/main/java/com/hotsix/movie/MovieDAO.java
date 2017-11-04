package com.hotsix.movie;

import java.util.List;

import com.hotsix.magazine.MagazineModel;

public interface MovieDAO {

	// movieInsert
	boolean movieWrite(MovieModel movieModel);
	
	int getMagazine_NO_SEQ();
	
	List<MovieModel> movieList();
	
	List<MovieModel> movieList_one(int movie_no);
	
	boolean movieDelete(int no);
	
	boolean movieUpdate(MovieModel movieModel);
	
	MovieModel movieList_one_(int movie_no);
	
	//영화 평점 업데이트
	public MovieModel updatemovieScore(MovieModel movieModel);
	
	//평점입력 중복체크 정보 꺼내오기
	public MovieGradeModel gradecheck(MovieGradeModel movieGradeModel);
	
	//평점입력 중복체크 정보 넣기
	public boolean insertgradecheck(MovieGradeModel movieGradeModel);
	
}
