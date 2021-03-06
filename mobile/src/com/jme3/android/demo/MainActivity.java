package com.jme3.android.demo;

import android.content.pm.ActivityInfo;
import android.os.Build;
import com.jme3.app.AndroidHarness;
import com.jme3.system.AppSettings;
import com.jme3.system.android.AndroidConfigChooser.ConfigType;
import java.util.logging.Level;
import java.util.logging.LogManager;

public class MainActivity extends AndroidHarness{

    /*
     * Note that you can ignore the errors displayed in this file,
     * the android project will build regardless.
     * Install the 'Android' plugin under Tools->Plugins->Available Plugins
     * to get error checks and code completion for the Android project files.
     */

    public MainActivity(){
        // Set the application class to run
        appClass = "com.jme3.android.demo.Main";
        // Try ConfigType.FASTEST; or ConfigType.LEGACY if you have problems
        eglConfigType = ConfigType.BEST;
        // Exit Dialog title & message
        exitDialogTitle = "Exit?";
        exitDialogMessage = "Press Yes";
        // Enable verbose logging
        eglConfigVerboseLogging = false;
        // Choose screen orientation
        screenOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
        // Enable MouseEvents being generated from TouchEvents (default = true)
        mouseEventsEnabled = true;
        // Set the default logging level (default=Level.INFO, Level.ALL=All Debug Info)
        LogManager.getLogManager().getLogger("").setLevel(Level.INFO);

        splashPicID = R.drawable.monkey256_9;

        // NOTE: SDK_INT is only available since 1.6,
        // but for jME3 it doesn't matter since android versions 1.5 and below
        // are not supported.
        if (Build.VERSION.SDK_INT >= 9){
            logger.log(Level.INFO, "Enabling OpenAL Soft Audio (Android 2.3 or higher)");
            audioRendererType = AppSettings.ANDROID_OPENAL_SOFT;
        } else {
            logger.log(Level.INFO, "Enabling Android MediaPlayer/SoundPool Audio (Android 2.2)");
            audioRendererType = AppSettings.ANDROID_MEDIAPLAYER;
        }

    }

}
