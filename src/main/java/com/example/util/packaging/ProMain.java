package com.example.util.packaging;

import org.apache.tools.ant.util.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @Author: georgexie
 * @description: TODO
 * @Date: 2020/10/28 14:35
 * @Version 1.0
 */
public class ProMain{
	private  static String path ="E:\\cpa_standard_v2_jrj\\cpa_standard_v2_financialStreet\\target\\";
	private  static String warFile="cpa_standard_v2_financialStreet.war";
	private static String warPackagePath=path+warFile;
	private static String unzipPackageFile="pro-package-file\\cpa_standard_v2_financialStreet";
	private static String unzipPackagePath=path+unzipPackageFile;

	public static void main(String[] args) throws IOException {
		//清空文件夹下面的文件
//		File file =new File(unzipPackagePath);
//		if(file.isDirectory()) {
//			file.delete();
//		}
		//解压war包
		ZipUtils.unzip(warPackagePath,
				unzipPackagePath);
		//替换资源文件
		File backEndFile =new File(path+"pro-package-file\\resource.properties");
		File target = new File(path+"pro-package-file\\cpa_standard_v2_financialStreet\\WEB-INF\\classes\\resource.properties");
		FileUtils fileUtils =FileUtils.getFileUtils();
		fileUtils.copyFile(backEndFile, target);
		File fontFile =new File(path+"pro-package-file\\wb-resource.js");
		File fonttarget = new File(path+"pro-package-file\\cpa_standard_v2_financialStreet\\html\\static\\js\\wb-resource.js");
		fileUtils.copyFile(fontFile, fonttarget);
		File licenseFile =new File(path+"pro-package-file\\license.lic");
		File licensetarget = new File(path+"pro-package-file\\cpa_standard_v2_financialStreet\\WEB-INF\\lib\\license.lic");
		fileUtils.copyFile(licenseFile, licensetarget);
		File vendorFile =new File(path+"pro-package-file\\vendor.lic");
		File vendortarget = new File(path+"pro-package-file\\cpa_standard_v2_financialStreet\\WEB-INF\\lib\\vendor.lic");
		fileUtils.copyFile(vendorFile, vendortarget);
	}


	private static void removeDir(File dir) {
		File[] files=dir.listFiles();
		for(File file:files){
			if(file.isDirectory()){
				removeDir(file);
			}else{
				System.out.println(file+":"+file.delete());
			}
		}
		System.out.println(dir+":"+dir.delete());
	}

}

