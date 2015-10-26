package net;
import java.net.URL;
import java.net.HttpURLConnection;
public class Net {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		URL url =null;
		HttpURLConnection httpurlconnection=null;
		try {
			url=new URL("http://www.baidu.com");
			httpurlconnection=(HttpURLConnection) url.openConnection();
			int code=httpurlconnection.getResponseCode();
			System.out.println(code);
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			if(httpurlconnection!=null){
				httpurlconnection.disconnect();
			}
		}
	}

}
