package com.spike.retail.activator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;
import org.osgi.util.tracker.ServiceTracker;

import com.spike.retail.controller.HelloWorldServlet;

public class HttpServiceTracker extends ServiceTracker {
	 
  public HttpServiceTracker(BundleContext context) {
      super(context, HttpService.class.getName(), null);
  }

  public Object addingService(ServiceReference reference) {
      HttpService httpService = (HttpService) context.getService(reference);
      try {           
          httpService.registerServlet("/retail", new HelloWorldServlet(), null, null); //$NON-NLS-1$
      } catch (Exception e) {
          e.printStackTrace();
      }
      return httpService;
  }       
   
  public void removedService(ServiceReference reference, Object service) {
      HttpService httpService = (HttpService) service;
      httpService.unregister("/retail"); //$NON-NLS-1$
      super.removedService(reference, service);
  }
}
