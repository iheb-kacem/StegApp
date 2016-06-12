package com.steg.steg_app;



import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;




public class Menu_Activity extends model implements OnClickListener {
	Button consult;
	Button estim;
	Button relever;
	Resources res;
	private ProgressDialog progressDialog;
	String rep="";
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		consult=(Button)findViewById(R.id.menu_button_consult);
		estim=(Button)findViewById(R.id.menu_button_estim);
		relever=(Button)findViewById(R.id.menu_button_relever);
		consult.setOnClickListener(this);
		estim.setOnClickListener(this);
		relever.setOnClickListener(this);
		res = getResources();
		
        StateListDrawable myb1 = new StateListDrawable();
        myb1.addState(new int[] {android.R.attr.state_pressed}, res.getDrawable(R.drawable.ab));
        myb1.addState(new int[] {android.R.attr.state_focused}, res.getDrawable(R.drawable.ab));
        myb1.addState(new int[] {}, res.getDrawable(R.drawable.aa));
        consult.setBackgroundDrawable(myb1);

        StateListDrawable myb2 = new StateListDrawable();
        myb2.addState(new int[] {android.R.attr.state_pressed}, res.getDrawable(R.drawable.bb));
        myb2.addState(new int[] {android.R.attr.state_focused}, res.getDrawable(R.drawable.bb));
        myb2.addState(new int[] {}, res.getDrawable(R.drawable.ba));
        estim.setBackgroundDrawable(myb2);

        StateListDrawable myb3 = new StateListDrawable();
        myb3.addState(new int[] {android.R.attr.state_pressed}, res.getDrawable(R.drawable.cb));
        myb3.addState(new int[] {android.R.attr.state_focused}, res.getDrawable(R.drawable.cb));
        myb3.addState(new int[] {}, res.getDrawable(R.drawable.ca));
        relever.setBackgroundDrawable(myb3);
	}
	@Override
	public void onClick(View v) {
		  
  	    if(consult.isPressed())
  	    { rep="aa";
  	    	/*progressDialog = new ProgressDialog(this);
  	    	progressDialog.setMessage("Chargement en cours");
  	    	progressDialog.show();
  	    	new Thread(new Runnable() {
  	    		public void run() {*/
	
  	    	String url="http://player.net84.net/steg_consult.php?m=";
  		  	rep=matchFacture(url+First_Activity.client);
  		  
  		  	/*progressDialog.dismiss();
  	    		}}).start();*/

  		  if(rep.equals("OK")){
  		  Intent intent = new Intent(Menu_Activity.this, Consult_Activity.class);
  		  intent.putExtra("parent","menu");
    	  startActivity(intent);
    	  
  		  }else{
  			Log.i("TTTTT","||"+rep+"--");
  			Toast.makeText(this, "Une erreur est survenue. veuillez réessayer plus tard !!", 3000).show();
  		  }
		}
  	    if(estim.isPressed())
		{
			Intent intent = new Intent(Menu_Activity.this, Estim_Activity.class);
			startActivity(intent);
		}
  	    if(relever.isPressed())
		{
			Intent intent = new Intent(Menu_Activity.this, Relever_Activity.class);
			startActivity(intent);
		}
	}

}
