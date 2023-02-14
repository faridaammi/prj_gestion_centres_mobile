package Controller;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prj_gestion_centre_mobile.R;

import java.util.ArrayList;

import Model.Salle;

public class Salle_Controller  extends RecyclerView.Adapter<Salle_Controller.ViewHolder>{
    private Context context;
    ArrayList<Salle> list_salle;
    public Salle_Controller(Context context, ArrayList<Salle> salles) {
        this.context = context;
        this.list_salle = salles;
    }
    @NonNull
    @Override
    public Salle_Controller.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_salleitems,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtcapacite.setText(list_salle.get(position).getCapacite_salle()+" Personnes");
        holder.txtnum.setText(list_salle.get(position).getNumero_salle());
      //  int img = list_salle.get(position).getImage_salle()==0? R.drawable.rectangleorange:list_salle.get(position).getImage_salle();

       // holder.imgsalle.setBackground(context.getDrawable(img));
    }






    @Override
    public int getItemCount() {
        return list_salle.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private LinearLayout imgsalle;
        private TextView  txtcapacite;
        private TextView  txtnum;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtcapacite= (TextView) itemView.findViewById(R.id.capacitesalle);
            txtnum= (TextView) itemView.findViewById(R.id.numsalle);
            imgsalle= (LinearLayout) itemView.findViewById(R.id.imgsalle);



        }


        @Override
        public void onClick(View view) {

        }
    }
}