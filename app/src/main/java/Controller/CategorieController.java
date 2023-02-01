package Controller;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prj_gestion_centre_mobile.R;

import java.util.ArrayList;

import Model.Salle;

public class CategorieController  extends RecyclerView.Adapter<CategorieController.ViewHolder>{
    private Context context;
    ArrayList<String> list_categorie;
    public CategorieController(Context context, ArrayList<String> Categories) {
        this.context = context;
        this.list_categorie = Categories;
    }
    @NonNull
    @Override
    public CategorieController.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_itemcategorie,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.btn_categorie.setText(list_categorie.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.btn_categorie.getCurrentTextColor()== holder.btn_categorie.getContext().getResources().getColor(R.color.white)){
                    holder.btn_categorie.setBackgroundDrawable(holder.btn_categorie.getContext().getResources().getDrawable(R.drawable.btn_categorie));
                    holder.btn_categorie.setTextColor(holder.btn_categorie.getContext().getResources().getColor(R.color.btncolor));
                }
                else {
                    holder.btn_categorie.setBackgroundDrawable(holder.btn_categorie.getContext().getResources().getDrawable(R.drawable.btn_categorie1));
                    holder.btn_categorie.setTextColor(holder.btn_categorie.getContext().getResources().getColor(R.color.white));
                }


            }
        });


    }






    @Override
    public int getItemCount() {
        return list_categorie.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView btn_categorie;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
         btn_categorie =(TextView) itemView.findViewById(R.id.btn_categorie);



        }


        @Override
        public void onClick(View view) {

        }
    }
}