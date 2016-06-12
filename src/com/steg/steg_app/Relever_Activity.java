package com.steg.steg_app;


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
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;

public class Relever_Activity extends model implements OnClickListener{
	TextView msg;
	Button btn_submit;
	TextView tag_electricite;
	TextView tag_chauffeau;
	TextView tag_gaz;
	EditText text_electricite;
	EditText text_chauffeau;
	EditText text_gaz;
	Resources res;
	
	
	

	public void trait(String ch){

		
		if(ch.equals("101")||ch.equals("100"))
		{
			text_chauffeau.setVisibility(View.INVISIBLE);
			tag_chauffeau.setVisibility(View.INVISIBLE);
			text_chauffeau.setEnabled(false);
		}
		if(ch.equals("110")||ch.equals("100"))
		{
			text_gaz.setVisibility(View.INVISIBLE);
			tag_gaz.setVisibility(View.INVISIBLE);
			text_gaz.setEnabled(false);
		}
	
		
	}
	
	
	public void onClick(View v) { 
		if(verif())
		{ String rep="";	
		  String url="http://player.net84.net/steg_relever.php";	
		  rep=relever(url,""+text_electricite.getText(),""+text_chauffeau.getText(),""+text_gaz.getText(),First_Activity.client);
		  if(rep.equals("positive")){
			  matchFacture("http://player.net84.net/steg_consult.php?m="+First_Activity.client);
			  Intent intent = new Intent(Relever_Activity.this, Consult_Activity.class);
			  intent.putExtra("parent","relever");
	  	      startActivity(intent);
		  }else{
			  if(rep.equals("")){
				  Toast.makeText(this, "Une erreur est survenue lors de l'envoi. veuillez réessayer plus tard !!", 3000).show();  
			  }else{
				  Toast.makeText(this, "Une erreur est survenue lors de la réception. veuillez réessayer plus tard !!", 3000).show();
			  }
		  }

		}
	}	

	
	public boolean verif(){
		String sh="";
		if(text_electricite.length()==0 && text_chauffeau.length()==0 && text_gaz.length()==0)
		{
			Toast.makeText(this, "Veuillez remplir au moin un champ !!", 1000).show();
			return false;
		}else{

			if(text_electricite.length()==0 || text_electricite.length()>4)
			{
				sh="Electicite";
			}
			
			if(text_chauffeau.isEnabled())
			{
			if(text_chauffeau.length()==0 || text_chauffeau.length()>4)
					{  if(sh==""){
						sh="Chauffeau";
					}else{
						sh=sh+" & Chauffeau";
					}
						
					}
			}
			if(text_gaz.isEnabled())
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
		
			String ch="";
			try { if(!text_electricite.getText().equals("[0-9]*")){
					ch+=" electricite"; 
				}
				if(!text_chauffeau.getText().equals("[0-9]*")){	
				ch+=" chauffeau";
				}	
			if(!text_gaz.getText().equals("[0-9]*")){	
				ch+=" gaz"; 
			}	
			} 
			catch (Exception e) { 
				Toast.makeText(this, "Erreur format  !! Index à vérifier :"+ch, 1000).show();
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
		setContentView(R.layout.activity_relever);
		String ctr=compteur("http://player.net84.net/ctr.php?m="+First_Activity.client);
		tag_electricite = (TextView) findViewById(R.id.relever_tag_electricite);
		tag_chauffeau = (TextView) findViewById(R.id.relever_tag_chauffeau);
		tag_gaz = (TextView) findViewById(R.id.relever_tag_gaz);
		text_electricite=(EditText)findViewById(R.id.relever_text_electricite);
		text_chauffeau=(EditText)findViewById(R.id.relever_text_chauffeau);
		text_gaz=(EditText)findViewById(R.id.relever_text_gaz);
		

        trait(ctr);
		
		
        btn_submit =  (Button) findViewById(R.id.relever_submit);
        res = getResources();
		
        StateListDrawable myb1 = new StateListDrawable();
        myb1.addState(new int[] {android.R.attr.state_pressed}, res.getDrawable(R.drawable.submit2));
        myb1.addState(new int[] {android.R.attr.state_focused}, res.getDrawable(R.drawable.submit2));
        myb1.addState(new int[] {}, res.getDrawable(R.drawable.submit1));
        btn_submit.setBackgroundDrawable(myb1);
        btn_submit.setOnClickListener(this);
        
	}
	
	
}

