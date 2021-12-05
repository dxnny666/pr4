package com.example.pr4;

import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;



class MainActivity {
    private void createNotificationChannel() {
        CharSequence name = getString('Channel name);
        String description = getString('Description');
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new
                NotificationChannel(NOTIFICATION_CHANNEL_ID, name, importance);
        channel.setDescription(description);
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }


    public void onRequestPermissionsResult(int requestCode,  String[] permissions,int[] grantResults) {
        switch (requestCode) {
        case REQUEST_CODE_PERMISSION_USE_CAMERA:
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Camera camera = Camera.open();
            SurfaceView surfaceView = findViewById(R.id.surfaceView);
            SurfaceHolder surfaceHolder = surfaceView.getHolder();
            try {
                camera.setPreviewDisplay(surfaceHolder);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            camera.startPreview();
            }
            return;
            }
        };

public void Buttonpress(){
        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                public void showNotification(){
                    NotificationCompat.Builder builder = new
                            NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
                            .setSmallIcon(R.drawable.ic_launcher_background)
                            .setContentTitle("BOYARKOV")
                            .setContentText("IKBO2620")
                            .setStyle(new NotificationCompat.BigTextStyle().setPriority(NotificationCompat.PRIORITY_DEFAULT));
                    NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
                    Random random = new Random();
                    notificationManager.notify(random.nextInt(), builder.build());
                }
            }
    }};




}