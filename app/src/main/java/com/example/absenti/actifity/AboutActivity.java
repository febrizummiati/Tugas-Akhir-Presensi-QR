package com.example.absenti.actifity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.absenti.R;
import com.example.absenti.util.SharedPrefManager;

public class AboutActivity extends AppCompatActivity {
    CardView email, ig, fb, pnp, wa;

    SharedPrefManager sharedPrefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().setTitle("About Us");

//        email = findViewById(R.id.card_email);
//        email.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intentEmail = new Intent(Intent.ACTION_VIEW);
//                Uri.parse("mailto:febrizummiati99@gmail.com");
//                startActivity(intentEmail);
//            }
//        });
//
//        ig = findViewById(R.id.card_ig);
//        ig.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intentIg = new Intent(Intent.ACTION_VIEW);
//                Uri.parse("https://www.instagram.com/febrizummiati/");
//                startActivity(intentIg);
//            }
//        });
//
//        fb = findViewById(R.id.card_fb);
//        fb.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intentFb = new Intent(Intent.ACTION_VIEW);
//                Uri.parse("https://web.facebook.com/profile.php?id=100008439433977");
//                startActivity(intentFb);
//            }
//        });
//
//        pnp = findViewById(R.id.card_company);
//        pnp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intentPnp = new Intent(Intent.ACTION_VIEW);
//                Uri.parse("https://www.google.com/maps/dir/-0.9330965,100.4303492/politeknik+negeri+padang/@-0.9223415,100.4296738,14z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x2fd4b7be9e52a171:0x609ef1cc57a38e32!2m2!1d100.4662049!2d-0.9137822");
//                startActivity(intentPnp);
//            }
//        });
//
//        wa = findViewById(R.id.card_wa);
//        wa.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intentWa = new Intent(Intent.ACTION_VIEW);
//                Uri.parse("https://api.whatsapp.com/send?phone=6282385005138");
//                startActivity(intentWa);
//            }
//        });
    }
}