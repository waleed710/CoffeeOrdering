package com.example.waleed.coffeeordering;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    int quantity = 0, topping = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void DecrementQuantity(View view){
        if(quantity != 0){
            TextView qtyDigt = (TextView) findViewById(R.id.qtyDigitTextView);
            qtyDigt.setText("" + --quantity);
        }
        else{
            Toast.makeText(getApplicationContext(), "Already 0 Cup", Toast.LENGTH_SHORT).show();
        }
    }

    public void IncrementQuantity(View view){
        TextView qtyDigt = (TextView) findViewById(R.id.qtyDigitTextView);
        qtyDigt.setText("" + ++quantity);
    }

    public void Check(View view){
        CheckBox chkBox = (CheckBox) findViewById(R.id.chocolateCheckBox);
        if(chkBox.isChecked()){
            topping = 100;
            Toast.makeText(getApplicationContext(), "You have added Chocolate Topping (Charges:$100)", Toast.LENGTH_SHORT).show();
        }
        else{
            topping = 0;
        }
    }

    public void CalculateBill(View view){
            TextView priceDigt = (TextView) findViewById(R.id.PriceDigitTextView);
            priceDigt.setText("$" + ((quantity * 5) + topping));
    }

    public void CallUs(View view){
          Intent intent = new Intent(Intent.ACTION_DIAL);
          intent.setData(Uri.parse("tel:03344050541"));
          if(intent.resolveActivity(getPackageManager()) != null){
              startActivity(intent);
          }
    }

}
