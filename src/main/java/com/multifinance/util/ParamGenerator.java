package com.multifinance.util;

import java.util.ArrayList;
import java.util.List;
import com.multifinance.model.ResultModel;

public class ParamGenerator {
	
	public static List<Object> paramDocuCate(Integer id, ResultModel result) {
		List<Object> param = new ArrayList<>();
		if (result.getName() != null)
			param.add(result.getName());
		if (result.getPrice() != null)
			param.add(result.getPrice());
		if (result.getImageUrl() != null)
			param.add(result.getImageUrl());
		param.add(id);
		return param;
	}
}