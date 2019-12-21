package com.example.fluperproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fluperproject.Model.Database;
import com.example.fluperproject.Model.MyModel;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String textAValue, textDValue, textD2Value, textIValue, textCValue, textTValue;
    Intent intent;
    Database db;
    List<MyModel> modelList = new ArrayList<MyModel>();
    ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(this, SecondActivity.class);
        viewModel = ViewModelProviders.of(MainActivity.this).get(ViewModel.class);
        Button save = (Button)findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initValues();
                new DoAddData(MainActivity.this).execute();
                startActivity(intent);
            }
        });
    }

    private void initValues() {
        EditText textA = (EditText)findViewById(R.id.txtA);
        textAValue = textA.getText().toString();

        EditText textD = (EditText)findViewById(R.id.txtD);
        textDValue = textD.getText().toString();

        EditText textD2 = (EditText)findViewById(R.id.txtD2);
        textD2Value = textD2.getText().toString();

        EditText textI = (EditText)findViewById(R.id.txtI);
        textIValue = textI.getText().toString();

        EditText textC = (EditText)findViewById(R.id.txtC);
        textCValue = textC.getText().toString();

        EditText textT = (EditText)findViewById(R.id.txtT);
        textTValue = textT.getText().toString();
    }

    class DoAddData extends AsyncTask<Void, Void, Boolean> {

        private WeakReference<MainActivity> activityReference;

        public DoAddData(MainActivity context){
            activityReference = new WeakReference<>(context);
        }

        private void insertValue() {
            viewModel.insertData(new MyModel("A", 0, Integer.parseInt(textAValue)));
            viewModel.insertData(new MyModel("D", 0, Integer.parseInt(textDValue)));
            viewModel.insertData(new MyModel("D2", 0, Integer.parseInt(textD2Value)));
            viewModel.insertData(new MyModel("I", 0, Integer.parseInt(textIValue)));
            viewModel.insertData(new MyModel("C", 0, Integer.parseInt(textCValue)));
            viewModel.insertData(new MyModel("T", 0, Integer.parseInt(textTValue)));
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            insertValue();
            return true;
        }
    }
}
