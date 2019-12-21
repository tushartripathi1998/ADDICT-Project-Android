package com.example.fluperproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.fluperproject.Model.MyModel;

import java.lang.ref.WeakReference;
import java.util.List;

public class SecondActivity extends AppCompatActivity{

    ViewModel viewModel;
    int aCount, aTotal, dCount, dTotal, d2Count, d2Total, iCount, iTotal, cCount, cTotal, tCount, tTotal;
    TextView totalOfA, countOfA, totalOfD, countOfD, totalOfD2, countOfD2, totalOfI, countOfI, totalOfC, countOfC, totalOfT, countOfT;
    PopupWindow popupWindow;
    View promptsView;
    AlertDialog alertDialog;
    AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        promptsView = getLayoutInflater().inflate(R.layout.popup_example, null);
        alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setView(promptsView);
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        alertDialog = alertDialogBuilder.create();

        viewModel = ViewModelProviders.of(this).get(ViewModel.class);
        initializeEachData();
        initAllTextView();
        viewModel.getAllData().observe(SecondActivity.this, new Observer<List<MyModel>>() {
            @Override
            public void onChanged(List<MyModel> myModels) {
                for( MyModel model:myModels )
                {
                    Log.d("test : ",model.getValue()+model.getCount()+model.getTotal());
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.items, menu);
        return true;
    }

    public void initializeEachData()
    {
        viewModel.getData("A").observe(SecondActivity.this, new Observer<MyModel>() {
            @Override
            public void onChanged(MyModel myModel) {
                aTotal = myModel.getTotal();
                aCount = myModel.getCount();
                totalOfA.setText(String.valueOf(aTotal));
                countOfA.setText(String.valueOf(aCount));
            }
        });

        viewModel.getData("D").observe(SecondActivity.this, new Observer<MyModel>() {
            @Override
            public void onChanged(MyModel myModel) {
                dTotal = myModel.getTotal();
                dCount = myModel.getCount();
                totalOfD.setText(String.valueOf(dTotal));
                countOfD.setText(String.valueOf(dCount));
            }
        });

        viewModel.getData("D2").observe(SecondActivity.this, new Observer<MyModel>() {
            @Override
            public void onChanged(MyModel myModel) {
                d2Total = myModel.getTotal();
                d2Count = myModel.getCount();
                totalOfD2.setText(String.valueOf(d2Total));
                countOfD2.setText(String.valueOf(d2Count));
            }
        });

        viewModel.getData("I").observe(SecondActivity.this, new Observer<MyModel>() {
            @Override
            public void onChanged(MyModel myModel) {
                iTotal = myModel.getTotal();
                iCount = myModel.getCount();
                totalOfI.setText(String.valueOf(iTotal));
                countOfI.setText(String.valueOf(iCount));
            }
        });

        viewModel.getData("C").observe(SecondActivity.this, new Observer<MyModel>() {
            @Override
            public void onChanged(MyModel myModel) {
                cTotal = myModel.getTotal();
                cCount = myModel.getCount();
                totalOfC.setText(String.valueOf(cTotal));
                countOfC.setText(String.valueOf(cCount));
            }
        });

        viewModel.getData("T").observe(SecondActivity.this, new Observer<MyModel>() {
            @Override
            public void onChanged(MyModel myModel) {
                tTotal = myModel.getTotal();
                tCount = myModel.getCount();
                totalOfT.setText(String.valueOf(tTotal));
                countOfT.setText(String.valueOf(tCount));
            }
        });
    }

    public void initAllTextView()
    {
        totalOfA = findViewById(R.id.totalA);
        countOfA = findViewById(R.id.countA);

        totalOfD = findViewById(R.id.totalD);
        countOfD = findViewById(R.id.countD);

        totalOfD2 = findViewById(R.id.totalD2);
        countOfD2 = findViewById(R.id.countD2);

        totalOfI = findViewById(R.id.totalI);
        countOfI = findViewById(R.id.countI);

        totalOfC = findViewById(R.id.totalC);
        countOfC = findViewById(R.id.countC);

        totalOfT = findViewById(R.id.totalT);
        countOfT = findViewById(R.id.countT);
    }

    public void clickOnA(View view)
    {
        int count = aCount+1;
        if(count <= aTotal)
        {
            new UpdateVM(SecondActivity.this).execute(new MyModel("A", count, aTotal));//viewModel.update(new MyModel("A", count, aTotal));
        } else{
            alertDialog.show();
            new UpdateVM(SecondActivity.this).execute(new MyModel("A", 0, aTotal));//viewModel.update(new MyModel("A",0,aTotal));
        }
    }

    public void clickOnD(View view)
    {
        int count = dCount+1;
        if(count <= dTotal)
        {
            new UpdateVM(SecondActivity.this).execute(new MyModel("D", count, dTotal));
        } else{
            alertDialog.show();
            new UpdateVM(SecondActivity.this).execute(new MyModel("D",0,dTotal));
        }
    }

    public void clickOnD2(View view)
    {
        int count = d2Count+1;
        if(count <= d2Total)
        {
            new UpdateVM(SecondActivity.this).execute(new MyModel("D2", count, d2Total));
        } else{
            alertDialog.show();
            new UpdateVM(SecondActivity.this).execute(new MyModel("D2",0,d2Total));
        }
    }

    public void clickOnI(View view)
    {
        int count = iCount+1;
        if(count <= iTotal)
        {
            new UpdateVM(SecondActivity.this).execute(new MyModel("I", count, iTotal));
        } else{
            alertDialog.show();
            new UpdateVM(SecondActivity.this).execute(new MyModel("I",0,iTotal));
        }
    }

    public void clickOnC(View view)
    {
        int count = cCount+1;
        if(count <= cTotal)
        {
            new UpdateVM(SecondActivity.this).execute(new MyModel("C", count, cTotal));
        } else{
            new UpdateVM(SecondActivity.this).execute(new MyModel("C",0,cTotal));
        }
    }

    public void clickOnT(View view)
    {
        int count = tCount+1;
        if(count <= tTotal)
        {
            new UpdateVM(SecondActivity.this).execute(new MyModel("T", count, tTotal));
        } else{
            alertDialog.show();
            new UpdateVM(SecondActivity.this).execute(new MyModel("T",0,tTotal));
        }
    }

    class UpdateVM extends AsyncTask<MyModel, Void, Boolean>
    {
        private WeakReference<SecondActivity> activityReference;

        public UpdateVM(SecondActivity context){
            activityReference = new WeakReference<>(context);
        }
        public void updateVal(MyModel myModel)
        {
            viewModel.update(myModel);
        }

        @Override
        protected Boolean doInBackground(MyModel... myModels) {
            updateVal(myModels[0]);
            return true;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.setting:
                finish();
            case R.id.refresh:
                new UpdateVM(SecondActivity.this).execute(new MyModel("A", 0, aTotal));
                new UpdateVM(SecondActivity.this).execute(new MyModel("D", 0, dTotal));
                new UpdateVM(SecondActivity.this).execute(new MyModel("D2", 0, d2Total));
                new UpdateVM(SecondActivity.this).execute(new MyModel("I", 0, iTotal));
                new UpdateVM(SecondActivity.this).execute(new MyModel("C", 0, cTotal));
                new UpdateVM(SecondActivity.this).execute(new MyModel("T", 0, tTotal));
        }
        return super.onOptionsItemSelected(item);
    }
}
