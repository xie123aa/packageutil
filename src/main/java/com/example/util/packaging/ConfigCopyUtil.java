package com.example.util.packaging;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Author: georgexie
 * @description: TODO
 * @Date: 2020/10/28 16:43
 * @Version 1.0
 */
public class ConfigCopyUtil {
	public static void copyFile(InputStream in, OutputStream out) throws IOException {
		int length = 2097152;
		byte[] buffer = new byte[length];
		int len = 0;
		while ((len = in.read(buffer)) > -1) {
			out.write(buffer, 0, len);
		}
	}
}
