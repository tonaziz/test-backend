package com.multifinance.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.multifinance.dao.ResultDao;
import com.multifinance.mapper.ResultListMapper;
import com.multifinance.model.ResultModel;
import com.multifinance.util.ParamGenerator;
import com.multifinance.util.SqlGenerator;

@Repository
public class ResultDaoImpl implements ResultDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public String entryResult(ResultModel result) {
		String query = "INSERT INTO product.products(name, price, imageurl, created_at, updated_at) VALUES (?, ?, ?, now(), now()) RETURNING updated_at;";
		return jdbcTemplate.queryForObject(query, new Object[] { result.getName(), result.getPrice(),
				result.getImageUrl() }, String.class);
	}
	
	@Override
	public int deleteResult(Integer id) {
		String query = "DELETE FROM product.products WHERE id = ?;";
		return jdbcTemplate.update(query,  new Object[] {id} );
	}
	
	@Override
	public List<ResultModel> getResultAll() {
		String query = "SELECT id, name, price, imageurl, created_at, updated_at FROM product.products ORDER BY id ASC;";
		List<ResultModel> listModel = jdbcTemplate.query(query, new Object[] {}, new ResultListMapper());
		return listModel;
	}

	@Override
	public ResultModel getResultById(Integer id) {
		String query = "SELECT id, name, price, imageurl, created_at, updated_at FROM product.products WHERE id = ?";
		ResultModel prodModel = jdbcTemplate.queryForObject(query, new Object[] { id },
				new ResultListMapper());
		return prodModel;
	}

	@Override
	public int updateResult(Integer id, ResultModel result) {
		String query = SqlGenerator.ProdGenerateSql(result);
		return jdbcTemplate.update(query, ParamGenerator.paramDocuCate(id, result).toArray());
	}

	@Override
	public int idCheck(Integer id) {
		String query = "SELECT COUNT(name) FROM product.products WHERE id = ?;";
		return jdbcTemplate.queryForObject(query, new Object[] { id }, Integer.class);
		
	}
	
	@Override
	public Integer getId() {
		String query = "SELECT id FROM product.products ORDER BY id DESC LIMIT 1";
		return jdbcTemplate.queryForObject(query, new Object[] {}, Integer.class);
	}

	@Override
	public void closeSession() {
		String query = "SELECT pg_terminate_backend(pid) AS response " + "FROM pg_stat_activity "
				+ "WHERE datname = 'dft_multifinance' " + "AND pid <> pg_backend_pid() "
				+ "AND state in ('idle', 'idle in transaction (aborted)', 'disabled') "
				+ "AND application_name = 'PostgreSQL JDBC Driver' "
				+ "AND state_change < current_timestamp - INTERVAL '30 SECOND'";
		jdbcTemplate.queryForList(query);
	}
}
