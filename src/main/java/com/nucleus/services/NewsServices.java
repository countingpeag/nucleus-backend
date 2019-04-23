package com.nucleus.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.nucleus.dao.NewsDAO;
import com.nucleus.models.News;

@Path("/news")
public class NewsServices {

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public List<News> getNews(@FormParam("date") String date){
		
		System.out.println(date);
		List<News> news = new ArrayList<News>();
		
		return news;
	}
	
	@POST
	@Path("/add/{token}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addNews(News news, @PathParam("token") String token){
		
		JavaJSONWebTokens jwt = new JavaJSONWebTokens();
		NewsDAO newsDAO = new NewsDAO();
		
		if(jwt.parseJWT(token)) {
			if(newsDAO.create(news) ) {
				return "true";
			}
			return "false";
		}
		return "false";
	}
	
	@GET
	@Path("/getAllNews/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<News> getNewsAll(@PathParam("token") String token){
		
		ArrayList<News> listNews = null;
		JavaJSONWebTokens jwt = new JavaJSONWebTokens();
		NewsDAO newsDAO = new NewsDAO();
		
		if(jwt.parseJWT(token)) {
			listNews = newsDAO.readAll();
		}
		
		return listNews;
		
		
	}
	
	@POST
	@Path("/update/{token}")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean updateNews(News news, @PathParam("token") String token){
		JavaJSONWebTokens jwt = new JavaJSONWebTokens();
		NewsDAO newsDAO = new NewsDAO();
		if(jwt.parseJWT(token)) {
			if(newsDAO.update(news) ) {
				return true;
			}
			return false;
		}
		return false;
	}
	
	@DELETE
	@Path("/delete/{id}/{token}")
	public int deleteNews(@PathParam("id") int id,@PathParam("token") String token) {
		
		JavaJSONWebTokens jwt = new JavaJSONWebTokens();
		NewsDAO newsDAO = new NewsDAO();
		
		if(jwt.parseJWT(token)) {
			
			 if(newsDAO.delete(new News(id))) {
				 return 1;
			 }else {
				 
			 }
		}
		
		return 0;
	}
}
