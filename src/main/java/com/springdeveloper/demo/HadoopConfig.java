package com.springdeveloper.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.hadoop.fs.FsShell;

@Configuration
@ImportResource("hadoop-context.xml")
public class HadoopConfig {

	private @Autowired
	org.apache.hadoop.conf.Configuration hadoopConfiguration;

	@Bean
	FsShell fsShell() {
		return new FsShell(hadoopConfiguration);
	}

}
