package com.multifinance.util;

import com.multifinance.model.ResultModel;

public class SqlGenerator {
	
	public static String ProdGenerateSql(ResultModel result) {
		StringBuilder query = new StringBuilder();
		query.append("UPDATE product.products SET ");
		query.append(CheckUtil.isNotNull(result.getName()) ? "name= ?, " : "");
		query.append(CheckUtil.isNotNull(result.getPrice()) ? "price = ?, " : "");
		query.append(CheckUtil.isNotNull(result.getImageUrl()) ? "imageurl = ?, " : "");
		query.append("updated_at= now()");
		query.append("WHERE id = ?;");
		return query.toString();
	}
}