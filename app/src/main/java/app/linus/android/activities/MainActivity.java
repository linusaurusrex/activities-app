package app.linus.android.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonOnClick(View view) {
        Log.d(MainActivity.class.getSimpleName(), view.toString() + "ACK");
      //  String pkg = view. //view.//"com.android.systemui";
        String cls = "com.android.systemui.settings.BrightnessDialog"; //, .DemoMode
       // launchActivity(pkg, cls);
    }
    // Buttons
    public void clickBrightness(View view) {
        launchActivity("com.android.systemui", "com.android.systemui.settings.BrightnessDialog");
    }
    public void clickTuner(View view) {
        launchActivity("com.android.systemui", "com.android.systemui.DemoMode");
    }
    public void clickEmergency(View view) {
        launchActivity("com.android.emergency", "com.android.emergency.view.ViewInfoActivity");
    }
    public void clickDessert(View view) {
        launchActivity("com.android.systemui", "com.android.systemui.DessertCase");
    }
    public void clickFlappy(View view) {
        launchActivity("com.android.systemui", "com.android.systemui.egg.MLandActivity");
    }
    public void clickActivate(View view) {
        launchActivity("com.android.egg", "com.android.egg.neko.NekoActivationActivity");
    }
    public void clickOcto(View view) {
        launchActivity("com.android.egg", "com.android.egg.octo.Ocquarium");
    }
    //End buttons
    private void launchActivity(String pkg, String cls) {
        Intent intent = new Intent();
        ComponentName cn = new ComponentName(pkg, cls);
        intent.setComponent(cn);
        startActivity(intent);
    }

    public void listPkgs() {
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> pkgList = getPackageManager().queryIntentActivities(intent, 0);
        for (ResolveInfo r : pkgList) {
            try{String a = r.toString();
            String targ = r.activityInfo.targetActivity;
            String name = r.activityInfo.applicationInfo.packageName;
            Log.d(MainActivity.class.getSimpleName(), targ);
            Log.d(MainActivity.class.getSimpleName(), name);}finally{}
        }
    }
}
/*
* MAIN: list of activities
 -> ActivityView: launcher; customize icon, text
     -> Create shortcut
WIDGET configure: main
    -> return

defaults:
* com.android.egg/com.android.egg.octo.Ocquarium
* com.android.egg.com/android.egg.neko.NekoLand
* com.android.egg/com.android.egg.neko.NekoActivationActivity
* com.android.emergency/com.android.emergency.view.viewInfoActivity
*                                            .edit.EditInfoActivity
*                                            .edit.EditMedicalInfoActivity
* com.android.systemui/com.android.systemui.DemoMode
*                                          .DessertCase
*                                          .egg.MLandActivity
*                                          .settings.BrightnessDialog
* */