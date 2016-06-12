package com.steg.steg_app;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;


import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class First_Activity extends Activity implements OnClickListener {
	static String client="";
	EditText reference;
	String number="";
	Button submit;
	String id="0000";
	String result="";
	String sim_id=null;
	Resources res;

	public String getSimId(){
		try{

				TelephonyManager tm = (TelephonyManager)getSystemService(TELEPHONY_SERVICE); 
				number = tm.getSimSerialNumber();
				return number;

		   }catch(Exception e){
			    Log.i("AA","soryy!!");
			    return number;
		}
		
	}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
		submit=(Button)findViewById(R.id.main_button_submit);
        res = getResources();
		
        StateListDrawable myb1 = new StateListDrawable();
        myb1.addState(new int[] {android.R.attr.state_pressed}, res.getDrawable(R.drawable.submit2));
        myb1.addState(new int[] {android.R.attr.state_focused}, res.getDrawable(R.drawable.submit2));
        myb1.addState(new int[] {}, res.getDrawable(R.drawable.submit1));
        submit.setBackgroundDrawable(myb1);
		sim_id=getSimId();
		if(sim_id!=null)
		{
			reference=(EditText)findViewById(R.id.main_text_reference);
			submit.setOnClickListener(this);
		}else{
			Toast.makeText(getApplicationContext(), "SIM abscent!", 1000).show();
		}
		
		
	}

	public void onClick(View v) {
		if(verif())
		{
			 InputStream is = null;
		     String strURL="http://player.net84.net/steg_valid.php?m="+this.reference.getText()+"&n="+sim_id;     

		      try{
		          HttpClient httpclient = new DefaultHttpClient();
		          HttpPost httppost = new HttpPost(strURL);
		          HttpResponse response = httpclient.execute(httppost);
		          HttpEntity entity = response.getEntity();
		          is = entity.getContent();

		      try{
		          BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
		          StringBuilder sb = new StringBuilder();
		          String line = null;
		          line=reader.readLine();
		          sb.append(line);
		          is.close();
		          result=sb.toString(); 
		         }catch(Exception e){
		                Log.e("log_tag", "Error converting result " + e.toString());
		                Toast.makeText(this, "Erreur du serveur veuillez réessayer plutard !!", 1000).show();
		     }     
		      }catch(Exception e){
		          Log.e("log_tag", "Error in http connection " + e.toString());
		          Toast.makeText(this, "Connexion Echoué !!", 1000).show();
		      }
		      //--------------
		      Log.i("PPresult",result);
		      if (result.equals("erreur"))
		      {
		    	  Toast.makeText(this, "Erreur interne! Voudriez essayer plutart.", 1000).show(); 
		      }else{
		    	  if (result.equals("num"))
		    	  {
		    		  Toast.makeText(this, "Vous n'êtes pas inscrit aux service !!", 1000).show();
		    	  }else{
		    		  if (result.equals("ref"))
		    		  {
		    			  Toast.makeText(this, "Vérifier votre référence !!", 1000).show();
		    		  }else{
		    			  client+=reference.getText();
		    			  Intent intent = new Intent(First_Activity.this, Menu_Activity.class);
		    	  	      startActivity(intent); 
		    		  }
		    		  
		    	  }
		      }
		      //--------------
		}
	}
	
	public boolean verif(){
		String sh="";
		String ch="";

		if(!(reference.getText().length()==0))
		{
			if (reference.getText().length()>=10)
			{
				sh="Reference";
			}
		}else{
			 	ch="Reference";
			 }
		if(!(ch.equals("")))
		{
			Toast.makeText(this, "Champ vide: "+ch, 1000).show();
			return false;
		}else{
		     	 if(!(sh.equals("")))
		     	 {
		     		 Toast.makeText(this, sh+" trop long !!", 1000).show();
		     		 return false;
		         }else{
		        	  	  return true;
		        	  }
		     }
	}



}

