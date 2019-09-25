package com.mavin.egifting.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mavin.egifting.model.ApplicationCodeProvider;

public interface ApplicationCodeProviderMapper {

	final String INSERT = "INSERT INTO application_code_provider "
			+ "(id, code, application_id, valid_until_date, status, create_dttm, update_dttm) "
			+ "values (#{id}, #{code}, #{applicationId}, #{validUntilDate}, #{status}, #{createDttm}, #{updateDttm})";

	final String SELECT_BY_ID = "select id, code, application_id, valid_until_date, status, create_dttm, update_dttm"
			+ " from application_code_provider WHERE id=#{id}";

	final String SELECT_ALL = "select id, code, application_id, valid_until_date, status, create_dttm, update_dttm from application_code_provider";

	final String UPDATE = "UPDATE application_code_provider set code=#{code}, application_id=#{applicationId}, valid_until_date=#{validUntilDate}, "
			+ "status=#{status}, update_dttm=#{updateDttm} where id=#{id}";

	@Update(UPDATE)
	int updateApplicationCodeProvider(ApplicationCodeProvider applicationCodeProvider);

	@Insert(INSERT)
	int insertApplicationCodeProvider(ApplicationCodeProvider applicationCodeProvider);

	@Results(value = { @Result(property = "id", column = "id"), @Result(property = "code", column = "code"),
			@Result(property = "applicationId", column = "application_id"),
			@Result(property = "validUntilDate", column = "valid_until_date"),
			@Result(property = "status", column = "status"), @Result(property = "createDttm", column = "create_dttm"),
			@Result(property = "updateDttm", column = "update_dttm") })
	@Select(SELECT_BY_ID)
	ApplicationCodeProvider findApplicationCodeProviderById(String id);

	@Results(value = { @Result(property = "id", column = "id"), @Result(property = "code", column = "code"),
			@Result(property = "applicationId", column = "application_id"),
			@Result(property = "validUntilDate", column = "valid_until_date"),
			@Result(property = "status", column = "status"), @Result(property = "createDttm", column = "create_dttm"),
			@Result(property = "updateDttm", column = "update_dttm") })
	@Select(SELECT_ALL)
	List<ApplicationCodeProvider> findApplicationCodeProviders();

}
