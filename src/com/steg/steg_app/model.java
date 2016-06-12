package com.steg.steg_app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public abstract class model extends Activity{
	
	
	static Facture facture;
	private static final String TAG_FACTURE = "facture";
	
	private static final String TAG_REF = "reference";
	private static final String TAG_ID = "ref_facture";
	private static final String TAG_TYPE = "type";
	private static final String TAG_ETAT = "etat";
	private static final String TAG_DATE = "date";
	private static final String TAG_NB_MOIS = "nb_mois";	
	private static final String TAG_INDEX_ELEC = "index_electricite";
	private static final String TAG_INDEX_CHAU = "index_chauffeau";
	private static final String TAG_INDEX_GAZ = "index_gaz";
	private static final String TAG_N_INDEX_ELEC = "n_index_electricite";
	private static final String TAG_N_INDEX_CHAU = "n_index_chauffeau";
	private static final String TAG_N_INDEX_GAZ = "n_index_gaz";
	private static final String TAG_CTR_ELEC = "ctr_electricite";
	private static final String TAG_CTR_CHAU = "ctr_chauffeau";
	private static final String TAG_CTR_GAZ = "ctr_gaz";
	private static final String TAG_TOTAL = "total";
	private static final String TAG_TAXES = "taxes";
	private static final String TAG_DATE_PROCH_RELEVER = "date_proch_relever";
	private static final String TAG_DATE_RELEVER = "date_relever";
	private static final String TAG_SOLDE= "solde";
	private static final String TAG_ARRIERES = "arrieres";
	private static final String TAG_PAYEMENT= "payement";
	private static final String TAG_ELEC = "total_electricite";
	private static final String TAG_CHAU = "total_chauffeau";
	private static final String TAG_GAZ = "total_gaz";
	private static final String TAG_TVA = "tva";
	private static final String TAG_RTT = "rtt";
	private static final String TAG_MONTANT = "montant";
	private static final String TAG_DATE_LIMIT = "date_limit";

	
	public void onClick(View v) {}
	
	public String matchFacture(String url)
	{   String rep="";
		JSONParser jParser = new JSONParser();
		try{
		JSONObject json = new JSONObject(jParser.getJSONFromUrl(url));
		JSONArray cl = null; 
		try {
		    cl = json.getJSONArray(TAG_FACTURE);
		    JSONObject c = cl.getJSONObject(0);
		    String etat = c.getString(TAG_ETAT);
			String reference = c.getString(TAG_REF);
			String ref_facture = c.getString(TAG_ID);
			String type = c.getString(TAG_TYPE);
			String date = c.getString(TAG_DATE);
			String nb_mois = c.getString(TAG_NB_MOIS);	
			String index_elec = c.getString(TAG_INDEX_ELEC);
			String index_chauf = c.getString(TAG_INDEX_CHAU);
			String index_gaz = c.getString(TAG_INDEX_GAZ);
			String total_elec = c.getString(TAG_ELEC);
			String total_chauf = c.getString(TAG_CHAU);
			String total_gaz = c.getString(TAG_GAZ);
			String total = c.getString(TAG_TOTAL);
			String tva = c.getString(TAG_TVA);
			String rtt = c.getString(TAG_RTT);
			String montant = c.getString(TAG_MONTANT);
			String date_limit = c.getString(TAG_DATE_LIMIT);
			String date_proch_relever = c.getString(TAG_DATE_PROCH_RELEVER);
		    String date_relever = c.getString(TAG_DATE_RELEVER);
			String n_index_elec = c.getString(TAG_N_INDEX_ELEC);
			String n_index_chauf = c.getString(TAG_N_INDEX_CHAU);
			String n_index_gaz = c.getString(TAG_N_INDEX_GAZ);
			String ctr_elec = c.getString(TAG_CTR_ELEC);
			String ctr_chauf = c.getString(TAG_CTR_CHAU);
			String ctr_gaz = c.getString(TAG_CTR_GAZ);
		    String taxes = c.getString(TAG_TAXES);
		    String solde = c.getString(TAG_SOLDE);
		    String arrieres = c.getString(TAG_ARRIERES);
		    String payement = c.getString(TAG_PAYEMENT);
		    
	        facture = new Facture( reference, ref_facture,  type,
	    			 etat, date, nb_mois, n_index_elec,
	    		     n_index_chauf,  n_index_gaz,  total_elec,
	    			 total_chauf,  total_gaz,  total,  tva,
	    			 rtt,  taxes,  montant,  date_limit,
	    			 ctr_elec,  ctr_chauf,  ctr_gaz,
	    			 index_elec,  index_chauf,  index_gaz,
	    			 arrieres,  payement,  solde,
	    			 date_relever,  date_proch_relever); 
	        return "OK";
		} catch (JSONException e) {
			 return rep;	
		}
		} catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
            return rep;
        }
	}
	
	public String matchEstime(String url, String a,String b, String c, String d)
	{	String rep="";
		JSONParser jParser = new JSONParser();	
		try{
		JSONObject json = jParser.getJSONsFromUrl(url,a,b,c,d);
		JSONArray cl = null;
		try {
		cl = json.getJSONArray(TAG_FACTURE);
		
		JSONObject stat_json = cl.getJSONObject(0);
		
		String date = stat_json.getString(TAG_DATE);
		String date_relever = stat_json.getString(TAG_DATE_RELEVER);
		String nb_mois = stat_json.getString(TAG_NB_MOIS);
		
		String ctr_elec = stat_json.getString(TAG_CTR_ELEC);
		String n_index_elec = stat_json.getString(TAG_N_INDEX_ELEC);
		String index_elec = stat_json.getString(TAG_INDEX_ELEC);
		String total_elec = stat_json.getString(TAG_ELEC);
		
		String ctr_chauf = stat_json.getString(TAG_CTR_CHAU);
		String n_index_chauf = stat_json.getString(TAG_N_INDEX_CHAU);
		String index_chauf = stat_json.getString(TAG_INDEX_CHAU);
		String total_chauf = stat_json.getString(TAG_CHAU);
		
		String ctr_gaz = stat_json.getString(TAG_CTR_GAZ);
		String n_index_gaz = stat_json.getString(TAG_N_INDEX_GAZ);
		String index_gaz = stat_json.getString(TAG_INDEX_GAZ);
		String total_gaz = stat_json.getString(TAG_GAZ);
		
		String total = stat_json.getString(TAG_TOTAL);
		
		facture = new Facture();
		facture.setDate(date);
		facture.setDate_relever(date_relever);
		facture.setNb_mois(nb_mois);
		
		facture.setCtr_elec(ctr_elec);
		facture.setN_index_elec(n_index_elec);
		facture.setIndex_elec(index_elec);
		facture.setTotal_elec(total_elec);

		facture.setCtr_chauf(ctr_chauf);
		facture.setN_index_chauf(n_index_chauf);
		facture.setIndex_chauf(index_chauf);
		facture.setTotal_chauf(total_chauf);

		facture.setCtr_gaz(ctr_gaz);
		facture.setN_index_gaz(n_index_gaz);
		facture.setIndex_gaz(index_gaz);
		facture.setTotal_gaz(total_gaz);
	
		facture.setTotal(total);
		
		return "OK";
		
		} catch (JSONException e) {
			Log.i("Hello","a");
		    return rep;
		}
		} catch (Exception e) {
			Log.i("Hello","b");
		    return rep;
		}
	}
	
	public String compteur(String url){
		 InputStream is = null;
		 String result="";

	      try{
	          HttpClient httpclient = new DefaultHttpClient();
	          HttpPost httppost = new HttpPost(url);
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
	          return result;
	         }catch(Exception e){
	                Log.e("log_tag", "Error converting result " + e.toString());
	                Toast.makeText(this, "Erreur du serveur veuillez réessayer plutard !!", 1000).show();
	                return "erreur";
	     }     
	      }catch(Exception e){
	          Log.e("log_tag", "Error in http connection " + e.toString());
	          Toast.makeText(this, "Connexion Echoué !!", 1000).show();
	          return "fail";
	      }
	}
	
	public String relever(String url, String a,String b, String c, String d){
		InputStream is = null;
		String json="";
   	 ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
     nameValuePairs.add(new BasicNameValuePair("elec",a));
     nameValuePairs.add(new BasicNameValuePair("chauf",b));
     nameValuePairs.add(new BasicNameValuePair("gaz",c));
     nameValuePairs.add(new BasicNameValuePair("reference",d));
    // Making HTTP request
    try {
        // defaultHttpClient
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs)); 
        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity httpEntity = httpResponse.getEntity();
        is = httpEntity.getContent();           

    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    } catch (ClientProtocolException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    try {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                is, "iso-8859-1"), 8);
        StringBuilder sb = new StringBuilder();
        String line = null;
        line = reader.readLine();
        sb.append(line);
        is.close();
        json = sb.toString();
        Log.i("RESULT",json);
    } catch (Exception e) {
        Log.e("Buffer Error", "Error converting result " + e.toString());
    }
    return json;
	}
	
	public boolean test(String ch){
		if(ch.equals("")){
			return false;
		}
		int i=0;
		while(i<ch.length()){
		switch (ch.charAt(i)){
		case '0':i++;
			break;
		case '1':i++;
			break;
		case '2':i++;
			break;
		case '3':i++;
			break;
		case '4':i++;
			break;
		case '5':i++;
			break;
		case '6':i++;
			break;
		case '7':i++;
			break;
		case '8':i++;
			break;
		case '9':i++;
			break;	
		default:return true;
		}
	}
	return false;
	
	
}

}
