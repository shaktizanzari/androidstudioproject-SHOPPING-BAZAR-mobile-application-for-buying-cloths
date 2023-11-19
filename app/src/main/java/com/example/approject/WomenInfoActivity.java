package com.example.approject;

import androidx.appcompat.app.AppCompatActivity;
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
import android.os.Bundle;

public class WomenInfoActivity extends AppCompatActivity {
    Toolbar t;
    ImageView i1;
    ImageView i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_info);


        t = findViewById(R.id.toolbar);
        setSupportActionBar(t);

        i=findViewById(R.id.ic_cart);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(WomenInfoActivity.this, CartActivity.class);
                startActivity(intent);
                Toast.makeText(WomenInfoActivity.this, "Cart icon clicked", Toast.LENGTH_SHORT).show();
            }
        });

        i1=findViewById(R.id.peppy);
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu p=new PopupMenu(WomenInfoActivity.this, i1);
                p.getMenuInflater().inflate(R.menu.menu,p.getMenu());
                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getTitle().toString()){
                            case "add to cart":Toast.makeText(WomenInfoActivity.this, "added to cart",Toast.LENGTH_SHORT).show();
                                Cart cart=Cart.getInstance();
                                cart.addItem("silk green saree", 5000);
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