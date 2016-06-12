package com.steg.steg_app;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class allo extends Activity{
	
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.allo);
		
		//Toast.makeText(getApplicationContext(), "Alloooo ", Toast.LENGTH_SHORT).show();
	    Handler handler = new Handler(); 
	    handler.postDelayed(new Runnable() {
	    	public void run() { 
	    		if(Consult_Activity.imagePath.exists())
	    		{

	    		    Bitmap myBitmap = BitmapFactory.decodeFile(Consult_Activity.imagePath.getAbsolutePath());

	    		    TouchImageView image= (TouchImageView) findViewById(R.id.hh);
	    		    image.setImageBitmap(myBitmap);
	    		    image.setImageBitmap(myBitmap);
	    	        image.setMaxZoom(4f);

	    		}
	    	 }
    	}, 2000);
	}

}
