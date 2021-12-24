package br.com.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class BeanUtilities {
	public static void populateBean(Object formBean, HttpServletRequest request) {
		populateBean(formBean,request.getParameterMap());
	}

	private static void populateBean(Object bean, Map prop) {
		// TODO Auto-generated method stub
		try {
			BeanUtils.populate(bean,prop);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
