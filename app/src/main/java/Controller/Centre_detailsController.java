package Controller;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prj_gestion_centre_mobile.R;

import java.util.ArrayList;
import java.util.List;

import Model.Centre;

public class Centre_detailsController  extends RecyclerView.Adapter<Centre_detailsController.ViewHolder>{
    private Context context;
    int[]  img_centre;
    public Centre_detailsController(Context context, int[] imgs) {
        this.context = context;
        this.img_centre = imgs;
   }
    @NonNull
    @Override
    public Centre_detailsController.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_details_centre,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgcentre.setImageResource(img_centre[position]);

    }



    @Override
    public int getItemCount() {
        return img_centre.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imgcentre;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
          imgcentre= (ImageView) itemView.findViewById(R.id.img_centre);

        }


        @Override
        public void onClick(View view) {

        }
    }
}
