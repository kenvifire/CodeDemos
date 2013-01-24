/**
 * 2013-1-24
 * CourseContentParser.java
 * kenvi
 * mrwhite@163.com
 */
package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author kenvi
 * 
 */
public class CourseContentParser {
	public static Pattern srtPattern = Pattern
			.compile("https://class\\.coursera\\.org/[a-zA-z0-9\\-_]*/lecture/subtitles\\?q=\\d{1,}_en&format=(txt|pdf|srt)");
	public static Pattern pdfPattern = Pattern
			.compile("https://d19vezwu8eufl6\\.cloudfront\\.net/[a-zA-Z0-9-]*/[^.]*\\.pdf");
	public static Pattern mvPattern = Pattern
			.compile("https://class\\.coursera\\.org/[a-zA-Z0-9-]*/lecture/download\\.mp4\\?lecture_id=\\d{1,}");

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		if (args.length < 2) {
			System.out.println("Usage:CouseContentParser file destDir");
			System.exit(-1);
		}
		String file = args[0];
		String dstDir = args[1];
		parseUrl(file, dstDir, UrlType.MV);
		parseUrl(file, dstDir, UrlType.PDF);
		parseUrl(file, dstDir, UrlType.SRT);
	}

	public static void parseUrl(String file, String dstDir, UrlType type)
			throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(file)));
		File dstFile = null;
		Pattern pattern = null;
		switch (type) {
		case MV:
			dstFile = new File(dstDir + "/mv.txt");
			pattern = mvPattern;
			break;
		case PDF:
			dstFile = new File(dstDir + "/pdf.txt");
			pattern = pdfPattern;
			break;
		case SRT:
			dstFile = new File(dstDir + "/srt.txt");
			pattern = srtPattern;
			break;
		}

		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();

		Matcher matcher = pattern.matcher(sb);
		BufferedWriter bw = new BufferedWriter(new FileWriter(dstFile));
		while (matcher.find()) {

			switch (type) {
			case MV:
				String urlStr = matcher.group(0);
				URL url = new URL(urlStr);
				HttpURLConnection conn = (HttpURLConnection) url
						.openConnection();
				String cookies = "PUT your cookie here";
				conn.setRequestProperty("Cookie", cookies);
				conn.setFollowRedirects(true);
				// System.out.println("返回码: " + conn.getResponseCode());
				// 如果定向的地址经过重定向，
				// 那么conn.getURL().toString()显示的是重定向后的地址
				Map responseMap = conn.getHeaderFields();
				String reLoc = responseMap.get("Location").toString();
				String reLocUrl = reLoc.substring(1, reLoc.length() - 1);
				bw.write(reLocUrl + "\n");
				break;
			case PDF:
				String pdfStr = matcher.group(0);
				bw.write(pdfStr + "\n");
				break;
			case SRT:
				String srtStr = matcher.group(0);
				bw.write(srtStr + "\n");
				break;
			}
		}

	}

	enum UrlType {
		SRT, PDF, MV;
	}

}
