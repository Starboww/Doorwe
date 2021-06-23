package in.starbow.doorwe;
import android.content.ClipData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class setMenuadapter extends RecyclerView.Adapter<setMenuadapter.SetMenuViewHolder> {
    private List<SetMenuItem>itemList;

    @Override
    public SetMenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.set_menu_item,parent,false);
       return new SetMenuViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(setMenuadapter.SetMenuViewHolder holder, int position) {
        SetMenuItem row = itemList.get(position);
        holder.ratingBar.setNumStars(3);
        holder.title.setText(row.getTitle());
        holder.last_price.setText(String.valueOf(row.getLast_price()));
        holder.current_price.setText(String.valueOf(row.getCurrent_price()));
        holder.imageView.setImageResource(row.getImageID());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class SetMenuViewHolder extends RecyclerView.ViewHolder{
        public TextView title,current_price,last_price;
        public RatingBar ratingBar;
        public ImageView imageView;

        public SetMenuViewHolder( View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.set_menu_num);
            imageView=(ImageView)itemView.findViewById(R.id.set_menu_item_image);
            current_price=(TextView)itemView.findViewById(R.id.current_price);
            last_price=(TextView)itemView.findViewById(R.id.last_price);
            ratingBar=(RatingBar)itemView.findViewById(R.id.rating_bar);
            //TODO:ONCLICK on Setmenu

        }
    }
    public setMenuadapter(List<SetMenuItem>itemList)
    {
        this.itemList=itemList;
    }

}
