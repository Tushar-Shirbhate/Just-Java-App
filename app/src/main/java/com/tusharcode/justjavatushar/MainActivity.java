package com.tusharcode.justjavatushar;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.CheckBox;
//import android.widget.TextView;
//import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submitOrder(View view){
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        // Log.v("Main Activity", "Has Whipped cream"+ hasWhippedCream);
        int price = calculatePrice(hasWhippedCream, hasChocolate);
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate);
        displayMessage(priceMessage);

    }
    private String createOrderSummary(int price, boolean hasWhippedCream, boolean hasChocolate ){
        String message = "Name : Kaptain Agrawal\n" +"Add Whipped Cream? : " + hasWhippedCream + "\nAdd Chocolate? : " + hasChocolate +"\nQuantity : " + quantity + "\n" + "Total : $" + price + "\n" + "Thank you!";
        return message;
    }
    private void calculatePrice(int quantity){
        int price = quantity*5;
    }
    private void calculatePrice(int quantity, int pricePerCup){
        int price = quantity * pricePerCup;
    }
    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolate){
        int basePrice = 5;
        if(hasWhippedCream){
            basePrice = basePrice +  1;
        }
        if (hasChocolate){
            basePrice = basePrice + 2;
        }

        return quantity*basePrice;
    }
    public void increament(View view){
        if(quantity == 100){
            Toast.makeText(this, "You can not increase more than 100", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity =  quantity + 1 ;
        displayQuantity(quantity);
    }
    public void decreament(View view){
        if(quantity == 1){
            Toast.makeText(this, "You can not decrease less than 1", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }
    private void displayQuantity(int numberOfCoffees){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }
    private void displayPrice(int number){
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    private void displayMessage(String message){
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}