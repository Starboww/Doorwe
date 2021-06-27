package in.starbow.doorwe;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

//TODO:remove register frgamnet and create activity instead
public class LoginFragment extends Fragment {
    Button logIn;
    EditText phoneNumber;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.login_fragment, container, false);
        logIn = view.findViewById(R.id.login);
        phoneNumber = view.findViewById(R.id.phone);
        ProgressBar progressBar = view.findViewById(R.id.progressBar);

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!phoneNumber.getText().toString().trim().isEmpty()) {
                    if (phoneNumber.getText().toString().trim().length() == 10) {
                        progressBar.setVisibility(View.VISIBLE);
                        logIn.setVisibility(View.INVISIBLE);
                        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                                "+91" + phoneNumber.getText().toString(),
                                60, TimeUnit.SECONDS, getActivity(),
                                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                    @Override
                                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                        progressBar.setVisibility(View.GONE);
                                        logIn.setVisibility(View.VISIBLE);


                                    }

                                    @Override
                                    public void onVerificationFailed(@NonNull FirebaseException e) {
                                        progressBar.setVisibility(View.GONE);
                                        logIn.setVisibility(View.VISIBLE);
                                        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onCodeSent(@NonNull String otpGot, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                        super.onCodeSent(otpGot, forceResendingToken);
                                        Intent log = new Intent(getContext(), Otp_verify.class);
                                        log.putExtra("mobile", phoneNumber.getText().toString().trim());
                                        log.putExtra("otp",otpGot);
                                        startActivity(log);
                                        getActivity().finish();
                                    }
                                }
                        );

                    } else {
                        progressBar.setVisibility(View.INVISIBLE);
                        logIn.setVisibility(View.VISIBLE);
                        Toast.makeText(getContext(), "Please Enter The Correct Number ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Please Enter Number ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}