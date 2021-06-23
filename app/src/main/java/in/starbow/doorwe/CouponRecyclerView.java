package in.starbow.doorwe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
//Coupon Adapter
public class CouponRecyclerView extends RecyclerView.Adapter<CouponRecyclerView.ViewHolder>{
    private List<CouponItem>itemList;


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coupons_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CouponItem item = itemList.get(position);
          holder.imageView.setImageResource(item.getCouponImageID());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
       public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.coupon_banner);
            //TODO: OnClick banner
        }
    }
    public CouponRecyclerView(List<CouponItem>itemList)
    {
        this.itemList=itemList;
    }
}
