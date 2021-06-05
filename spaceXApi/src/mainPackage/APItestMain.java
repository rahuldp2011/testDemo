package mainPackage;

import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class APItestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			//Creating a HttpClient object
	      CloseableHttpClient httpclient = HttpClients.createDefault();

	      //Creating a HttpGet object
	      HttpGet httpget = new HttpGet("https://api.spacexdata.com/v4/launches/latest");

	      //Printing the method used
	      System.out.println("Request Type: "+httpget.getMethod());

	      //Executing the Get request
	      HttpResponse httpresponse = httpclient.execute(httpget);

	      Scanner sc = new Scanner(httpresponse.getEntity().getContent());

	      //Printing the status line
	      System.out.println(httpresponse.getStatusLine());	      
	      HttpEntity entity = httpresponse.getEntity();
	     
	      //this line receives the responsebody and we can compare whatever required for out test cases
	      //Highlevel test scenarios are written in notepad.
	      System.out.println(EntityUtils.toString(entity));
		}
		catch (Exception e)
		{
			System.out.println(e);
		}

	}

}
