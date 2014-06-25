package org.springframework.data.hadoop.cloud.service;

import org.apache.hadoop.conf.Configuration;
import org.springframework.cloud.service.AbstractServiceConnectorCreator;
import org.springframework.cloud.service.ServiceConnectorConfig;

/**
 */
public class HadoopConfigurationCreator extends AbstractServiceConnectorCreator<Configuration, HadoopServiceInfo> {

	@Override
	public Configuration create(HadoopServiceInfo hadoopServiceInfo, ServiceConnectorConfig serviceConnectorConfig) {
		Configuration configuration = new Configuration();
		configuration.set("fs.defaultFS", hadoopServiceInfo.getdefaultFS());
		return configuration;
	}
}
