package in.starbow.doorwe;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class RegisterFragment extends Fragment {
Button registerIt;
View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_register, container, false);
        registerIt=view.findViewById(R.id.register);
        registerIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reg=new Intent(getContext(),MainActivity.class);
                startActivity(reg);
                getActivity().finish();
            }
        });

        return view;
    }
}