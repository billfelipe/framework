package com.billfelipe.framework.log;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class LogInterceptor implements Serializable {

	private static final long serialVersionUID = -424879825248298676L;

	@Inject
	private Logger log;

	@AroundInvoke
	public Object interceptor(InvocationContext ic) throws Exception {
		Method method = ic.getMethod();
		Object target = ic.getTarget();
		Object[] parameters = ic.getParameters();

		StringBuilder info = new StringBuilder();
		info.append(target.getClass().getSimpleName()).append(".");
		info.append(method.getName()).append("( ");
		for (Object o : parameters) {
			if (o != null) {
				info.append("[").append(o.getClass().getSimpleName()).append("] ").append(o.toString()).append(" || ");
			}
		}
		info.append(" )");
		log.info(info.toString());
		return ic.proceed();
	}
}