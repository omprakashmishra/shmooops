package com.webmazix.shmooops;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Handler;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import com.webmazix.shmooops.Tech.Settings.BaseActivity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Splash extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        initview();
    }

    private void initview() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(Splash.this, Login.class);

               // genrateKeyHash(getPackageName());

                startActivity(i);
                // close this activity
                finish();
            }
        }, 2000);
    }

    private void genrateKeyHash(String packagen_name) {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    packagen_name, PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:--------------->", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }
}
