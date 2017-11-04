package com.hotsix.movie;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.hotsix.magazine.MagazineModel;

@Service
public class MovieService implements MovieDAO {

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public boolean movieWrite(MovieModel movieModel) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("movie.movieWrite", movieModel);
		return true;
	}

	@Override
	public int getMagazine_NO_SEQ() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("movie.getMovie_NO_SEQ");
	}

	@Override
	public List<MovieModel> movieList() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("movie.selectMovie_ALL");
	}

	@Override
	public List<MovieModel> movieList_one(int movie_no) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("movie.selectMovie_one",movie_no);
	}
	
	@Override
	public MovieModel movieList_one_(int movie_no) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("movie.selectMovie_one",movie_no);
	}

	@Override
	public boolean movieDelete(int no) {
		// TODO Auto-generated method stub
		
		sqlSessionTemplate.delete("movie.movieDelete",no);
		
		return true;
	}

	@Override
	public boolean movieUpdate(MovieModel movieModel) {
		// TODO Auto-generated method stub

		sqlSessionTemplate.update("movie.movieUpdate",movieModel);
		return true;
	}

	@Override
	public MovieModel updatemovieScore(MovieModel movieModel) {
		return sqlSessionTemplate.selectOne("movie.updateMovieScore", movieModel);
	}

	@Override
	public MovieGradeModel gradecheck(MovieGradeModel movieGradeModel) {
		return sqlSessionTemplate.selectOne("movie.gradecheck", movieGradeModel);
	}

	@Override
	public boolean insertgradecheck(MovieGradeModel movieGradeModel) {
		sqlSessionTemplate.insert("movie.insertgradecheck",movieGradeModel);
		return true;
	}
	
	
	

}
