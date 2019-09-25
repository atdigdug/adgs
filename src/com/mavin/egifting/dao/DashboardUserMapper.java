package com.mavin.egifting.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mavin.egifting.model.DashboardUser;

public interface DashboardUserMapper {

	final String INSERT = "INSERT INTO dashboard_user " + "(id, email, status, create_dttm, update_dttm) "
			+ "values (#{id}, #{email}, #{status}, #{createDttm}, #{updateDttm})";

	final String SELECT_BY_ID = "select id, email, status, create_dttm, update_dttm from dashboard_user WHERE id=#{id}";
	
	final String SELECT_BY_EMAIL = "select id, email, status, create_dttm, update_dttm from dashboard_user WHERE email=#{email}";

	final String SELECT_ALL = "select id, email, status, create_dttm, update_dttm from dashboard_user";

	final String UPDATE = "UPDATE dashboard_user set email=#{email}, status=#{status}, update_dttm=#{updateDttm} where id=#{id}";

	@Update(UPDATE)
	int updateDashboardUser(DashboardUser dashboardUser);

	@Insert(INSERT)
	int insertDashboardUser(DashboardUser dashboardUser);

	@Results(value = { @Result(property = "id", column = "id"), @Result(property = "email", column = "email"),
			@Result(property = "status", column = "status"), @Result(property = "createDttm", column = "create_dttm"),
			@Result(property = "updateDttm", column = "update_dttm") })
	@Select(SELECT_BY_ID)
	DashboardUser findDashboardUserById(String id);

	@Results(value = { @Result(property = "id", column = "id"), @Result(property = "email", column = "email"),
			@Result(property = "status", column = "status"), @Result(property = "createDttm", column = "create_dttm"),
			@Result(property = "updateDttm", column = "update_dttm") })
	@Select(SELECT_ALL)
	List<DashboardUser> findAllDashboardUsers();
	
	@Results(value = { @Result(property = "id", column = "id"), @Result(property = "email", column = "email"),
			@Result(property = "status", column = "status"), @Result(property = "createDttm", column = "create_dttm"),
			@Result(property = "updateDttm", column = "update_dttm") })
	@Select(SELECT_BY_EMAIL)
	List<DashboardUser> findByEmail(String email);

}
