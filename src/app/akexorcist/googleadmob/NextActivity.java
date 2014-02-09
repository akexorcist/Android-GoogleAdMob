package app.akexorcist.googleadmob;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.os.Bundle;
import android.util.Log;
import android.app.Activity;

public class NextActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_next);

		AdRequest.Builder adBuilder = new AdRequest.Builder();
	    AdRequest adRequest = adBuilder.build();
		AdView adView = (AdView)this.findViewById(R.id.adView);
	    adView.setAdListener(new AdListener() {
	    	public void onAdLoaded() {
	    		Log.i("Check", "Loaded");
	    	}
	    	
	    	public void onAdOpened() {
	    		Log.i("Check", "Opened");
	    	}
	    	
	    	public void onAdFailedToLoad(int errorCode) {
	    		Log.i("Check", "FailedToLoad:" + errorCode);
	    	}
	    	
	    	public void onAdClosed() {
	    		Log.i("Check", "Closed");
	    	}
	    	
	    	public void onAdLeftApplication() {
	    		Log.i("Check", "LeftApplication");
	    	}
	    });	  
	    adView.loadAd(adRequest);  
	}
}
