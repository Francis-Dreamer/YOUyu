package com.example.youyu.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;

import android.os.AsyncTask;

/**
 * HttpUrlConnection请求
 * 
 * @author Administrator
 * 
 */
public class HttpUrlConnectionUtil extends AsyncTask<String, Integer, String> {

	@SuppressWarnings("unused")
	public void postData(String url, Map<String, String> map)
			throws IOException {
		// Post请求的url，与get不同的是不需要带参数
		URL postUrl = new URL(url);
		// 打开连接
		HttpURLConnection connection = (HttpURLConnection) postUrl
				.openConnection();

		// 设置是否向connection输出，因为这个是post请求，参数要放在
		// http正文内，因此需要设为true
		connection.setDoOutput(true);
		// Read from the connection. Default is true.
		connection.setDoInput(true);
		// 默认是 GET方式
		connection.setRequestMethod("POST");

		// Post 请求不能使用缓存
		connection.setUseCaches(false);

		connection.setInstanceFollowRedirects(true);

		// 配置本次连接的Content-type，配置为application/x-www-form-urlencoded的
		// 意思是正文是urlencoded编码过的form参数，下面我们可以看到我们对正文内容使用URLEncoder.encode
		// 进行编码
		connection.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		// 连接，从postUrl.openConnection()至此的配置必须要在connect之前完成，
		// 要注意的是connection.getOutputStream会隐含的进行connect。
		connection.connect();
		DataOutputStream out = new DataOutputStream(
				connection.getOutputStream());
		// The URL-encoded contend
		// 正文，正文内容其实跟get的URL中 '? '后的参数字符串一致
		String content = "";
		StringBuilder stringBuilder = new StringBuilder();

		// DataOutputStream.writeBytes将字符串中的16位的unicode字符以8位的字符形式写到流里面
		out.write("mine_name='123456'&issue_id='2'&issue_name='123456'"
				.getBytes(Charset.forName("UTF-8")));
		out.flush();
		out.close();

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				connection.getInputStream()));
		String line;

		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		reader.close();
		connection.disconnect();
	}

	@SuppressWarnings("unused")
	@Override
	protected String doInBackground(String... params) {
		// Post请求的url，与get不同的是不需要带参数
		try {
			URL postUrl = new URL(params[0]);
			// 打开连接
			HttpURLConnection connection = (HttpURLConnection) postUrl
					.openConnection();
			// 设置是否向connection输出，因为这个是post请求，参数要放在
			// http正文内，因此需要设为true
			connection.setDoOutput(true);
			// Read from the connection. Default is true.
			connection.setDoInput(true);
			// 默认是 GET方式
			connection.setRequestMethod("POST");

			// Post 请求不能使用缓存
			connection.setUseCaches(false);

			connection.setInstanceFollowRedirects(true);

			// 配置本次连接的Content-type，配置为application/x-www-form-urlencoded的
			// 意思是正文是urlencoded编码过的form参数，下面我们可以看到我们对正文内容使用URLEncoder.encode
			// 进行编码
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			// 连接，从postUrl.openConnection()至此的配置必须要在connect之前完成，
			// 要注意的是connection.getOutputStream会隐含的进行connect。
			connection.connect();
			DataOutputStream out = new DataOutputStream(
					connection.getOutputStream());
			// The URL-encoded contend
			// 正文，正文内容其实跟get的URL中 '? '后的参数字符串一致
			String content = "";
			StringBuilder stringBuilder = new StringBuilder();

			// DataOutputStream.writeBytes将字符串中的16位的unicode字符以8位的字符形式写到流里面
			out.write("mine_name='123456'&issue_id='2'&issue_name='123456'"
					.getBytes(Charset.forName("UTF-8")));
			out.flush();
			out.close();

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String line;

			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
			connection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
