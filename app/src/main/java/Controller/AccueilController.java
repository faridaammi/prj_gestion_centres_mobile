package Controller;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prj_gestion_centre_mobile.R;

import java.util.List;

import Model.Publication;

public class AccueilController  extends RecyclerView.Adapter<AccueilController.ViewHolder>{
    private Context context;
    private List<Publication> listPublication;
    public AccueilController(Context context, List<Publication> listItems) {
        this.context = context;
        this.listPublication = listItems;
    }
    @NonNull
    @Override
    public AccueilController.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_acceuil,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AccueilController.ViewHolder holder, int position) {
        Publication item=listPublication.get(position);
        holder.imageProfile.setImageResource(item.getImgv_profile());
        holder.titre.setText(item.getTitre_publication());
        holder.date.setText((CharSequence) item.getDate_pubilcation());
        holder.contenu.setText(item.getContenu_publication());
        holder.imagePub.setImageResource(item.getImgv_publication());

    }

    @Override
    public int getItemCount() {
        return listPublication.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imageProfile;
        private TextView titre;
        private TextView date;
        private TextView contenu;
        private ImageView imagePub;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imageProfile=itemView.findViewById(R.id.imgv_profile);
            titre=itemView.findViewById(R.id.txtv_titre);
            date=itemView.findViewById(R.id.txtv_date);
            contenu=itemView.findViewById(R.id.txtv_contenu);
            imagePub=itemView.findViewById(R.id.imgv_pub);
        }


        @Override
        public void onClick(View view) {
            int position=getAdapterPosition();
            Publication item=listPublication.get(position);
//
        }
    }
}
