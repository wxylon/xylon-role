package com.trgc.util;

import java.io.File;

/**
 * 文件存储服务
 * @author wangx
 */
public class StorageService extends Storage {

	public final static StorageService FILES = new StorageService("files");

	public final static StorageService CODE = new StorageService("code");

	private String file_path;

	private StorageService(String ext) {
		this.file_path = pathRoot +"uploads" + File.separator + ext + File.separator;
	}

	protected String getBasePath() {
		return file_path;
	}
}
