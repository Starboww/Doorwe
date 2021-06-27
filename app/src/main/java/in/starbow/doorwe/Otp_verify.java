package in.starbow.doorwe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class Otp_verify extends AppCompatActivity {
EditText otpVerify1,otpVerify2,otpVerify3,otpVerify4,otpVerify5,otpVerify6;
TextView getNumber;
String getOtpBackend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verify);
        otpVerify1 =findViewById(R.id.otp1);
        otpVerify2 =findViewById(R.id.otp2);
        otpVerify3 =findViewById(R.id.otp3);
        otpVerify4 =findViewById(R.id.otp4);
        otpVerify5 =findViewById(R.id.otp5);
        otpVerify6=findViewById(R.id.otp6);
        getNumber=findViewById(R.id.numberGet);
        getNumber.setText(String.format(
                "+91- %s",getIntent().getStringExtra("mobile")) );
        moveNext();
        getOtpBackend=getIntent().getStringExtra("otp");

    }

    public void verifySubmit(View view) {
        final ProgressBar progressBar=findViewById(R.id.progressbar2);
        if(!otpVerify1.getText().toString().trim().isEmpty() &&!otpVerify2.getText().toString().trim().isEmpty() &&!otpVerify3.getText().toString().trim().isEmpty() && !otpVerify4.getText().toString().trim().isEmpty()&& !otpVerify5.getText().toString().trim().isEmpty() &&!otpVerify6.getText().toString().trim().isEmpty()){
           String checkOtp=otpVerify1.getText().toString()+otpVerify2.getText().toString()+otpVerify3.getText().toString()+otpVerify4.getText().toString()+otpVerify5.getText().toString()+otpVerify6.getText().toString();
           if(checkOtp!=null) {
               progressBar.setVisibility(View.VISIBLE);
               view.setVisibility(View.INVISIBLE);
               PhoneAuthCredential phoneAuthCredential= PhoneAuthProvider.getCredential(getOtpBackend,checkOtp);
               FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if(task.isSuccessful()){
                           Toast.makeText(Otp_verify.this, "otp verify", Toast.LENGTH_SHORT).show();
                           Intent i=new Intent(getApplicationContext(),MainActivity.class);
                           i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                           startActivity(i);
                           finish();
                       }else {
                           Toast.makeText(Otp_verify.this, "enter correct otp", Toast.LENGTH_SHORT).show();
                       }

                   }
               });
           }else {
               Toast.makeText(this, "Check Your Internet Connection", Toast.LENGTH_SHORT).show();
           }

        }
        else {
            Toast.makeText(Otp_verify.this, "Enter all digit", Toast.LENGTH_SHORT).show();
        }

    }

    private void moveNext() {
        otpVerify1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
             if(!s.toString().trim().isEmpty()){
                 otpVerify2.requestFocus();
             }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        otpVerify2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
             if(!s.toString().trim().isEmpty()){
                 otpVerify3.requestFocus();
             }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        otpVerify3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
             if(!s.toString().trim().isEmpty()){
                 otpVerify4.requestFocus();
             }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        otpVerify4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
             if(!s.toString().trim().isEmpty()){
                 otpVerify5.requestFocus();
             }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        otpVerify5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
             if(!s.toString().trim().isEmpty()){
                 otpVerify6.requestFocus();
             }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}