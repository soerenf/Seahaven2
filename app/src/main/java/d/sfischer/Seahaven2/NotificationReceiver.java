package d.sfischer.Seahaven2;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import static d.sfischer.Seahaven2.DataCollectionActivity.acTime;
import static d.sfischer.Seahaven2.DataCollectionActivity.callTiming;
import static d.sfischer.Seahaven2.DataCollectionActivity.gettime;
import static d.sfischer.Seahaven2.DataCollectionActivity.normalAudioTiming;
import static d.sfischer.Seahaven2.DataCollectionActivity.ringTiming;
import static d.sfischer.Seahaven2.DataCollectionActivity.usbTime;
import static d.sfischer.Seahaven2.DataCollectionActivity.voipTiming;
//import android.widget.Toast;

public class NotificationReceiver extends BroadcastReceiver {




    // wie bekomme ich raus von welcher notfication ich komme über die ID von .notify?
    // close notification nach click
    // oder jedes eigenes Intent? also YES_ACTION_STILL, YES_ACTION_USB etc.?
    // vllt auch die FLAGS bei hedwig entscheident bei one shot immerhin nur einmal klicken...aber sonst keine verbesserung
    // immutable flag zeigt keine veränderung...
    //getActivity statt broadcast?
    // intent in xml anpassen zu singleXXX?


    @Override
    public void onReceive ( Context context, Intent intent ) {

        String action = intent.getAction ();

        Bundle extras = intent.getExtras ();

        // cancel brauch die ID mit der deliverNotification aufgerufen wurde containsKey den String aus add Extra also caller


        if (action != null && action.equals (Hedwig.YES_ACTION)) {

            System.out.println ("Yes was pressed ");

            if (extras != null) {

                if (extras.containsKey ("Driving")) {
                    System.out.println ("Driving ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Gefahren mit Fahrzeug: ",gettime (), 0, 1, time);
                    if (manager != null) {
                        manager.cancel (0);
                    }
                }

                if (extras.containsKey ("Airplane")) {
                    System.out.println ("Airplane ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Geflogen: ",gettime (), 0, 1, time);
                    if (manager != null) {
                        manager.cancel (200);
                    }
                }

                if (extras.containsKey ("Bicycle")) {
                    System.out.println ("Bicycle ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Gefahren mit Fahrrad o.ä.: ",gettime (), 0, 1, time);
                    if (manager != null) {
                        manager.cancel (1);
                    }
                }
                if (extras.containsKey ("Foot")) {
                    System.out.println ("Foot ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Zu Fuß: ",gettime (), 0, 1, time);
                    if (manager != null) {
                        manager.cancel (2);
                    }
                }
                if (extras.containsKey ("Running")) {
                    System.out.println ("Running ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Gerannt: ",gettime (), 0, 1, time);
                    if (manager != null) {
                        manager.cancel (3);
                    }
                }
                if (extras.containsKey ("Still")) {
                    System.out.println ("Still ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Still: ",gettime (), 0, 1, time);
                    //funktioniert, Zeit der Aktion wird festgehalten und nicht Zeit des klickens
                    //Long date = extras.getLong ("timing");

                    if (manager != null) {
                        manager.cancel (4);
                    }

                }

                if (extras.containsKey ("Tilting")) {
                    System.out.println ("Tilting ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Geneigt: ",gettime (), 0, 1, time);
                    if (manager != null) {
                        manager.cancel (5);
                    }
                }
                if (extras.containsKey ("Walking")) {
                    System.out.println ("Walking ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Gegangen: ",gettime (), 0, 1, time);
                    if (manager != null) {
                        manager.cancel (6);
                    }
                }

                if (extras.containsKey ("Battery Ok")) {
                    System.out.println ("Battery Ok ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Battery Ok: ",gettime (), 0, 1, time);
                    if (manager != null) {
                        manager.cancel (10);
                    }
                }
                if (extras.containsKey ("Battery Low")) {
                    System.out.println ("Battery Low ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Battery Low: ",gettime (), 0, 1, time);
                    if (manager != null) {
                        manager.cancel (12);
                    }
                }
                if (extras.containsKey ("Plugged AC")) {
                    System.out.println ("AC ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Smartphone geladen: ",gettime (), 0, 1, acTime + " - "+ time);
                    if (manager != null) {
                        manager.cancel (13);
                    }
                }
                if (extras.containsKey ("Plugged USB")) {
                    System.out.println ("USB ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"An Rechner angeschlossen: ",gettime (), 0, 1, usbTime + " - "+ time);
                    if (manager != null) {
                        manager.cancel (14);
                    }

                }

                if (extras.containsKey ("Powerbank")) {
                    System.out.println ("Powerbank ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Powerbank genutzt: ",gettime (), 0, 1, time);
                    if (manager != null) {
                        manager.cancel (131);
                    }
                }

                if (extras.containsKey ("Wecker"))
                {
                    System.out.println ("Wecker ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Wecker war gestellt auf: ",gettime (), 0, 1, time);
                    if (manager != null) {
                        manager.cancel (99);
                    }
                }


                if (extras.containsKey ("Sleep"))
                {
                    System.out.println ("Sleep ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Schlafdauer ermittelt",gettime (), 0, 1, time);
                    if (manager != null) {
                        manager.cancel (7777);
                    }
                }

                if (extras.containsKey ("Telefonat"))
                {
                    System.out.println ("Telefonat ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Telefonat aktiv ",gettime (), 0, 1,": "+ callTiming + " - "+ normalAudioTiming);
                    if (manager != null) {
                        manager.cancel (98);
                    }
                }

                if (extras.containsKey ("VOIP-Telefonat"))
                {
                    System.out.println ("VOIP-Telefonat ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"VOIP-Telefonat aktiv ",gettime (), 0, 1, ": "+ voipTiming + " - "+ normalAudioTiming);
                    if (manager != null) {
                        manager.cancel (97);
                    }
                }


                if (extras.containsKey ("Ringing"))
                {
                    System.out.println ("Ringing ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Ringing ",gettime (), 0, 1, ": "+ ringTiming + " - "+ normalAudioTiming);
                    if (manager != null) {
                        manager.cancel (96);
                    }
                }

                if (extras.containsKey ("Provider"))
                {
                    System.out.println ("Provider ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Handy-Provider erkannt ",gettime (), 0, 1, " ");
                    if (manager != null) {
                        manager.cancel (700);
                    }
                }


                if (extras.containsKey ("Kinder"))
                {
                    System.out.println ("Kinder ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context), "Kinder-App installiert ", gettime (), 0, 1, " ");
                    if (manager != null) {
                        manager.cancel (101);
                    }
                }
                if (extras.containsKey ("Dating"))
                {
                    System.out.println ("Dating ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context), "Dating-App installiert ", gettime (), 0, 1, " ");
                    if (manager != null) {
                        manager.cancel (69);
                    }
                }
                if (extras.containsKey ("Banking"))
                {
                    System.out.println ("Banking ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context), "Banking-App installiert ", gettime (), 0, 1, " ");
                    if (manager != null) {
                        manager.cancel (100);
                    }
                }

                if (extras.containsKey ("wigle.net")) {
                    System.out.println ("wigle.net ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Standort ermittelt",gettime (), 0, 1, time);
                    if (manager != null) {
                        manager.cancel (500);
                    }
                }

                if (extras.containsKey ("Location")) {
                    System.out.println ("Location ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"In Stadt aufgehalten",gettime (), 0, 1, time);
                    if (manager != null) {
                        manager.cancel (501);
                    }
                }

                if (extras.containsKey ("Known Location")) {
                    System.out.println ("Known Location ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Bekannter Ort erkannt",gettime (), 0, 1, time);
                    if (manager != null) {
                        manager.cancel (200);
                    }
                }

                if (extras.containsKey ("Home Location")) {
                    System.out.println ("Home Location ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Zu Hause erkannt",gettime (), 0, 1, time);
                    if (manager != null) {
                        manager.cancel (201);
                    }
                }
                if (extras.containsKey ("Home City")) {
                    System.out.println ("Home City ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Heimatstadt erkannt",gettime (), 0, 1, time);
                    if (manager != null) {
                        manager.cancel (2001);
                    }
                }



            }
        }
        if (action != null && action.equals (Hedwig.NO_ACTION)) {
            System.out.println ("No was pressed ");

            if (extras != null) {

                if (extras.containsKey ("Driving")) {
                    System.out.println ("Driving ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context), "Gefahren mit Fahrzeug: ", gettime (), 0, 0, time);
                    if (manager != null) {
                        manager.cancel (0);
                    }
                }

                if (extras.containsKey ("Airplane")) {
                    System.out.println ("Airplane ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Geflogen: ",gettime (), 0, 0, time);
                    if (manager != null) {
                        manager.cancel (200);
                    }
                }
                if (extras.containsKey ("Bicycle")) {
                    System.out.println ("Bicycle ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context), "Gefahren mit Fahrrad o.ä.: ", gettime (), 0, 0, time);
                    if (manager != null) {
                        manager.cancel (1);
                    }
                }
                if (extras.containsKey ("Foot")) {
                    System.out.println ("Foot ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context), "Zu Fuß: ", gettime (), 0, 0, time);
                    if (manager != null) {
                        manager.cancel (2);
                    }
                }
                if (extras.containsKey ("Running")) {
                    System.out.println ("Running ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context), "Gerannt: ", gettime (), 0, 0, time);
                    if (manager != null) {
                        manager.cancel (3);
                    }
                }
                if (extras.containsKey ("Still")) {
                    System.out.println ("Still ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context), "Still: ", gettime (), 0, 0, time);
                    if (manager != null) {
                        manager.cancel (4);
                    }
                }

                if (extras.containsKey ("Tilting")) {
                    System.out.println ("Tilting ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context), "Geneigt: ", gettime (), 0, 0, time);
                    if (manager != null) {
                        manager.cancel (5);
                    }
                }
                if (extras.containsKey ("Walking")) {
                    System.out.println ("Walking ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context), "Gegangen: ", gettime (), 0, 0, time);
                    if (manager != null) {
                        manager.cancel (6);
                    }
                }

                if (extras.containsKey ("Battery Ok")) {
                    System.out.println ("Battery Ok ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Battery Ok: ",gettime (), 0, 0, time);
                    if (manager != null) {
                        manager.cancel (10);
                    }
                }
                if (extras.containsKey ("Battery Low")) {
                    System.out.println ("Battery Low ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Battery Low: ",gettime (), 0, 0, time);
                    if (manager != null) {
                        manager.cancel (12);
                    }
                }
                if (extras.containsKey ("Plugged AC")) {
                    System.out.println ("AC ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Smartphone geladen: ",gettime (), 0, 0, acTime + " - "+ time);
                    if (manager != null) {
                        manager.cancel (13);
                    }
                }
                if (extras.containsKey ("Plugged USB")) {
                    System.out.println ("USB ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"An Rechner angeschlossen: ",gettime (), 0, 0, usbTime + " - "+ time);
                    if (manager != null) {
                        manager.cancel (14);
                    }
                }



                if (extras.containsKey ("Powerbank")) {
                    System.out.println ("Powerbank ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Powerbank genutzt: ",gettime (), 0, 0, time);
                    if (manager != null) {
                        manager.cancel (131);
                    }
                }

                if (extras.containsKey ("Wecker"))
                {
                    System.out.println ("Wecker ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Wecker war gestellt auf: ",gettime (), 0, 0, time);
                    if (manager != null) {
                        manager.cancel (99);
                    }
                }

                if (extras.containsKey ("Sleep"))
                {
                    System.out.println ("Sleep ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Schlafdauer ermittelt",gettime (), 0, 0, time);
                    if (manager != null) {
                        manager.cancel (7777);
                    }
                }

                if (extras.containsKey ("Telefonat"))
                {
                    System.out.println ("Telefonat ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Telefonat aktiv ",gettime (), 0, 0,": "+ callTiming + " - "+ normalAudioTiming);
                    if (manager != null) {
                        manager.cancel (98);
                    }
                }

                if (extras.containsKey ("VOIP-Telefonat"))
                {
                    System.out.println ("VOIP-Telefonat ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"VOIP-Telefonat aktiv ",gettime (), 0, 0, ": "+ voipTiming + " - "+ normalAudioTiming);
                    if (manager != null) {
                        manager.cancel (97);
                    }
                }

                if (extras.containsKey ("Ringing"))
                {
                    System.out.println ("Ringing ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Ringing ",gettime (), 0, 0, ": "+ ringTiming + " - "+ normalAudioTiming);
                    if (manager != null) {
                        manager.cancel (96);
                    }
                }

                if (extras.containsKey ("Provider"))
                {
                    System.out.println ("Provider ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Handy-Provider erkannt ",gettime (), 0, 0, " ");
                    if (manager != null) {
                        manager.cancel (700);
                    }
                }

                if (extras.containsKey ("Kinder"))
                {
                    System.out.println ("Kinder ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context), "Kinder-App installiert ", gettime (), 0, 0, " ");
                    if (manager != null) {
                        manager.cancel (101);
                    }
                }
                if (extras.containsKey ("Dating"))
                {
                    System.out.println ("Dating ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context), "Dating-App installiert ", gettime (), 0, 0, " ");
                    if (manager != null) {
                        manager.cancel (69);
                    }
                }
                if (extras.containsKey ("Banking"))
                {
                    System.out.println ("Banking ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context), "Banking-App installiert ", gettime (), 0, 0, " ");
                    if (manager != null) {
                        manager.cancel (100);
                    }
                }


                if (extras.containsKey ("wigle.net")) {
                    System.out.println ("wigle.net ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Standort ermittelt",gettime (), 0, 0, time);
                    if (manager != null) {
                        manager.cancel (500);
                    }
                }

                if (extras.containsKey ("Location")) {
                    System.out.println ("Location ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"grob Standort ermittelt",gettime (), 0, 0, time);
                    if (manager != null) {
                        manager.cancel (501);
                    }
                }

                if (extras.containsKey ("Known Location")) {
                    System.out.println ("Known Location ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Bekannten Ort erkannt",gettime (), 0, 0, time);
                    if (manager != null) {
                        manager.cancel (200);
                    }
                }

                if (extras.containsKey ("Home Location")) {
                    System.out.println ("Home Location ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Zu Hause erkannt",gettime (), 0, 0, time);
                    if (manager != null) {
                        manager.cancel (201);
                    }
                }

                if (extras.containsKey ("Home City")) {
                    System.out.println ("Home City ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Heimatstadt erkannt",gettime (), 0, 0, time);
                    if (manager != null) {
                        manager.cancel (2001);
                    }
                }


            }
        }
        if (action != null && action.equals (Hedwig.MAYBE_ACTION)) {
            System.out.println ("Maybe was pressed ");
            if (extras != null) {

                if (extras.containsKey ("Driving")) {
                    System.out.println ("Driving ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context), "Gefahren mit Fahrzeug: ", gettime (), 0, 2, time);
                    if (manager != null) {
                        manager.cancel (0);
                    }
                }

                if (extras.containsKey ("Airplane")) {
                    System.out.println ("Airplane ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Geflogen: ",gettime (), 0, 2, time);
                    if (manager != null) {
                        manager.cancel (200);
                    }
                }

                if (extras.containsKey ("Bicycle")) {
                    System.out.println ("Bicycle ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context), "Gefahren mit Fahrrad o.ä.: ", gettime (), 0, 2, time);
                    if (manager != null) {
                        manager.cancel (1);
                    }
                }
                if (extras.containsKey ("Foot")) {
                    System.out.println ("Foot ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context), "Zu Fuß: ", gettime (), 0, 2, time);
                    if (manager != null) {
                        manager.cancel (2);
                    }
                }
                if (extras.containsKey ("Running")) {
                    System.out.println ("Running ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context), "Gerannt: ", gettime (), 0, 2, time);
                    if (manager != null) {
                        manager.cancel (3);
                    }
                }
                if (extras.containsKey ("Still")) {
                    System.out.println ("Still ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context), "Still: ", gettime (), 0, 2, time);
                    if (manager != null) {
                        manager.cancel (4);
                    }
                }

                if (extras.containsKey ("Tilting")) {
                    System.out.println ("Tilting ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context), "Geneigt: ", gettime (), 0, 2, time);
                    if (manager != null) {
                        manager.cancel (5);
                    }
                }
                if (extras.containsKey ("Walking")) {
                    System.out.println ("Walking ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context), "Gegangen: ", gettime (), 0, 0, time);
                    if (manager != null) {
                        manager.cancel (6);
                    }
                }

                if (extras.containsKey ("Battery Ok")) {
                    System.out.println ("Battery Ok ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Battery Ok: ",gettime (), 0, 2, time);
                    if (manager != null) {
                        manager.cancel (10);
                    }
                }
                if (extras.containsKey ("Battery Low")) {
                    System.out.println ("Battery Low ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Battery Low: ",gettime (), 0, 2, time);
                    if (manager != null) {
                        manager.cancel (12);
                    }
                }
                if (extras.containsKey ("Plugged AC")) {
                    System.out.println ("AC ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Smartphone geladen: ",gettime (), 0, 2, acTime + " - "+ time);
                    if (manager != null) {
                        manager.cancel (13);
                    }
                }
                if (extras.containsKey ("Plugged USB")) {
                    System.out.println ("USB ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"An Rechner angeschlossen: ",gettime (), 0, 2, usbTime + " - "+ time);
                    if (manager != null) {
                        manager.cancel (14);
                    }
                }


                if (extras.containsKey ("Powerbank")) {
                    System.out.println ("Powerbank ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Powerbank genutzt: ",gettime (), 0, 2, time);
                    if (manager != null) {
                        manager.cancel (131);
                    }
                }

                if (extras.containsKey ("Wecker"))
                {
                    System.out.println ("Wecker ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Wecker war gestellt auf: ",gettime (), 0, 2, time);
                    if (manager != null) {
                        manager.cancel (99);
                    }
                }

                if (extras.containsKey ("Sleep"))
                {
                    System.out.println ("Sleep ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Schlafdauer ermittelt",gettime (), 0, 2, time);
                    if (manager != null) {
                        manager.cancel (7777);
                    }
                }

                if (extras.containsKey ("Telefonat"))
                {
                    System.out.println ("Telefonat ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Telefonat aktiv ",gettime (), 0, 2,": "+ callTiming + " - "+ normalAudioTiming);
                    if (manager != null) {
                        manager.cancel (98);
                    }
                }

                if (extras.containsKey ("VOIP-Telefonat"))
                {
                    System.out.println ("VOIP-Telefonat ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"VOIP-Telefonat aktiv ",gettime (), 0, 2, ": "+ voipTiming + " - "+ normalAudioTiming);
                    if (manager != null) {
                        manager.cancel (97);
                    }
                }

                if (extras.containsKey ("Ringing"))
                {
                    System.out.println ("Ringing ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Ringing ",gettime (), 0, 2, ": "+ ringTiming + " - "+ normalAudioTiming);
                    if (manager != null) {
                        manager.cancel (96);
                    }
                }

                if (extras.containsKey ("Provider"))
                {
                    System.out.println ("Provider ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Handy-Provider erkannt ",gettime (), 0, 2, " ");
                    if (manager != null) {
                        manager.cancel (700);
                    }
                }

                if (extras.containsKey ("Kinder"))
                {
                    System.out.println ("Kinder ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context), "Kinder-App installiert ", gettime (), 0, 2, " ");
                    if (manager != null) {
                        manager.cancel (101);
                    }
                }
                if (extras.containsKey ("Dating"))
                {
                    System.out.println ("Dating ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context), "Dating-App installiert ", gettime (), 0, 2, " ");
                    if (manager != null) {
                        manager.cancel (69);
                    }
                }
                if (extras.containsKey ("Banking"))
                {
                    System.out.println ("Banking ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context), "Banking-App installiert ", gettime (), 0, 2, " ");
                    if (manager != null) {
                        manager.cancel (100);
                    }
                }

                if (extras.containsKey ("wigle.net")) {
                    System.out.println ("wigle.net ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Standort ermittelt",gettime (), 0, 2, time);
                    if (manager != null) {
                        manager.cancel (500);
                    }
                }

                if (extras.containsKey ("Location")) {
                    System.out.println ("Location ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"groben Standort ermittelt",gettime (), 0, 2, time);
                    if (manager != null) {
                        manager.cancel (501);
                    }
                }

                if (extras.containsKey ("Known Location")) {
                    System.out.println ("Known Location ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Bekannten Ort aufgesucht",gettime (), 0, 2, time);
                    if (manager != null) {
                        manager.cancel (200);
                    }
                }

                if (extras.containsKey ("Home Location")) {
                    System.out.println ("Home Location ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Zu Hause aufgehalten",gettime (), 0, 2, time);
                    if (manager != null) {
                        manager.cancel (201);
                    }
                }

                if (extras.containsKey ("Home City")) {
                    System.out.println ("Home City ");
                    NotificationManager manager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);
                    String time = extras.getString ("timing");
                    DatabaseInitializer.addToAsync (AppDatabase.getAppDatabase (context),"Heimatstadt erkannt",gettime (), 0, 2, time);
                    if (manager != null) {
                        manager.cancel (2001);
                    }
                }

            }

        }
    }
}