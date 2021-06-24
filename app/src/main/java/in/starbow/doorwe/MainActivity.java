package in.starbow.doorwe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

     private List<FoodcategoryItem> FooditemList = new ArrayList<>();
     private List<CouponItem>CouponItemList=new ArrayList<>();
     private List<SetMenuItem>setMenuItemlist=new ArrayList<>();
     private RecyclerView foodCategoryRecyclerView;
     private FoodCategoryAdapter mAdapter;
     private RecyclerView couponRV;
     private CouponRecyclerView couponAdapter;
     private RecyclerView setMenuRV;
     private setMenuadapter setMenuadapter;
     private DrawerLayout drawerLayout;
     private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        foodCategoryRecyclerView = (RecyclerView)findViewById(R.id.recyclerViewCategories);
        mAdapter = new FoodCategoryAdapter(FooditemList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager((getApplicationContext()));
        foodCategoryRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));
        foodCategoryRecyclerView.setItemAnimator(new DefaultItemAnimator());
        foodCategoryRecyclerView.setAdapter(mAdapter);
        prepareItem();

        //coupon recycler view
        couponRV=(RecyclerView)findViewById(R.id.couponsRecyclerView);
        couponAdapter=new CouponRecyclerView(CouponItemList);
        RecyclerView.LayoutManager couponManager= new LinearLayoutManager(getApplicationContext());
        couponRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));
        couponRV.setItemAnimator(new DefaultItemAnimator());
        couponRV.setAdapter(couponAdapter);
        prepareCoupon();

        //set menu recycler view
        setMenuRV=(RecyclerView)findViewById(R.id.foodMenuRV);
        setMenuadapter=new setMenuadapter(setMenuItemlist);
        RecyclerView.LayoutManager setMenuManager= new LinearLayoutManager(getApplicationContext());
        setMenuRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        setMenuRV.setItemAnimator(new DefaultItemAnimator());
        setMenuRV.setAdapter(setMenuadapter);
        prepareMenu();

        //Drawer Layout


        Toolbar  toolbar=(Toolbar) findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);
        drawerLayout =(DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_open,R.string.navigation_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.sd_home_menu:
                        Toast.makeText(navigationView.getContext(),"This is Home",Toast.LENGTH_SHORT);
                       //TODO: ADD more cases
                }
                return true;
            }
        });




    }

    private void prepareMenu() {
        SetMenuItem item = new SetMenuItem(R.drawable.menu1,"Set Menu 1",4, (float) 128.4,140.87f);
          setMenuItemlist.add(item);
        item = new SetMenuItem(R.drawable.menu22,"Set Menu 1",4, (float) 128.4,140.87f);
        setMenuItemlist.add(item);
        item = new SetMenuItem(R.drawable.menu2,"Set Menu 1",4, (float) 128.4,140.87f);
        setMenuItemlist.add(item);
        setMenuadapter.notifyDataSetChanged();
        setMenuRV.setAdapter(setMenuadapter);
    }

    private void prepareCoupon() {
        CouponItem item = new CouponItem(R.drawable.banner2);
        CouponItemList.add(item);
       item = new CouponItem(R.drawable.banner2);
        CouponItemList.add(item);
        item = new CouponItem(R.drawable.banner2);
        CouponItemList.add(item);
        couponAdapter.notifyDataSetChanged();
        couponRV.setAdapter(couponAdapter);

    }

    private void prepareItem() {
        FoodcategoryItem item = new FoodcategoryItem(R.drawable.cake,"Cake");
        FooditemList.add(item);
          item = new FoodcategoryItem(R.drawable.cake,"Cake");
        FooditemList.add(item);
          item = new FoodcategoryItem(R.drawable.frenchfries,"Cake");
        FooditemList.add(item);
        item = new FoodcategoryItem(R.drawable.hamburger,"Cake");
        FooditemList.add(item);
        item = new FoodcategoryItem(R.drawable.cake,"Cake");
        FooditemList.add(item);
        item = new FoodcategoryItem(R.drawable.cake,"Cake");
        FooditemList.add(item);
        mAdapter.notifyDataSetChanged();
        foodCategoryRecyclerView.setAdapter(mAdapter);
    }

    public void offers_intent(MenuItem item) {
        Intent intent= new Intent(this,offers_activity.class);
        startActivity(intent);
    }
}