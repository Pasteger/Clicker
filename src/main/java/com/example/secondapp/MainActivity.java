package com.example.secondapp;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Integer coal = 0;
    private Integer iron = 0;
    private Integer gold = 0;
    private Integer diamond = 0;
    private Integer netherite = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        print();
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
        resetUI();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", coal);
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null &&
                savedInstanceState.containsKey("count")) {
            coal = savedInstanceState.getInt("count");
        }
        Log.d(TAG, "onRestoreInstanceState");
    }

    private void resetUI() {
        ((TextView) findViewById(R.id.coal)).setText(coal.toString());
        Log.d(TAG, "resetUI");
    }

    public void onClickBtnAddCoal(View view){
        coal++;
        if (coal >= 100){
            iron++;
            coal=0;
        }
        if (iron >= 100){
            gold++;
            iron=0;
        }
        if (gold >= 100){
            diamond++;
            gold=0;
        }
        if (diamond >= 100){
            netherite++;
            diamond=0;
        }
        if (netherite >= 100){
            win();
        }
        print();

    }

    protected void print(){
        TextView counterView = findViewById(R.id.coal);
        counterView.setText(coal.toString());
        counterView = findViewById(R.id.iron);
        counterView.setText(iron.toString());
        counterView = findViewById(R.id.gold);
        counterView.setText(gold.toString());
        counterView = findViewById(R.id.diamond);
        counterView.setText(diamond.toString());
        counterView = findViewById(R.id.netherite);
        counterView.setText(netherite.toString());
    }

    protected void win(){
        // Здесь будет или увеличиваться на весь экран картинка "win.png"
        // или будет переход на другую активити, бекграундом которой будет картинка "win.png"
    }
}
