package com.multifinance.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.multifinance.model.ResultModel;



public class ResultListMapper implements RowMapper<ResultModel>{

	@Override
	public ResultModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		ResultModel result = new ResultModel();
		result.setId(rs.getInt("id"));
		result.setName(rs.getString("name"));
		result.setPrice(rs.getInt("price"));
		result.setImageUrl(rs.getString("imageurl"));
		result.setCreatedAt(rs.getString("created_at"));
		result.setUpdatedAt(rs.getString("updated_at"));
		return result;
	}

}
