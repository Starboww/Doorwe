package in.starbow.doorwe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class offersAdapter extends RecyclerView.Adapter<offersAdapter.viewHolder>{
    private List<offers_item> itemList;
    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.offers_item_view,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        offers_item item = itemList.get(position);
        holder.imageView.setImageResource(item.getImageID());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;

        public viewHolder( View itemView) {
            super(itemView);
            imageView =itemView.findViewById(R.id.offers_image_view);
            //TODO:OnClick offers
        }
    }
    public offersAdapter(List<offers_item>itemList)
    {
        this.itemList=itemList;
    }
}
