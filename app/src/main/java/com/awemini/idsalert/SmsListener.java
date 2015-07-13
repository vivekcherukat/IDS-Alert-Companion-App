package com.awemini.idsalert;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Vivek on 4/30/2015.
 *//*public class SmsListener extends BroadcastReceiver {

    private SharedPreferences preferences;

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        Log.i("com.awemini.idsalert", "KOKACHI");
        *//*if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
            Bundle bundle = intent.getExtras();           //---get the SMS message passed in---
            SmsMessage[] msgs = null;
            Log.i("com.awemini.idsalert","Oohlahlah1");
            String msg_from;
            if (bundle != null){
                //---retrieve the SMS message received---
                try{
                    Object[] pdus = (Object[]) bundle.get("pdus");
                    msgs = new SmsMessage[pdus.length];
                    Log.i("com.awemini.idsalert","Oohlahlah2");
                    for(int i=0; i<msgs.length; i++){
                        msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                        msg_from = msgs[i].getOriginatingAddress();
                           String msgBody = msgs[i].getMessageBody();
                        //Log.i("Message:",msgBody);
                        if(msgBody.equals("1234")){

                            Log.i("com.awemini.idsalert","Oohlahlah");
                        }
                    }

                }catch(Exception e){
//                            Log.d("Exception caught",e.getMessage());
                }
            }
        }*//*

            if (Telephony.Sms.Intents.SMS_RECEIVED_ACTION.equals(intent.getAction())) {
                Log.i("com.awemini.idsalert","Oohlahlah1");
                for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
                    Log.i("com.awemini.idsalert","Oohlahlah2");
                    String messageBody = smsMessage.getMessageBody();
//                    Log.i("com.awemini.idsalert",messageBody);
                    if(messageBody.equals("1234")){

                        Log.i("com.awemini.idsalert","Oohlahlah");
                }
                }


            }




    }


       *//* @Override
        public void onReceive(Context context, Intent intent) {
            if (Telephony.Sms.Intents.SMS_RECEIVED_ACTION.equals(intent.getAction())) {
                for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
                    String messageBody = smsMessage.getMessageBody();
                }
            }
        }*//*




}*/






public class SmsListener extends BroadcastReceiver {

    // Get the object of SmsManager
    final SmsManager sms = SmsManager.getDefault();

    public void onReceive(Context context, Intent intent) {

        // Retrieves a map of extended data from the intent.
        final Bundle bundle = intent.getExtras();

        try {

            if (bundle != null) {

                final Object[] pdusObj = (Object[]) bundle.get("pdus");

                for (int i = 0; i < pdusObj.length; i++) {

                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    String phoneNumber = currentMessage.getDisplayOriginatingAddress();

                    String senderNum = phoneNumber;
                    String message = currentMessage.getDisplayMessageBody();

                    Log.i("SmsReceiver", "senderNum: "+ senderNum + "; message: " + message);


                    // Show Alert
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context,
                            "senderNum: "+ senderNum + ", message: " + message, duration);
                    toast.show();

                   /* try {
                        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                        Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                        r.play();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }*/
                    String pattern = "(.)555#(.)";
                    Pattern r = Pattern.compile(pattern);
                    Matcher m = r.matcher(message);
                    if(m.find()){

                        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.play2);
                        mediaPlayer.start(); // no need to call prepare(); create() does that for you
                        Log.i("SmsReceiver","Oohlahlah");
                        Log.i("com.awemini.idsalert","Oohlahlah");
                    }

                } // end for loop
            } // bundle is null

        } catch (Exception e) {
            Log.e("SmsReceiver", "Exception smsReceiver" +e);

        }
    }



}