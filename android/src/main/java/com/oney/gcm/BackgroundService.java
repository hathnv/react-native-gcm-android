//package com.oney.gcm;
//
//import android.app.Service;
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.IBinder;
//import android.util.Log;
//
//import com.facebook.react.LifecycleState;
//import com.facebook.react.ReactInstanceManager;
//
//import java.lang.reflect.Field;
//
//import io.neson.react.notification.NotificationPackage;
//
//public class BackgroundService extends Service {
//    private static final String TAG = "BackgroundService";
//    private ReactInstanceManager mReactInstanceManager;
//
//    @Override
//    public IBinder onBind(Intent intent) {
//        return null;
//    }
//
//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//      final  Bundle bundle = intent.getBundleExtra("bundle");
//        Object result = bundle.get("info");
//        String data   = result.toString();
//        Log.d(TAG, mReactInstanceManager.toString());
////        String id     = bundle.get("google.message_id").toString();
////        try{
////            JSONObject jsonObj = new JSONObject(data);
////            Log.d(TAG,"onStartCommand jsonObj => :"+jsonObj);
////            Log.d(TAG,"onStartCommand bundle => :"+bundle);
////            String message = jsonObj.getString("message");
////            String subject = jsonObj.getString("subject");
////            Object badgeObj = bundle.get("badge");
////            String badge = badgeObj.toString();
////            Integer notificationId = Integer.parseInt(id.substring(0, 10).replaceAll("[\\D]", ""));
////
////            NotificationAttributes attributes = new NotificationAttributes();
////            attributes.delayed = false;
////            attributes.scheduled = false;
////            attributes.autoClear = true;
////            attributes.inboxStyle = false;
////            attributes.priority = 1;
////            attributes.sound = "default";
////            attributes.smallIcon = "ic_launcher";
////            attributes.message = message;
////            attributes.subject = subject;
////            attributes.payload = data;
////            Notification notification = new Notification(this, notificationId, attributes);
////            notification.create();
////            Integer badgeCount = Integer.parseInt(badge);
////            Context context = getApplicationContext();
////            ShortcutBadger.applyCount(context, badgeCount);
////
////        }catch (JSONException e) {
////            Log.d(TAG,e.toString());
////        }
////        return START_NOT_STICKY;
////        ReactNativeHost mReactNativeHost =
////                new ReactNativeHost(this) {
////                    @Override
////                    public boolean getUseDeveloperSupport() {
////                        return BuildConfig.DEBUG;
////                    }
////
////                    @Override
////                    protected List<ReactPackage> getPackages() {
////                        @SuppressWarnings("UnnecessaryLocalVariable")
////                        List<ReactPackage> packages = new PackageList(this).getPackages();
////                        // Packages that cannot be autolinked yet can be added manually here, for example:
////                        return packages;
////                    }
////
////                    @Override
////                    protected String getJSMainModuleName() {
////                        return "index";
////                    }
////                };
//        mReactInstanceManager = ReactInstanceManager.builder()
//                .setApplication(getApplication())
//                .setBundleAssetName("index.android.bundle")
//                .setJSMainModuleName("index.android")
//                .addPackage(new MainReactPackage())
//                .addPackage(new GcmPackage(intent))
//                .addPackage(new NotificationPackage())
//                .setUseDeveloperSupport(getBuildConfigDEBUG())
//                .setInitialLifecycleState(LifecycleState.RESUMED)
//                .build();
//        mReactInstanceManager.createReactContextInBackground();
//
////        Handler handler = new Handler(Looper.getMainLooper());
////        handler.post(new Runnable() {
////            public void run() {
////                // Construct and load our normal React JS code bundle
////                ReactInstanceManager mReactInstanceManager = ((ReactApplication) getApplication()).getReactNativeHost().getReactInstanceManager();
////                ReactContext context = mReactInstanceManager.getCurrentReactContext();
////                // If it's constructed, send a notification
////                if (context != null) {
////                    handleRemotePushNotification((ReactApplicationContext) context, bundle);
////                } else {
////                    // Otherwise wait for construction, then send the notification
////                    mReactInstanceManager.addReactInstanceEventListener(new ReactInstanceManager.ReactInstanceEventListener() {
////                        public void onReactContextInitialized(ReactContext context) {
////                            handleRemotePushNotification((ReactApplicationContext) context, bundle);
////                        }
////                    });
////                    if (!mReactInstanceManager.hasStartedCreatingInitialContext()) {
////                        // Construct it in the background
////                        mReactInstanceManager.createReactContextInBackground();
////                    }
////                }
////            }
////        });
//
//        return START_NOT_STICKY;
//    }
//
//
//    @Override
//    public void onDestroy() {
//        Log.d(TAG, "onDestroy");
//        super.onDestroy();
////        mReactInstanceManager.onPause();
////        mReactInstanceManager.onDestroy();
//        mReactInstanceManager = null;
//    }
//
//    private Class getBuildConfigClass() {
//        try {
//            String packageName = getPackageName();
//
//            return Class.forName(packageName + ".BuildConfig");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//    private boolean getBuildConfigDEBUG() {
//        Class klass = getBuildConfigClass();
//        for (Field f : klass.getDeclaredFields()) {
//            if (f.getName().equals("DEBUG")) {
//                try {
//                    return f.getBoolean(this);
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return false;
//    }
//}
