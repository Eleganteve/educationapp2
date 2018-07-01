package com.example.android.educationapp2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }
    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText nameField = (EditText)findViewById(R.id.name_field);
        String name = nameField.getText().toString();
        Log.v("Main Activity", "Name: " + name);
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean haswhippedCream = whippedCreamCheckBox.isChecked();
        Log.v("Main activity", "Has whipped cream " +haswhippedCream);
        int price =  calculatePrice(quantity );
        String intprice = null;
        String priceMessage = createOrderSummary (intprice, price,haswhippedCream);
        displayMessage(priceMessage);

    }
    /**
     * Calculates the price of the order.
     *
     *@return name of the customer.
     *@return  addWhippedCream  whether or not the user wants the whipped cream topping.
     *
     *@return total price
     */
    private int  calculatePrice(int quantity) {
        int price = quantity * 5;
        return price;
    }
    private String createOrderSummary(String name ,int price, boolean addWhippedCream) {
        String priceMessage ="Name: "+name ;
        priceMessage="Add Whipped Cream?" + addWhippedCream;
        priceMessage= priceMessage +"\nQuantity:" + quantity;
        priceMessage=priceMessage + "\nTotal: $" + price;
        priceMessage= priceMessage + "\nThank you";
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);

        calculatePrice(quantity);
    }
    /**
     * This method displays the given price on the screen.
     */

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.orderSummary_text_view);
        orderSummaryTextView.setText(message);
    }
}
