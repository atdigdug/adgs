package com.mavin.egifting.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mavin.egifting.model.Application;

public interface ApplicationMapper {

	final String INSERT = "INSERT INTO application "
			+ "(id, name, callback_api, website_url, itunes_url, google_play_store_url, status, create_dttm, update_dttm) "
			+ "values (#{id}, #{name}, #{callbackApi}, #{websiteUrl}, #{itunesUrl}, #{googleAppStoreUrl}, "
			+ "#{status}, #{createDttm}, #{updateDttm})";

	final String SELECT_BY_ID = "select id, name, callback_api, website_url, itunes_url, google_play_store_url, status, "
			+ "create_dttm, update_dttm from application WHERE id=#{id}";

	final String SELECT_ALL = "select id, name, callback_api, website_url, itunes_url, google_play_store_url, status, create_dttm, update_dttm from application";

	final String UPDATE = "UPDATE application set name=#{name}, callback_api=#{callbackApi}, website_url=#{websiteUrl}, "
			+ "itunes_url=#{itunesUrl}, google_play_store_url=#{googleAppStoreUrl}, "
			+ "status=#{status}, update_dttm=#{updateDttm} where id=#{id}";

	@Update(UPDATE)
	int updateApplication(Application application);

	@Insert(INSERT)
	int insertApplication(Application application);

	@Results(value = { @Result(property = "id", column = "id"), @Result(property = "name", column = "name"),
			@Result(property = "callbackApi", column = "callback_api"),
			@Result(property = "websiteUrl", column = "website_url"),
			@Result(property = "itunesUrl", column = "itunes_url"),
			@Result(property = "googleAppStoreUrl", column = "google_play_store_url"),
			@Result(property = "status", column = "status"), @Result(property = "createDttm", column = "create_dttm"),
			@Result(property = "updateDttm", column = "update_dttm") })
	@Select(SELECT_BY_ID)
	Application findApplicationById(String id);

	@Results(value = { @Result(property = "id", column = "id"), @Result(property = "name", column = "name"),
			@Result(property = "callbackApi", column = "callback_api"),
			@Result(property = "websiteUrl", column = "website_url"),
			@Result(property = "itunesUrl", column = "itunes_url"),
			@Result(property = "googleAppStoreUrl", column = "google_play_store_url"),
			@Result(property = "status", column = "status"), @Result(property = "createDttm", column = "create_dttm"),
			@Result(property = "updateDttm", column = "update_dttm") })
	@Select(SELECT_ALL)
	List<Application> findApplications();
}
