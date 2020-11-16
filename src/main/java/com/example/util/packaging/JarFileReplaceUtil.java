package com.example.util.packaging;

/**
 * @Author: georgexie
 * @description: TODO
 * @Date: 2020/10/28 16:40
 * @Version 1.0
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;

public class JarFileReplaceUtil {

	/**
	 * @param jarPath    jar包所在绝对路径
	 * @param sourcePath confPath配置文件绝对路径
	 * @param destPath   配置文件jar包 位置config/sysconfig.properties
	 * @throws IOException
	 */
	public static void replaceFile(String jarPath, String sourcePath, String destPath) throws IOException {
		String jarName = jarPath.substring(jarPath.lastIndexOf(File.separator), jarPath.lastIndexOf("."));
		File file = new File(jarPath);
		File destFile = new File(jarPath.substring(0, jarPath.lastIndexOf(File.separator)) + jarName + "_cp.jar");
		file.renameTo(destFile);// 将jar文件名重命名为jarName_cp.jar

		JarFile jarFile = null;
		InputStream in = null;
		JarOutputStream out = null;
		try {
			jarFile = new JarFile(destFile);
			out = new JarOutputStream(new FileOutputStream(file));
			Enumeration<JarEntry> enumeration = jarFile.entries();
			while (enumeration.hasMoreElements()) {
				JarEntry jarEntry = enumeration.nextElement();
				InputStream in_ = null;
				try {
					String jarEntryName = jarEntry.getName();
					System.out.println(jarEntryName);
					if (destPath.equals(jarEntryName)) {
						continue;
					}
					in_ = jarFile.getInputStream(jarEntry);
					out.putNextEntry(jarEntry);
					ConfigCopyUtil.copyFile(in_, out);
				} finally {
					if (in_ != null) {
						try {
							in_.close();
						} catch (IOException e) {
						}
					}
				}
			}
			JarEntry jarEntry = new JarEntry(destPath);
			out.putNextEntry(jarEntry);
			in = new FileInputStream(new File(sourcePath));
			ConfigCopyUtil.copyFile(in, out);

		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
			if (jarFile != null) {
				try {
					jarFile.close();
				} catch (IOException e) {
				}
			}
		}

		destFile.delete();
	}

	public static void main(String[] args) {
//		String jarPath = "C:\\Users\\georgexie\\Desktop\\20201028发布\\test\\cpa_standard_v2_financialStreet.war";
//		String sourcePath = "C:\\Users\\georgexie\\Desktop\\20201028发布\\resource.properties";
//		String destPath = "WEB-INF/classes/resource.properties";
//		try {
//			JarFileReplaceUtil.replaceFile(jarPath, sourcePath, destPath);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}


		String jarPath = "C:\\Users\\georgexie\\Desktop\\20201028发布\\test\\cpa_standard_v2_financialStreet.war";
		String sourcePath = "C:\\Users\\georgexie\\Desktop\\20201028发布\\vendor.lic";
		String destPath = "WEB-INF/lib/vendor.lic";
		try {
			JarFileReplaceUtil.replaceFile(jarPath, sourcePath, destPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
