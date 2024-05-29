package id.ac.binus.easychef;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class IngredientsCarouselAdapter extends RecyclerView.Adapter<IngredientsCarouselAdapter.ViewHolder> {

    public ArrayList<String> ingrList;

    public IngredientsCarouselAdapter(ArrayList<String> ingrList) {
        this.ingrList = ingrList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.repeater_ingredientcarousel, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String ingredient = ingrList.get(position);
        holder.ingredientTxt.setText(ingredient);
    }

    @Override
    public int getItemCount() {
        return ingrList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView ingredientTxt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ingredientTxt = itemView.findViewById(R.id.foodRepeater_ingredientTxt);
        }
    }
}
