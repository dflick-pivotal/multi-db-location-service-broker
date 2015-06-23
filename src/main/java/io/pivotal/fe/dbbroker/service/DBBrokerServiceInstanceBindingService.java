package io.pivotal.fe.dbbroker.service;

import java.util.HashMap;
import java.util.Map;

import org.cloudfoundry.community.servicebroker.exception.ServiceBrokerException;
import org.cloudfoundry.community.servicebroker.exception.ServiceInstanceBindingExistsException;
import org.cloudfoundry.community.servicebroker.model.ServiceInstance;
import org.cloudfoundry.community.servicebroker.model.ServiceInstanceBinding;
import org.cloudfoundry.community.servicebroker.service.ServiceInstanceBindingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DBBrokerServiceInstanceBindingService implements
		ServiceInstanceBindingService {

	private ServiceInstanceBinding serviceInstanceBinding = null;
	
    @Value("${location_x_db_info}")
    private String location_x_db_info;
    @Value("${location_y_db_info}")
    private String location_y_db_info;
    @Value("${location_z_db_info}")
    private String location_z_db_info;
    	
	@Override
	public ServiceInstanceBinding createServiceInstanceBinding(
			String bindingId, ServiceInstance serviceInstance,
			String serviceId, String planId, String appGuid)
			throws ServiceInstanceBindingExistsException, ServiceBrokerException {
	
		ServiceInstanceBinding binding = null;
				
		Map<String,Object> credentials = new HashMap<String,Object>();
		if(planId.contentEquals(location_x_db_info))
			credentials.put("uri", location_x_db_info);
		if(planId.contentEquals(location_y_db_info))
			credentials.put("uri", location_y_db_info);
		if(planId.contentEquals(location_z_db_info))
			credentials.put("uri", location_z_db_info);
	    
		if(binding == null)
		{
			binding = new ServiceInstanceBinding(bindingId, serviceInstance.getId(), credentials, null, appGuid);
		}
				
		return binding;
	}

	protected ServiceInstanceBinding getServiceInstanceBinding(String id) {
		// Implement h2 to store Service Instance Binding
		return serviceInstanceBinding;
	}

	@Override
	public ServiceInstanceBinding deleteServiceInstanceBinding(
			String bindingId, ServiceInstance instance, 
			String serviceId, String planId)
			throws ServiceBrokerException {
		ServiceInstanceBinding binding = getServiceInstanceBinding(bindingId);
		if (binding!= null) {
		}
		return binding;
	}

}
