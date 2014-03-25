package com.spike.retail.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.framework.BundleContext;

import com.spike.sales.service.SaleService;
import com.spike.sales.service.impl.SaleServiceImpl;

public class HelloWorldServlet extends HttpServlet {
	private SaleService saleService;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*BundleContext bundleContext = (BundleContext) req.getServletContext().getAttribute("osgi-bundlecontext");
		
		if (bundleContext == null) {
			throw new IllegalStateException("osgi-bundlecontext not registered");
		}
		
		saleService = bundleContext.getService(bundleContext.getServiceReference(SaleService.class));*/
		
		saleService = new SaleServiceImpl();
		
		resp.setContentType("text/html");
		resp.getWriter().write("<html><body>Hello World " +saleService.getName()+ " </body></html>"); //$NON-NLS-1$
	}

}
