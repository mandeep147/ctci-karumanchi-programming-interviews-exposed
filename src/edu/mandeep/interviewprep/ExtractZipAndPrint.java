/**
 * extract the .zip files so like www.fjfj.com/file.zip that were given as input in hyperlinks. And print them
 */
package edu.mandeep.interviewprep;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * @author mandeep
 *
 */
public class ExtractZipAndPrint {

	private static ZipFile zip;
	private static ZipFile zf;
	private static BufferedReader br;

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.dynaexamples.com/examples-manual/ls-dyna_example.zip");
		unzip(url);
	}

	/**
	 * @param url
	 * @throws IOException 
	 */
	private static void unzip(URL url) throws IOException {
		//String url = "http://www.dynaexamples.com/examples-manual/ls-dyna_example.zip";
		ZipInputStream zin = new ZipInputStream(url.openStream());
		ZipEntry ze;
		while((ze = zin.getNextEntry()) != null){
			System.out.println(ze.getName());
			ze = zin.getNextEntry();
		}
	}
}