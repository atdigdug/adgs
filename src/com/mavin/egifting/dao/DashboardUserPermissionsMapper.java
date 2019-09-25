package com.mavin.egifting.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mavin.egifting.model.DashboardUserPermissions;

public interface DashboardUserPermissionsMapper {
	
	final String INSERT = "INSERT INTO dashboard_user_permissions " + "(id, dashboard_user_id, application_id, permission, create_dttm, update_dttm) "
			+ "values (#{id}, #{dashboardUserId}, #{applicationId}, #{permission}, #{createDttm}, #{updateDttm})";

	final String SELECT_BY_ID = "select id, dashboard_user_id, application_id, permission, create_dttm, update_dttm "
			+ "from dashboard_user_permissions WHERE id=#{id}";
	
	final String SELECT_BY_DASHBOARD_USER_ID = "select id, dashboard_user_id, application_id, permission, create_dttm, update_dttm "
			+ "from dashboard_user_permissions WHERE dashboard_user_id=#{dashboardUserId}";

	final String SELECT_ALL = "select id, dashboard_user_id, application_id, permission, create_dttm, update_dttm from dashboard_user_permissions";

	final String UPDATE = "UPDATE dashboard_user_permissions set dashboard_user_id=#{dashboardUserId}, "
			+ "application_id=#{applicationId}, permission=#{permission}, update_dttm=#{updateDttm} where id=#{id}";

	@Update(UPDATE)
	int updateDashboardUserPermissions(DashboardUserPermissions dashboardUserPermissions);

	@Insert(INSERT)
	int insertDashboardUserPermissions(DashboardUserPermissions dashboardUserPermissions);

	@Results(value = { @Result(property = "id", column = "id"), 
			@Result(property = "dashboardUserId", column = "dashboard_user_id"),
			@Result(property = "applicationId", column = "application_id"), 
			@Result(property = "permission", column = "permission"),
			@Result(property = "createDttm", column = "create_dttm"),
			@Result(property = "updateDttm", column = "update_dttm") })
	@Select(SELECT_BY_ID)
	DashboardUserPermissions findDashboardUserPermissionsById(String id);

	@Results(value = { @Result(property = "id", column = "id"), 
			@Result(property = "dashboardUserId", column = "dashboard_user_id"),
			@Result(property = "applicationId", column = "application_id"), 
			@Result(property = "permission", column = "permission"),
			@Result(property = "createDttm", column = "create_dttm"),
			@Result(property = "updateDttm", column = "update_dttm") })
	@Select(SELECT_ALL)
	List<DashboardUserPermissions> findAllDashboardUserPermissions();
	
	@Results(value = { @Result(property = "id", column = "id"), 
			@Result(property = "dashboardUserId", column = "dashboard_user_id"),
			@Result(property = "applicationId", column = "application_id"), 
			@Result(property = "permission", column = "permission"),
			@Result(property = "createDttm", column = "create_dttm"),
			@Result(property = "updateDttm", column = "update_dttm") })
	@Select(SELECT_BY_DASHBOARD_USER_ID)
	List<DashboardUserPermissions> findByDashbboardUserId(String dashboardUserId);

}
