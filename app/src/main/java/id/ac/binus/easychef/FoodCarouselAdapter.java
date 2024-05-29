package id.ac.binus.easychef;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FoodCarouselAdapter extends RecyclerView.Adapter<FoodCarouselAdapter.ViewHolder> {

    public ArrayList<Food> foodList;
    OnClick listener;

    public interface OnClick {
        void OnItemClick(Food food);
    }
    public FoodCarouselAdapter(ArrayList<Food> foodList, OnClick listener) {
        this.foodList = foodList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.repeater_foodcarousel, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.nameTxt.setText(food.getName());
        holder.typeTxt.setText(food.getType());
        holder.likesTxt.setText(String.valueOf(food.getLikes()));
        holder.thumbImg.setImageResource(food.getImage());
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTxt, typeTxt, likesTxt;
        public ImageView thumbImg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTxt = itemView.findViewById(R.id.foodName_txt);
            typeTxt = itemView.findViewById(R.id.foodType_txt);
            likesTxt = itemView.findViewById(R.id.likesCount_txt);
            thumbImg = itemView.findViewById(R.id.thumbnail_img);
            itemView.setOnClickListener(e -> {
                int position = getAdapterPosition();
                if(position != RecyclerView.NO_POSITION && listener != null) {
                    listener.OnItemClick(foodList.get(position));
                }
            });
        }
    }
}
