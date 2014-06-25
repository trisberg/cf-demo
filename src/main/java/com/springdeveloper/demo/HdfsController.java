package com.springdeveloper.demo;

import org.apache.hadoop.fs.FileStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.fs.FsShell;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@RestController
public class HdfsController {

	@Autowired
	private FsShell fsShell;

	@Autowired
	private Properties cloudProperties;

	@RequestMapping("/ls")
	public List<FileInfo> ls(@RequestParam(value="path", required=false, defaultValue="/") String path) {
		List<FileInfo> list = new ArrayList<FileInfo>();
		for (FileStatus fs : fsShell.ls(path)) {
			System.out.println(fs);
			list.add(new FileInfo(path, fs.getPath().getName()));
		}
		return list;
	}
}
