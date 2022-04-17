package palamod.procedures;

import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.CloseableHttpResponse;

import java.util.Map;

import java.io.IOException;

public class CrowdinhttpsProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpget = new HttpGet("https://crowdin.com/project/Open-Palamod");
			CloseableHttpResponse httpresponse = httpclient.execute(httpget);
		} catch (IOException e) {
			System.out.println("Error fetching URL");
		}
	}
}
