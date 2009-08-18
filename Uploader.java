import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import javax.swing.border.*;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;

public class Uploader extends JApplet implements ActionListener {
    private JPanel pane = null;
    private JTextField file_name = null;
    private JButton btn_load = null;
    
    public void init() {
	try {
	    initalizeUI();
	} catch(Exception e) {
	    e.printStackTrace();
	}
    }
    
    private void initalizeUI() throws Exception {
	pane = new JPanel();
	pane.setBounds(new Rectangle(0, 0, 500, 35));
	pane.setLayout(null);
	pane.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
	pane.setBackground(new Color(221, 194, 219));
	
	file_name = new JTextField();
	file_name.setText("");
	file_name.setBounds(new Rectangle(16, 23, 206, 29));
	
	btn_load = new JButton();
	btn_load.setBounds(new Rectangle(231, 23, 80, 30));
	btn_load.setText("Upload");
	btn_load.addActionListener(this);
	
	pane.add(file_name);
	pane.add(btn_load);
	setContentPane(pane);
    }
    
    public void actionPerformed(ActionEvent e) {
	if (e.getSource().equals(btn_load)) {
	    String content = readFile(file_name.getText());
	    try {
		postContentToServer( file_name.getText() );
	    } catch(java.io.IOException ioe) {
		ioe.printStackTrace();
	    }
	}
    }
    
    private String readFile(String name) {
	String line, content = "";
	try {
	    FileInputStream stream  =  new FileInputStream(name);
	    BufferedReader reader = new BufferedReader(
		new InputStreamReader(stream)
            );
	    while ((line = reader.readLine()) != null) {  
		content += line;
	    }
	} catch (Exception e) {
	    // Is the applet signed? || Was the file even present?
	    content = "";
	    e.printStackTrace();
	}
	return content;
    }
    
    private boolean postContentToServer(String name) throws java.io.IOException {
	System.out.println( readFile(name) );
	HttpClient httpclient = new DefaultHttpClient();
	HttpPost httppost = new HttpPost("http://localhost:3000/uploader/upload");
        FileBody payload = new FileBody(new File(name));
	MultipartEntity reqEntity = new MultipartEntity();
	
	reqEntity.addPart("payload", payload);
	httppost.setEntity(reqEntity);
	
	HttpResponse response = httpclient.execute(httppost);
        HttpEntity resEntity = response.getEntity();
	
	return false;
    }
}
