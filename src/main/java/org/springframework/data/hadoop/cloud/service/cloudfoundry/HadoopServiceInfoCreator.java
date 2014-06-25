package org.springframework.data.hadoop.cloud.service.cloudfoundry;

import org.springframework.cloud.cloudfoundry.CloudFoundryServiceInfoCreator;
import org.springframework.cloud.cloudfoundry.Tags;
import org.springframework.data.hadoop.cloud.service.HadoopServiceInfo;

import java.util.Map;

/**
 */
public class HadoopServiceInfoCreator extends CloudFoundryServiceInfoCreator<HadoopServiceInfo> {

	public HadoopServiceInfoCreator() {
		super(new Tags("p-hd"));
	}

	@Override
	public HadoopServiceInfo createServiceInfo(Map<String, Object> serviceData) {

		String id = (String) serviceData.get("name");

		String fsUri = (String) ((Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) serviceData.get("credentials"))
				.get("hdfs")).get("configuration")).get("fs.defaultFS");

		return new HadoopServiceInfo(id, fsUri);
	}
}
