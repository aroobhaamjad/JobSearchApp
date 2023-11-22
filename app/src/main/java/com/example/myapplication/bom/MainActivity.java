package com.example.myapplication.bom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {
    private ImageButton home, inventory, expenses, savings, calender, graph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home = findViewById(R.id.home_menu);
        inventory = findViewById(R.id.inventory_menu);
        expenses = findViewById(R.id.expenses_menu);
        savings = findViewById(R.id.savings_menu);
        calender = findViewById(R.id.calender_menu);
        graph = findViewById(R.id.graph_menu);

        Fragment initialFragment = new HomeFragment();
        setFragment(initialFragment);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home.setImageResource(R.drawable.home);
                inventory.setImageResource(R.drawable.inventory);
                expenses.setImageResource(R.drawable.expenses_grey);
                savings.setImageResource(R.drawable.savings_grey);
                calender.setImageResource(R.drawable.calender_grey);
                graph.setImageResource(R.drawable.graph_grey);
                setFragment(new HomeFragment());
            }
        });

        inventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home.setImageResource(R.drawable.home_grey);
                inventory.setImageResource(R.drawable.inventory_white);
                expenses.setImageResource(R.drawable.expenses_grey);
                savings.setImageResource(R.drawable.savings_grey);
                calender.setImageResource(R.drawable.calender_grey);
                graph.setImageResource(R.drawable.graph_grey);
                setFragment(new InventoryFragment());
            }
        });

        expenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home.setImageResource(R.drawable.home_grey);
                inventory.setImageResource(R.drawable.inventory);
                expenses.setImageResource(R.drawable.expenses);
                savings.setImageResource(R.drawable.savings_grey);
                calender.setImageResource(R.drawable.calender_grey);
                graph.setImageResource(R.drawable.graph_grey);
                setFragment(new ExpensesFragment());
            }
        });

        savings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home.setImageResource(R.drawable.home_grey);
                inventory.setImageResource(R.drawable.inventory);
                expenses.setImageResource(R.drawable.expenses_grey);
                savings.setImageResource(R.drawable.savings);
                calender.setImageResource(R.drawable.calender_grey);
                graph.setImageResource(R.drawable.graph_grey);
                setFragment(new SavingsFragment());
            }
        });

        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home.setImageResource(R.drawable.home_grey);
                inventory.setImageResource(R.drawable.inventory);
                expenses.setImageResource(R.drawable.expenses_grey);
                savings.setImageResource(R.drawable.savings_grey);
                calender.setImageResource(R.drawable.calender);
                graph.setImageResource(R.drawable.graph_grey);
                setFragment(new CalenderFragment());
            }
        });

        graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home.setImageResource(R.drawable.home_grey);
                inventory.setImageResource(R.drawable.inventory);
                expenses.setImageResource(R.drawable.expenses_grey);
                savings.setImageResource(R.drawable.savings_grey);
                calender.setImageResource(R.drawable.calender_grey);
                graph.setImageResource(R.drawable.graph);
                setFragment(new GraphFragment());
            }
        });

    }

    private void setFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}