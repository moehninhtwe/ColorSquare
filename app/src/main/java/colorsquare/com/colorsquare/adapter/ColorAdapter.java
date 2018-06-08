package colorsquare.com.colorsquare.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import colorsquare.com.colorsquare.R;
import java.util.List;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ColorViewHolder> {
    private List<Integer>
        listOfColors; /* personally prefer to use List to Array even though the array size can be known in this case*/
    public ColorAdapter() {
    }

    public void setListOfColors(List<Integer> listOfColors) {
        this.listOfColors = listOfColors;
    }

    @NonNull @Override
    public ColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vSquareBox = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.grid_color_square, parent, false);
        return new ColorViewHolder(vSquareBox);
    }

    @Override public void onBindViewHolder(@NonNull ColorViewHolder holder, int position) {
        holder.llSquareBox.setBackgroundColor(listOfColors.get(position));
    }

    @Override public int getItemCount() {
        return listOfColors.size();
    }

    public static class ColorViewHolder extends RecyclerView.ViewHolder {
        LinearLayout llSquareBox;

        public ColorViewHolder(View view) {
            super(view);
            llSquareBox = view.findViewById(R.id.ll_squarebox);
        }
    }
}
