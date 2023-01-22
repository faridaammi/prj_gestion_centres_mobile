package Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        holder.imgv_favCentre.setImageResource(item.getImg_centre());
        holder.txt_favTitre.setText(item.getNom_centre());
//        holder.txt_nbSalle.setText(item.getSalles_centre().size());
    }

    @Override
    public int getItemCount() { return centreList.size();}

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView imgv_favCentre;
        private TextView txt_favTitre;
        private TextView txt_nbSalle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imgv_favCentre=itemView.findViewById(R.id.imgv_favCentre);
            txt_favTitre=itemView.findViewById(R.id.txt_favTitre);
            //txt_nbSalle=itemView.findViewById(R.id.txt_nbSalle);
        }

        @Override
        public void onClick(View view) {
            int position=getAdapterPosition();
            //Publication item=listPublication.get(position);
        }
    }
}
