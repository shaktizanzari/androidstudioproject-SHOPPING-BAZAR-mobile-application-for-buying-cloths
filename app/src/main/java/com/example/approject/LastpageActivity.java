package com.example.approject;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LastpageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showMap(View view) {
        double latitude = 21.176630;
        double longitude = 79.061621;
        String locationName = "RCOEM, Nagpur";

        String geoUri = "geo:" + latitude + "," + longitude + "?q=" + Uri.encode(locationName);
        Uri gmmIntentUri = Uri.parse(geoUri);

        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        try {
            startActivity(mapIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Google Maps is not available or there was an error.", Toast.LENGTH_SHORT).show();
        }
    }
}