package com.alexgwyn.recyclerviewsquire.sample;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.alexgwyn.recyclerviewsquire.ClickableArrayAdapter;
import com.alexgwyn.recyclerviewsquire.FullScreenLinearLayoutManager;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    ViewGroup mRoot;
    Toolbar mToolbar;
    RecyclerView mCheeseRecyclerView;
    CheeseAdapter mCheeseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRoot = findViewById(R.id.root);
        mToolbar = findViewById(R.id.toolbar);
        mCheeseRecyclerView = findViewById(R.id.recyclerview);

        mToolbar.setTitle(R.string.app_name);
        mToolbar.inflateMenu(R.menu.main);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_change_layout_manager:
                        mCheeseRecyclerView.setLayoutManager(new FullScreenLinearLayoutManager(MainActivity.this));
                        return true;
                }
                return false;
            }
        });

        mCheeseRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mCheeseAdapter = new CheeseAdapter();
        mCheeseRecyclerView.setAdapter(mCheeseAdapter);
        addCheeses();
        mCheeseAdapter.setOnItemClickListener(new ClickableArrayAdapter.OnItemClickListener<Cheese>() {
            @Override
            public void onItemClicked(ClickableArrayAdapter adapter, View view, int position) {
                Cheese item = (Cheese) adapter.get(position);
                Snackbar.make(mRoot, item.getName() + " clicked", Snackbar.LENGTH_SHORT)
                        .show();
            }

        });
    }

    private void addCheeses() {
        ArrayList<Cheese> cheeses = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            cheeses.add(Cheeses.getRandomCheese());
        }
        mCheeseAdapter.addAll(cheeses);
    }
}
