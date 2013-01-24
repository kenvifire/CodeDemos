/**
 * 2013-1-24
 * Renamer.java
 * kenvi
 * mrwhite@163.com
 */
package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author kenvi
 * 
 */
public class Renamer {
	public static final Pattern pattern = Pattern
			.compile("/([^/]*)\\?response-content-disposition=attachment; filename=\"([^\"]*)\"");

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		if (args.length < 2) {
			System.out.println("Usage:Renamer dir file");
			System.exit(-1);
		}
		String file = args[1];
		String dir = args[0];
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(file)));
		String line = null;

		while ((line = br.readLine()) != null) {
			String url = URLDecoder.decode(line, "UTF-8");
			// System.out.println(url);
			Matcher matcher = pattern.matcher(url);
			if (matcher.find()) {
				String src = matcher.group(1);

				String dst = matcher.group(2);

				File srcFile = new File(dir + "/" + src);

				File dstFile = new File(dir + "/" + dst);

				srcFile.renameTo(dstFile);

			}
		}

	}
}
