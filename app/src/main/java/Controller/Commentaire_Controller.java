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

import java.util.ArrayList;

import Model.Commentaire;
import Model.Salle;
import Model.Utilisateur;

public class Commentaire_Controller  extends RecyclerView.Adapter<Commentaire_Controller.ViewHolder> {
    private Context context;
    ArrayList<Commentaire> list_cmnts;

    public Commentaire_Controller(Context context, ArrayList<Commentaire> salles) {
        this.context = context;
        this.list_cmnts = salles;
    }

    @NonNull
    @Override
    public Commentaire_Controller.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cmntsitem, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Utilisateur user = Utilisateur.finduser(list_cmnts.get(position).getId_utilisateur()) ;
        holder.img_profile.setImageResource(user.getImg_utilisateur());
        holder.contenu_cmnt.setText(list_cmnts.get(position).getContenu_cmnt());
        holder.txtnomprofile.setText(user.getNom_utilisateur());
        holder.txtdatecmnts.setText(list_cmnts.get(position).getDate_cmnt().toString());



    }


    @Override
    public int getItemCount() {
        return list_cmnts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView img_profile;
        private TextView  contenu_cmnt;
        private TextView txtnomprofile;
        private TextView txtdatecmnts;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
          img_profile= (ImageView) itemView.findViewById(R.id.imgprofile);
          contenu_cmnt= (TextView) itemView.findViewById(R.id.contenu_cmnt);
          txtnomprofile= (TextView) itemView.findViewById(R.id.nom_user);
          txtdatecmnts= (TextView) itemView.findViewById(R.id.date_cmnt);


        }


        @Override
        public void onClick(View view) {

        }
    }
}