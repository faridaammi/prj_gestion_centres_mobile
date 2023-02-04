package Controller;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prj_gestion_centre_mobile.Centre_details_activity;
import com.example.prj_gestion_centre_mobile.R;

import java.util.List;

import Model.Centre;
import Model.Publication;

public class Centre_favorisController extends RecyclerView.Adapter<Centre_favorisController.ViewHolder> {
    private Context context;
    private List<Centre> centreList;
    public Centre_favorisController (Context context, List<Centre> centreList){
        this.context=context;
        this.centreList=centreList;
    }
    @NonNull
    @Override
    public Centre_favorisController.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.liste_favoris,parent,false);
        return new Centre_favorisController.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Centre_favorisController.ViewHolder holder, int position) {
        Centre item=centreList.get(position);

        holder.imgv_favCentre.setBackground(context.getDrawable(item.getImg_centre()));
        holder.txt_favTitre.setText(item.getNom_centre());
        if (item.getSalles_centre()!=null){
            Log.d("ffdfd","dsdsd");
            String size = String.valueOf(item.getSalles_centre().size());
            holder.txt_nbSalle.setText(size);
        }


    }

    @Override
    public int getItemCount() { return centreList.size();}

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private LinearLayout imgv_favCentre;
        private TextView txt_favTitre;
        private TextView txt_nbSalle;
        private ImageButton btn_bookmark;

        CardView cardvfavoris;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            btn_bookmark=itemView.findViewById(R.id.btn_favoris);
            imgv_favCentre=itemView.findViewById(R.id.imgv_favCentre);
            txt_favTitre=itemView.findViewById(R.id.txt_favTitre);
            txt_nbSalle=itemView.findViewById(R.id.txt_nbSalle);
            btn_bookmark.setOnClickListener(new View.OnClickListener() {
                boolean fav=true;
                @Override
                public void onClick(View view) {
                    if(fav){
                        fav=false;
                        btn_bookmark.setImageDrawable(context.getDrawable(R.drawable.icon_bookmark_border));
                    }
                    else{
                        fav=true;
                        btn_bookmark.setImageDrawable(context.getDrawable(R.drawable.icon_bookmark));
                    }
                }
            });
            cardvfavoris=itemView.findViewById(R.id.cardvfavoris);
            cardvfavoris.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(view.getContext(), Centre_details_activity.class);
                    view.getContext().startActivity(intent);
                }
            });
        }

        @Override
        public void onClick(View view) {
            int position=getAdapterPosition();

        }
    }
}
