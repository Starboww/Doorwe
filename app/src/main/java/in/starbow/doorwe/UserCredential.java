package in.starbow.doorwe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class UserCredential extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_credidentals);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,new LoginFragment()).commit();

    }
//    private void goToFragment(Fragment fragment) {
//        FragmentManager fragmentManager =getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.frame,fragment);
//        fragmentTransaction.commit();
//
////    }
//
//    public void loginButton(View view) {
//        goToFragment(new LoginFragment());
//    }

//    public void signUpButton(View view) {
//        goToFragment(new RegisterFragment());
//    }
}