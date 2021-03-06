package com.arquitecturajava.aplicacion.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public abstract class Accion { 
	
	private static String getPackage() {
		return Accion.class.getPackage().getName();
	}
	
	public Object getBean(String nombre, HttpServletRequest request) {
		WebApplicationContext factoria = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
		return factoria.getBean(nombre);
	}

	public static Accion getAccion(String tipo) {
		Accion accion = null;
		
		try {
			accion = (Accion) Class.forName(getPackage() + "." + tipo + "Accion").newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return accion;
	}
	
	public abstract String ejecutar(HttpServletRequest request, HttpServletResponse response);
}
