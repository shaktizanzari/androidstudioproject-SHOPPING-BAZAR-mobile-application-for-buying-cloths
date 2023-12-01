package com.example.approject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    private TextView cartItemsTextView;
    private TextView total;
    private Cart cart;

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
        placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the RegisterActivity when the button is clicked
                Intent intent = new Intent(CartActivity.this, Register.class);
                startActivity(intent);
            }
        });
    }
}
