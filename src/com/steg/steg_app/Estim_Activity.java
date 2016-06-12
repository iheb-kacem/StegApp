package com.steg.steg_app;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Estim_Activity extends model implements OnClickListener, OnCheckedChangeListener{
	TextView text;
	Button btn_submit;
	CheckBox check_electricite;
	CheckBox check_chauffeau;
	CheckBox check_gaz;
	static EditText text_electricite;
	static EditText text_chauffeau;
	static EditText text_gaz;
	Resources res;

	
	public void trait(String ch){

		text.setText("salut ");
		
		if(ch.equals("101")||ch.equals("100"))
		{
			check_chauffeau.setVisibility(View.INVISIBLE);
		}
		if(ch.equals("110")||ch.equals("100"))
		{
			check_gaz.setVisibility(View.INVISIBLE);
		}
		text_electricite.setEnabled(false);
		text_chauffeau.setEnabled(false);
		text_gaz.setEnabled(false);
		
	}
	
	
	public void onClick(View v) { 
		
		if(verif())
		{	String rep;
			String url="http://player.net84.net/steg_estim.php";
			rep=matchEstime(url,""+text_electricite.getText(), ""+text_chauffeau.getText(),
					""+text_gaz.getText(), First_Activity.client);
			if(rep.equals("OK")){
			Intent intent = new Intent(this, Consult_Activity.class);
			intent.putExtra("parent","estim");
	  	    startActivity(intent);
	  	    }else{
	  	    	Toast.makeText(this, "Une erreur est survenue. veuillez réessayer plus tard !!", 3000).show();
	  	    }
		}
}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if(check_electricite.isChecked())
		{
			text_electricite.setEnabled(true);
		}else{
			text_electricite.setText("");
			text_electricite.setEnabled(false);
		}
		
		
		if(check_chauffeau.isChecked())
		{
			text_chauffeau.setEnabled(true);
		}else{
			text_chauffeau.setText("");
			text_chauffeau.setEnabled(false);
		}
		if (check_gaz.isChecked()) 
		{
			text_gaz.setEnabled(true);
		}else{
			text_gaz.setText("");
			text_gaz.setEnabled(false);
		}
		
	}
	
	
	public boolean verif(){
		String sh="";
		if(text_electricite.length()==0 && text_chauffeau.length()==0 && text_gaz.length()==0)
		{
			Toast.makeText(this, "Veuillez remplir au moin un champ !!", 1000).show();
			return false;
		}else{
			if(check_electricite.isChecked())
			{
			if(text_electricite.length()==0 || text_electricite.length()>4)
			{
				sh="Electicite";
			}
			}
			if(check_chauffeau.isChecked())
			{
			if(text_chauffeau.length()==0 || text_chauffeau.length()>4)
					{  if(sh==""){
						sh="Chauffeau";
					}else{
						sh=sh+" & Chauffeau";
					}
						
					}
			}
			if(check_gaz.isChecked())
			{
			if(text_gaz.length()==0 || text_gaz.length()>4)
					{
				if(sh==""){
					sh="Gaz";
				}else{
					sh=sh+" & Gaz";
				}
				}
			}
		}
		
		if(test(""+text_electricite.getText()) || test(""+text_chauffeau.getText()) || test(""+text_gaz.getText()))
		{
			Toast.makeText(this, "Erreur format ! Index à vérifier !!! "+sh, 1000).show();
			return false;
		}
		if(!(sh.equals("")))
		{
			Toast.makeText(this, "Index à vérifier : "+sh, 1000).show();
			return false;
		}else{
		        return true;
		     }
		

	}
		
	

	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_estim);
		String ctr=compteur("http://player.net84.net/ctr.php?m="+First_Activity.client);
		
		text = (TextView) findViewById(R.id.estim_text_msg);
		check_electricite = (CheckBox) findViewById(R.id.estim_check_electricite);
		check_chauffeau = (CheckBox) findViewById(R.id.estim_check_chauffeau);
		check_gaz = (CheckBox) findViewById(R.id.estim_check_gaz);
		text_electricite=(EditText)findViewById(R.id.estim_text_electricite);
		text_chauffeau=(EditText)findViewById(R.id.estim_text_chauffeau);
		text_gaz=(EditText)findViewById(R.id.estim_text_gaz);
	
        trait(ctr);
		
        check_electricite.setOnCheckedChangeListener(this);
		check_chauffeau.setOnCheckedChangeListener(this);
		check_gaz.setOnCheckedChangeListener(this);
		
        btn_submit =  (Button) findViewById(R.id.estim_submit);
        res = getResources();
		
        StateListDrawable myb1 = new StateListDrawable();
        myb1.addState(new int[] {android.R.attr.state_pressed}, res.getDrawable(R.drawable.submit2));
        myb1.addState(new int[] {android.R.attr.state_focused}, res.getDrawable(R.drawable.submit2));
        myb1.addState(new int[] {}, res.getDrawable(R.drawable.submit1));
        btn_submit.setBackgroundDrawable(myb1);
        btn_submit.setOnClickListener(this);
        
	}
	

}
