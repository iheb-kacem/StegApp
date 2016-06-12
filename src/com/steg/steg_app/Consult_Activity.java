package com.steg.steg_app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Consult_Activity extends model {
	TextView du;
	TextView au;
	TextView ctr_elec;
	TextView ctr_chau;
	TextView ctr_gaz;
	TextView m_elec;
	TextView m_chau;
	TextView m_gaz;
	TextView n_elec;
	TextView n_chau;
	TextView n_gaz;
	TextView a_elec;
	TextView a_chau;
	TextView a_gaz;
	TextView t_elec;
	TextView t_chau;
	TextView t_gaz;
	TextView tva;
	TextView rtt;
	TextView t_taxes;
	TextView pay;
	TextView arr;
	TextView solde;
	TextView conso;
	TextView total;
	TextView pr;
	TextView avant;
	LinearLayout linear;
	static String p="";
	
	 private static final int STOPSPLASH = 0;
	 private static final long SPLASHTIME = 10;
	 static Bitmap bm;
	 static File imagePath;
		
		
	
	public void setVar(){	
		du=(TextView)findViewById(R.id.TextView01);
		au=(TextView)findViewById(R.id.TextView02);
		ctr_elec=(TextView)findViewById(R.id.TextView03);
		ctr_chau=(TextView)findViewById(R.id.TextView04);
		ctr_gaz=(TextView)findViewById(R.id.TextView05);
		m_elec=(TextView)findViewById(R.id.TextView06);
		m_chau=(TextView)findViewById(R.id.TextView07);
		m_gaz=(TextView)findViewById(R.id.TextView08);
		n_elec=(TextView)findViewById(R.id.TextView09);
		n_chau=(TextView)findViewById(R.id.TextView10);
		n_gaz=(TextView)findViewById(R.id.TextView11);
		a_elec=(TextView)findViewById(R.id.TextView12);
		a_chau=(TextView)findViewById(R.id.TextView13);
		a_gaz=(TextView)findViewById(R.id.TextView14);
		t_elec=(TextView)findViewById(R.id.TextView15);
		t_chau=(TextView)findViewById(R.id.TextView16);
		t_gaz=(TextView)findViewById(R.id.TextView17);
		tva=(TextView)findViewById(R.id.TextView18);
		rtt=(TextView)findViewById(R.id.TextView19);
		t_taxes=(TextView)findViewById(R.id.TextView20);
		pay=(TextView)findViewById(R.id.TextView21);
		arr=(TextView)findViewById(R.id.TextView22);
		solde=(TextView)findViewById(R.id.TextView23);
		conso=(TextView)findViewById(R.id.TextView24);
		total=(TextView)findViewById(R.id.TextView25);
		avant=(TextView)findViewById(R.id.TextView26);
		pr=(TextView)findViewById(R.id.TextView27);
	}
	
	public void matchValues1(){
		du.setText(facture.getDate_relever());
		au.setText(facture.getDate());
		m_elec.setText("");
		m_chau.setText("");
		m_gaz.setText("");
		if(!facture.getCtr_elec().equals("")){
		m_elec.setText(facture.getNb_mois());
		}
		if(!facture.getCtr_chauf().equals("")){
		m_chau.setText(facture.getNb_mois());
		}
		if(!facture.getCtr_gaz().equals("")){
		m_gaz.setText(facture.getNb_mois());
		}
		ctr_elec.setText(facture.getCtr_elec());
		ctr_chau.setText(facture.getCtr_chauf());
		ctr_gaz.setText(facture.getCtr_gaz());
		n_elec.setText(facture.getN_index_elec());
		n_chau.setText(facture.getN_index_chauf());
		n_gaz.setText(facture.getN_index_gaz());
		a_elec.setText(facture.getIndex_elec());
		a_chau.setText(facture.getIndex_chauf());
		a_gaz.setText(facture.getIndex_gaz());
		t_elec.setText(facture.getTotal_elec());
		t_chau.setText(facture.getTotal_chauf());
		t_gaz.setText(facture.getTotal_gaz());
		conso.setText(facture.getTotal());
	}
		
	public void matchValues2(){
		tva.setText(facture.getTva());
		rtt.setText(facture.getRtt());
		t_taxes.setText(facture.getTaxes());
		pay.setText(facture.getPayement());
		arr.setText(facture.getArrieres());
		solde.setText(facture.getSolde());
		total.setText(facture.getMontant());
		pr.setText(facture.getDate_proch_relever());
		avant.setText(facture.getDate_limit());
	}

	
	public void test2()
	{
		View v;
		if(p.equals("estim")){
			 v = findViewById(R.id.mini);	
		}else{
		 v = findViewById(R.id.tof);
		}
        v.setDrawingCacheEnabled(true);
        Bitmap b = v.getDrawingCache();             
        String extr = Environment.getExternalStorageDirectory().toString();
        imagePath = new File(extr, "test2.jpg");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(imagePath);
            b.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
            MediaStore.Images.Media.insertImage(getContentResolver(), b, "Screen", "screen");
        }catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_consult);
		setVar();
		matchValues1();
		linear=(LinearLayout)findViewById(R.id.linear2);
		
		String parent= this.getIntent().getExtras().getString("parent");
		p=parent;
		if(parent.equals("estim")){
			linear.setVisibility(View.INVISIBLE);
		}else{
			matchValues2();
		}
		final Message msg = new Message();
        msg.what = STOPSPLASH;
        splashHandler.sendMessageDelayed(msg, SPLASHTIME);
	}
	
	private final transient Handler splashHandler = new Handler()
    {
        @Override
 public void handleMessage(Message msg)
        {
 if (msg.what == STOPSPLASH)
            {

		test2();
		startActivity(new Intent(getApplicationContext(), allo.class));
            }

 super.handleMessage(msg);
        }
    };
	
	public void onDestroy() {
        super.onDestroy();
        facture=null;
        du.setText("");
		au.setText("");
		m_elec.setText("");
		m_chau.setText("");
		m_gaz.setText("");
		ctr_elec.setText("");
		ctr_chau.setText("");
		ctr_gaz.setText("");
		n_elec.setText("");
		n_chau.setText("");
		n_gaz.setText("");
		a_elec.setText("");
		a_chau.setText("");
		a_gaz.setText("");
		t_elec.setText("");
		t_chau.setText("");
		t_gaz.setText("");
		conso.setText("");
		tva.setText("");
		rtt.setText("");
		t_taxes.setText("");
		pay.setText("");
		arr.setText("");
		solde.setText("");
		total.setText("");
		pr.setText("");
		avant.setText("");
        Log.i("DDDDDD","vide");
        //UIHelper.killApp(true);
    }
}
