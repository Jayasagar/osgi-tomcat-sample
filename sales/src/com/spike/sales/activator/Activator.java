package com.spike.sales.activator;

import java.util.Properties;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import com.spike.sales.service.SaleService;
import com.spike.sales.service.impl.SaleServiceImpl;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private ServiceTracker httpServiceTracker;
	
	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) {
		Activator.context = bundleContext;
    
    httpServiceTracker = new HttpServiceTracker(context);
    httpServiceTracker.open();
    
    //Properties props = new Properties();
    // Register services
    context.registerService(SaleService.class.getName(), new SaleServiceImpl(), null);
	}

	public void stop(BundleContext bundleContext) {
		Activator.context = null;
    
    if (httpServiceTracker != null) {
        httpServiceTracker.close();
    }
    httpServiceTracker = null;
	}
}
