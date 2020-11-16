package com.example.util.beta;

import com.example.util.packaging.JarFileReplaceUtil;

import java.io.IOException;

/**
 * @Author: georgexie
 * @description: 老版本项目
 * @Date: 2020/10/28 16:53
 * @Version 1.0
 */
public class TestPackage {
	public static void main(String[] args) {
//		String jarPath = "C:\\Users\\georgexie\\Desktop\\20201028发布\\test\\cpa_standard_v2_financialStreet.war";
		String jarPath = "E:\\cpa_standard_v2_jrj\\cpa_standard_v2_financialStreet\\target\\cpa_standard_v2_financialStreet.war";
		String SourcePath = "E:\\金融街配置文件\\test-package-file\\";
		String backendSourcePath = SourcePath+"resource.properties";
		String fontSourcePath = SourcePath+"wb-resource.js";
		String vendorSourcePath = SourcePath+"vendor.lic";
		String licenseSourcePath = SourcePath+"license.lic";
		String backendPath = "WEB-INF/classes/resource.properties";
		String fontPath = "html/static/js/wb-resource.js";
		String vendorPath = "WEB-INF/lib/vendor.lic";
		String licensePath = "WEB-INF/lib/license.lic";
		try {
			JarFileReplaceUtil.replaceFile(jarPath, backendSourcePath, backendPath);
			JarFileReplaceUtil.replaceFile(jarPath, fontSourcePath, fontPath);
//			JarFileReplaceUtil.replaceFile(jarPath, vendorSourcePath, vendorPath);
//			JarFileReplaceUtil.replaceFile(jarPath, licenseSourcePath, licensePath);
		} catch (
				IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
