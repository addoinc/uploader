import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.applet.*;
import java.awt.*;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;

public class Uploader extends Applet {
    
    static {
	System.load("c:\\code\\zugslist_jni.dll");
    }
    public native String getWoWPath();
    private Label message;
    
    public void init() {
	try {
	    String wow_install_path = getWoWPath();
	    String account_name = getParameter("wowid");
	    
	    message = new Label();
	    
	    setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
	    add(message);	    
	    
	    if( wow_install_path.length() != 0 ) {
		String upload_file_path = wow_install_path + File.separator +
		    "WTF" + File.separator + "Account" + File.separator +
		    account_name + File.separator + "SavedVariables" +
		    File.separator + "zugslist.lua";
		if( new File( upload_file_path ).exists() ) {
		    postContentToServer( upload_file_path );
		} else {
		    message.setText( "Zugslist addon file was not found!" );
		    System.err.println( upload_file_path );
		}
	    } else {
		message.setText( "World of warcraft installtion dir not found!" );
	    }
	} catch(java.io.IOException ioe) {
	    ioe.printStackTrace();
	}
    }
    
    private boolean postContentToServer(String name) throws java.io.IOException {
	HttpClient httpclient = new DefaultHttpClient();
	HttpPost httppost = new HttpPost("http://10.0.0.40:3000/uploader/upload");
        FileBody payload = new FileBody(new File(name));
	MultipartEntity reqEntity = new MultipartEntity();
	
	reqEntity.addPart("payload", payload);
	httppost.setEntity(reqEntity);
	
	HttpResponse response = httpclient.execute(httppost);
        HttpEntity resEntity = response.getEntity();
	
	message.setText( "TradeLinks file uploaded to server!" );
	
	return true;
    }
}
