package com.example.approject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    private TextView cartItemsTextView;
    private TextView total;
    private Cart cart;
    private NotificationManager mManager;
    // Notification channel ID and name
    private static final String CHANNEL_ID = "food_delivery_channel";
    private static final String CHANNEL_NAME = "Food Delivery";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartItemsTextView = findViewById(R.id.cartItemsTextView);
        total = findViewById(R.id.total);
        cart = Cart.getInstance();

        StringBuilder itemsText = new StringBuilder();
        ArrayList<ProductInfo> items = cart.getItems();
        for (ProductInfo item : items) {
            itemsText.append(item.getName()).append("\n");
        }

        double totalPrice = cart.calculateTotalPrice();
        total.setText("Total price = " + totalPrice);

        cartItemsTextView.setText(itemsText.toString());

        Button placeOrderButton = findViewById(R.id.placeorder);
//        placeOrderButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Generate a notification
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                    createNotificationChannel();
//                }
//                NotificationCompat.Builder builder = getChannelNotification(
//                        "Thank you for ordering.", "Your food will be delivered in...");
//                Intent intent = new Intent(CartActivity.this, DeliveryTimeActivity.class);
//                PendingIntent resultPendingIntent = PendingIntent.getActivity(
//                        CartActivity.this, 0, intent, PendingIntent.FLAG_MUTABLE);
//                builder.setContentIntent(resultPendingIntent);
//                Toast.makeText(CartActivity.this, "hgghg", Toast.LENGTH_SHORT).show();
//                mManager.notify(1, builder.build());
//            }
//        });
//    }
//
//    private void createNotificationChannel() {
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//            NotificationChannel channel = new NotificationChannel(
//                    CHANNEL_ID, CHANNEL_NAME,
//                    NotificationManager.IMPORTANCE_DEFAULT);
//            if (mManager == null) {
//                mManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//            }
//            mManager.createNotificationChannel(channel);
//        }
//    }
//
//    private NotificationCompat.Builder getChannelNotification(String title, String message) {
//        return new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
//                .setSmallIcon(R.drawable.ic_cart)
//                .setContentTitle(title)
//                .setContentText(message)
//                .setAutoCancel(true);
    }
}
