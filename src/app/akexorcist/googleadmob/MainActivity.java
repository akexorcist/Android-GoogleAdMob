package app.akexorcist.googleadmob;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	InterstitialAd iAd;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		

		AdRequest.Builder adBuilder = new AdRequest.Builder();	
		AdRequest adRequest = adBuilder.build();
		iAd = new InterstitialAd(this);
		iAd.setAdUnitId("Device_ID");
		iAd.loadAd(adRequest);
		iAd.setAdListener(new AdListener() {
	    	public void onAdClosed() {
	    		nextActivity();
	    	}
		});
	    
	    Button button1 = (Button)findViewById(R.id.button1);
	    button1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(iAd.isLoaded()) 
	    			iAd.show();
				else 
					nextActivity();
			}
		});
	}
	
	public void nextActivity() {
		Intent intent = new Intent(getApplicationContext(), NextActivity.class);
		startActivity(intent);
	}
}
