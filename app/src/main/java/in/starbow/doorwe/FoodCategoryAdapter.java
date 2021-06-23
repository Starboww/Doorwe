package in.starbow.doorwe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;





import java.util.List;

public class FoodCategoryAdapter extends RecyclerView.Adapter<FoodCategoryAdapter.ViewHolder>{
    public static final String  TAG= "FoodCategoryAdaptor";
    //vars
    private List<FoodcategoryItem> itemList;
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;

        //TODO:onclick on food category items
//        main = (LinearLayout) parent.findViewById(R.id.main);
//            main.setOnClickListener(new View.OnClickListener() {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name= itemView.findViewById(R.id.name);
        }
    }

    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_category_card,parent,false);
         return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull  ViewHolder holder, int position) {
         FoodcategoryItem row=itemList.get(position);
         holder.name.setText(row.getTitle());
         holder.image.setImageResource(row.getImageId());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public FoodCategoryAdapter(List<FoodcategoryItem>itemList)
    {
        this.itemList=itemList;
    }
}
