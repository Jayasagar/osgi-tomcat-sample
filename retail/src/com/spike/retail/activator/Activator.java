package com.spike.retail.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

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
	}

	public void stop(BundleContext bundleContext) {
		Activator.context = null;
    
    if (httpServiceTracker != null) {
        httpServiceTracker.close();
    }
    httpServiceTracker = null;
	}
}
