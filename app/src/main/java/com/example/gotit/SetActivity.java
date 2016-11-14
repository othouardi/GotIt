package com.example.gotit;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class SetActivity extends AppCompatActivity implements View.OnClickListener{
     Button submitButton;
    EditText starttime;
    EditText endtime;
    EditText message;
    CheckBox monday;
    CheckBox tuesday;
    CheckBox wednesday;
    CheckBox thursday;
    CheckBox friday;
    CheckBox saturday;
    CheckBox sunday;
    String  message_from_edit_text;
    String start;
    String end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);

        setupViews();
    }

    private void setupViews() {
        submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(this);
    }

    //validayion
    private boolean validation(){
        message_from_edit_text =message.getText().toString();
        start = starttime.getText().toString();
        end = endtime.getText().toString();

        if (message_from_edit_text.isEmpty() || start.isEmpty() || end.isEmpty()){
            showDialog();
            return false;
        }

        if (monday.isChecked() || tuesday.isChecked() || wednesday.isChecked() || thursday.isChecked()|| friday.isChecked()||saturday.isChecked()||sunday.isChecked()){
            return true;
        }

        return false;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.submitButton:
                //do whatever
                break;
        }
    }

    public void showDialog(){
        AlertDialog alertDialog = new AlertDialog.Builder(SetActivity.this).create();
        alertDialog.setTitle("Missing field");
        alertDialog.setMessage("Please enter all fields");
        // Alert dialog button
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Alert dialog action goes here
                        // onClick button code here
                        dialog.dismiss();// use dismiss to cancel alert dialog
                    }
                });
        alertDialog.show();
    }
}