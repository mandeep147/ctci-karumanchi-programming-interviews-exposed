/**
 * extract the .zip files so like www.fjfj.com/file.zip that were given as input in hyperlinks. And print them
 */
package edu.mandeep.practice.extractZipFiles;

import java.io.IOException;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @author mandeep
 *
 */
public class ExtractZipAndPrint {

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