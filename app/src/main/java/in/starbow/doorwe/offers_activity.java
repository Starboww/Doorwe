package in.starbow.doorwe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class offers_activity extends AppCompatActivity {
    private List<offers_item> offers_items=new ArrayList<>();
    private RecyclerView offersRV;
    private offersAdapter offersAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);
        offersRV=(RecyclerView)findViewById(R.id.offersRV);
        offersAdapter=new offersAdapter(offers_items);
        RecyclerView.LayoutManager offers_manager= new LinearLayoutManager(getApplicationContext());
        offersRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        offersRV.setItemAnimator(new DefaultItemAnimator());
        offersRV.setAdapter(offersAdapter);
        prepare_offers();

    }

    private void prepare_offers() {
        offers_item item=new offers_item(R.drawable.banner2);
        offers_items.add(item);
       item=new offers_item(R.drawable.banner2);
        offers_items.add(item);
        item=new offers_item(R.drawable.banner2);
        offers_items.add(item);
        item=new offers_item(R.drawable.banner2);
        offers_items.add(item);
        item=new offers_item(R.drawable.banner2);
        offers_items.add(item);
        offersAdapter.notifyDataSetChanged();
        offersRV.setAdapter(offersAdapter);

    }
}