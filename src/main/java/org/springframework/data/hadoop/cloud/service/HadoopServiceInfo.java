package org.springframework.data.hadoop.cloud.service;

import org.springframework.cloud.service.UriBasedServiceInfo;

/**
 */
public class HadoopServiceInfo extends UriBasedServiceInfo {


	public HadoopServiceInfo(String id, String uriString) {
		super(id, uriString);
	}

	@org.springframework.cloud.service.ServiceInfo.ServiceProperty(category = "connection")
	public java.lang.String getdefaultFS() {
		return super.getUri();
	}

}
