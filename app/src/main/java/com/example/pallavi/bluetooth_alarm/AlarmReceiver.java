package com.example.pallavi.bluetooth_alarm;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;

public class AlarmReceiver extends BroadcastReceiver
{

    BluetoothDevice device;
    BluetoothSocket socket;
    OutputStream outputStream;

    String command;
    @Override
    public void onReceive(Context context, Intent intent)
    {

        command = "F";

        try
        {
            outputStream.write(command.getBytes()); //transmits the value of command to the bluetooth module
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


        Toast.makeText(context, "Alarm! Wake up! Wake up!", Toast.LENGTH_LONG).show();
        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (alarmUri == null)
        {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        Ringtone ringtone = RingtoneManager.getRingtone(context, alarmUri);
        ringtone.play();


    }
}
