package com.example.approject;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;

public class MenInfoActivity extends AppCompatActivity {
    Toolbar t;
    ImageButton i1, i2;
    ImageView i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men_info);

        t = findViewById(R.id.toolbar);
        setSupportActionBar(t);

        i=findViewById(R.id.ic_cart);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MenInfoActivity.this, CartActivity.class);
                startActivity(intent);
                Toast.makeText(MenInfoActivity.this, "Cart icon clicked", Toast.LENGTH_SHORT).show();
            }
        });

        i1=findViewById(R.id.pasta1);
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu p=new PopupMenu(MenInfoActivity.this, i1);
                p.getMenuInflater().inflate(R.menu.menu,p.getMenu());
                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getTitle().toString()){
                            case "add to cart":Toast.makeText(MenInfoActivity.this, "added to cart",Toast.LENGTH_SHORT).show();
                                Cart cart=Cart.getInstance();
                                cart.addItem("blue georgette kurta", 400);
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                p.show();
            }
        });

        i2=findViewById(R.id.pasta2);
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu p=new PopupMenu(MenInfoActivity.this, i2);
                p.getMenuInflater().inflate(R.menu.menu,p.getMenu());
                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getTitle().toString()){
                            case "add to cart":Toast.makeText(MenInfoActivity.this, "added to cart",Toast.LENGTH_SHORT).show();
                                Cart cart=Cart.getInstance();
                                cart.addItem("maroon manyawar", 1000);
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                p.show();
            }
        });
    }

    private void create_menu(Menu menu){
        MenuItem mn1 = menu.add(0, 0, 0, "Men");
        mn1.setAlphabeticShortcut('a');
        mn1.setIcon(R.drawable.ic_launcher_foreground);
        SubMenu menu1= menu.addSubMenu(0,1,1,"Women");
        menu1.add(0,21,1,"Sarees");
        menu1.add(0,22,2,"Salwar suits");

    }

    private boolean Menuchoice(MenuItem item){
        switch (item.getItemId()){
            case 0:Toast.makeText(this,"Men is selected",Toast.LENGTH_SHORT).show();
                MenInfoActivity();
                return true;

            case 21:Toast.makeText(this,"Sarees is selected",Toast.LENGTH_SHORT).show();
                WomenInfoActivity();
                return true;

            case 22:Toast.makeText(this,"Salwar suits is selected",Toast.LENGTH_SHORT).show();
            WomenSuitActivity();
                return true;

            default:
                return false;
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        return Menuchoice(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        create_menu(menu);
        return true;
    }
    private void MenInfoActivity() {
        Intent intent = new Intent(this, MenInfoActivity.class);
        startActivity(intent);
    }

    private void WomenInfoActivity(){
        Intent intent=new Intent(this, WomenInfoActivity.class);
        startActivity(intent);
    }
    private void WomenSuitActivity(){
        Intent intent=new Intent(this, WomenSuitActivity.class);
        startActivity(intent);
    }
}