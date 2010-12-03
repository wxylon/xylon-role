package com.trgc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.RandomStringUtils;

/**
 * 存储服务
 * @author wangx
 */
public abstract class Storage {

	private final static SimpleDateFormat FMT_FN = new SimpleDateFormat("yyyyMM/ddHHmmss_");
	protected abstract String getBasePath();
	
	/**
	 * 读取文件数据
	 * @param path
	 * @return
	 * @throws FileNotFoundException
	 * @author wangx
	 */
	public FileInputStream read(String path) throws FileNotFoundException {
		return new FileInputStream(getBasePath() + path);
	}

	/**
	 * 读取文件
	 * @param path
	 * @return
	 * @throws FileNotFoundException
	 * @author wangx
	 */
	public File readFile(String path) throws FileNotFoundException {
		return new File(getBasePath() + path);
	}

	/**
	 * 判断文件是否存在
	 * @param path
	 * @return
	 * @author wangx
	 */
	public boolean exist(String path) {
		return new File(getBasePath() + path).exists();
	}

	/**
	 * 保存文件，并返回对应的文件URI
	 * @param f
	 * @return
	 * @throws IOException
	 * @author wangx
	 */
	public String save(File f) throws IOException {
		String uri = FMT_FN.format(new Date()) +
		RandomStringUtils.randomAlphanumeric(4) + '.' +
		FilenameUtils.getExtension(f.getName()).toLowerCase();
		return save(f, uri);
	}

	/**
	 * 保存文件到指定路径
	 * @param f
	 * @param path
	 * @return
	 * @throws IOException
	 * @author wangx
	 */
	public String save(File f, String path) throws IOException {
		File dest = new File(getBasePath() + path);
		if (!dest.getParentFile().exists()){
			dest.getParentFile().mkdirs();
		}
		FileUtils.copyFile(f, dest);
		return path;
	}

	/**
	 * 根据路径来删除文件
	 * @param path
	 * @throws IOException
	 * @author wangx
	 */
	public void delete(String path) throws IOException {
		File dest = new File(getBasePath() + path);
		FileUtils.forceDelete(dest);
	}
}
