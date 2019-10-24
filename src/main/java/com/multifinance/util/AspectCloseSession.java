package com.multifinance.util;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
//import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.multifinance.dao.ResultDao;


@Aspect
@Configuration
public class AspectCloseSession {

	@Autowired
	ResultDao ProdDao;
	
//	private Logger logger = LoggerFactory.getLogger(this.getClass());

//	@AfterReturning(value = "execution(* com.in28minutes.springboot.basics.example.aop.business.*.*(..))", 
//			returning = "result")
//	public void afterReturning(JoinPoint joinPoint, Object result) {
//		logger.info("{} returned with value {}", joinPoint, result);
//	}
	
	@AfterReturning(value = "execution(* com.multifinance.controller.*.*(..))")
	public void after(JoinPoint joinPoint) {
		ProdDao.closeSession();
	}
}