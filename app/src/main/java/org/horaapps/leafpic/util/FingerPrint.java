//package org.horaapps.leafpic.util;
//
//import android.app.KeyguardManager;
//import android.content.Context;
//import android.hardware.fingerprint.FingerprintManager;
//import android.os.Build;
//import android.support.annotation.RequiresApi;
//
//import org.horaapps.leafpic.R;
//
//import static android.content.Context.FINGERPRINT_SERVICE;
//import static android.content.Context.KEYGUARD_SERVICE;
//
///**
// * Created by gilbert on 24/03/2017.
// */
//
//public class FingerPrint {
//
//    @RequiresApi(api = Build.VERSION_CODES.M)
//    public static boolean checkFinger(Context ctx) {
//
//        // Keyguard Manager
//        KeyguardManager keyguardManager = (KeyguardManager) ctx.getSystemService(KEYGUARD_SERVICE);
//        // Fingerprint Manager
//        FingerprintManager fingerprintManager = (FingerprintManager) ctx.getSystemService(FINGERPRINT_SERVICE);
//
//        try {
//            // Check if the fingerprint sensor is present
//            if (!fingerprintManager.isHardwareDetected()) {
//                // Update the UI with a message
//                return false;
//            }
//
//            if (!fingerprintManager.hasEnrolledFingerprints()) {
//                return false;
//            }
//
//            if (!keyguardManager.isKeyguardSecure()) {
//                return false;
//            }
//        }
//        catch(SecurityException se) {
//            se.printStackTrace();
//        }
//        return true;
//    }
//}
