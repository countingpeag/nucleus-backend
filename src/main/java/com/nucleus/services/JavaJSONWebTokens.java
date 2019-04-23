package com.nucleus.services;

import java.util.Date;

import javax.xml.bind.DatatypeConverter;

import com.nucleus.models.Administrator;
import com.nucleus.models.Teacher;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JavaJSONWebTokens {


    private String signingKey = "my_clave";
	
	public String createJWT(String id, String subject, int seconds, Object obj){
		
		
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		JwtBuilder builder;
		
		if(subject.equals("administrator")) {
			Administrator administrator = (Administrator) obj;
		    builder = Jwts.builder().setId(id)
	                .setIssuedAt(now)
	                .setSubject(subject)
	                .claim("idAdministrator", administrator.getIdAdministrator())
	                .claim("adminName", administrator.getAdminName())
	                .claim("adminLastNameFather", administrator.getAdminLastNameFather())
	                .claim("adminLastNameMother", administrator.getAdminLastNameMother())
	                .claim("adminUsername", administrator.getAdminUsername())
	                .claim("adminRFC", administrator.getAdminRFC())
	                .signWith(signatureAlgorithm, signingKey);
		}
		else  {//Teacher
			Teacher teacher = (Teacher) obj;
		    builder = Jwts.builder().setId(id)
	                .setIssuedAt(now)
	                .setSubject(subject)
	                .claim("idTeacher", teacher.getIdTeacher())
	                .claim("teacherName", teacher.getTeacherName())
	                .claim("teacherLastNameFather", teacher.getTeacherLastNameFather())
	                .claim("teacherLastNameMother", teacher.getTeacherLastNameMother())
	                .claim("teacherUsername", teacher.getTeacherUsername())
	                .claim("teacherRFC", teacher.getTeacherRFC())
	                .signWith(signatureAlgorithm, signingKey);
		}
	    
	    if(seconds >= 0) {
	    	long expMillis = nowMillis + (seconds*1000);
	    	Date exp = new Date(expMillis);
	    	builder.setExpiration(exp);
	    }
		return builder.compact();
	}
	
	public boolean parseJWT(String jwt) {
		Claims claims = null;
		try {
			claims = Jwts.parser()
					.setSigningKey(DatatypeConverter.parseBase64Binary(signingKey))
					.parseClaimsJws(jwt).getBody();
		}
		catch(Exception e) {
			return false;
		}
		
		return true;
	}
}
