package com.mavin.egifting.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mavin.egifting.model.ApplicationSku;

public interface ApplicationSkuMapper {

	final String INSERT = "INSERT INTO application_sku "
			+ "(id, application_id, sku_id, name, price, status, create_dttm, update_dttm) "
			+ "values (#{id}, #{applictionId}, #{skuId}, #{name}, #{price}, #{status}, #{createDttm}, #{updateDttm})";

	final String SELECT_BY_ID = "select id, application_id, sku_id, name, price, status, create_dttm, update_dttm from application_sku WHERE id=#{id}";
	
	final String SELECT_BY_APPLICATION_ID = "select id, application_id, sku_id, name, price, status, create_dttm, update_dttm "
			+ "from application_sku WHERE application_id=#{applicationId}";

	final String SELECT_ALL = "select id, application_id, sku_id, name, price, status, create_dttm, update_dttm from application_sku";

	final String UPDATE = "UPDATE application_sku set application_id=#{applictionId}, sku_id=#{skuId}, name=#{name}, "
			+ "price=#{price}, status=#{status}, update_dttm=#{updateDttm} where id=#{id}";

	@Update(UPDATE)
	int updateApplicationSku(ApplicationSku applicationSku);

	@Insert(INSERT)
	int insertApplicationSku(ApplicationSku applicationSku);

	@Results(value = { @Result(property = "id", column = "id"),
			@Result(property = "applictionId", column = "application_id"),
			@Result(property = "skuId", column = "sku_id"), 
			@Result(property = "name", column = "name"),
			@Result(property = "price", column = "price"), 
			@Result(property = "status", column = "status"),
			@Result(property = "createDttm", column = "create_dttm"),
			@Result(property = "updateDttm", column = "update_dttm") })
	@Select(SELECT_BY_ID)
	ApplicationSku findApplicationSkuById(String id);

	@Results(value = { @Result(property = "id", column = "id"),
			@Result(property = "applictionId", column = "application_id"),
			@Result(property = "skuId", column = "sku_id"), 
			@Result(property = "name", column = "name"),
			@Result(property = "price", column = "price"), 
			@Result(property = "status", column = "status"),
			@Result(property = "createDttm", column = "create_dttm"),
			@Result(property = "updateDttm", column = "update_dttm") })
	@Select(SELECT_ALL)
	List<ApplicationSku> findApplicationSkus();
	
	@Results(value = { @Result(property = "id", column = "id"),
			@Result(property = "applictionId", column = "application_id"),
			@Result(property = "skuId", column = "sku_id"), 
			@Result(property = "name", column = "name"),
			@Result(property = "price", column = "price"), 
			@Result(property = "status", column = "status"),
			@Result(property = "createDttm", column = "create_dttm"),
			@Result(property = "updateDttm", column = "update_dttm") })
	@Select(SELECT_BY_APPLICATION_ID)
	List<ApplicationSku> findByApplcationId(String applicationId);

}
