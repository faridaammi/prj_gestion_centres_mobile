package Controller;

import android.content.Context;
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

import Model.Centre;

public class CentreController  extends RecyclerView.Adapter<CentreController.ViewHolder>{
    private Context context;
    ArrayList<Centre> list_centre;
    public CentreController(Context context, ArrayList<Centre> Centres) {
        this.context = context;
        this.list_centre = Centres;
    }
    @NonNull
    @Override
    public CentreController.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_centre,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.img_centre.setBackground(context.getDrawable(list_centre.get(position).getImg_centre()));
        holder.txt_nom_centre.setText(list_centre.get(position).getNom_centre());
        holder.txt_adress_centre.setText(list_centre.get(position).getAdresse_centre());




    }






    @Override
    public int getItemCount() {
        return list_centre.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        LinearLayout img_centre;
        TextView  txt_nom_centre , txt_adress_centre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            img_centre= (LinearLayout) itemView.findViewById(R.id.imgcentre);
            txt_nom_centre = (TextView) itemView.findViewById(R.id.txt_centrenom);
            txt_adress_centre = (TextView) itemView.findViewById(R.id.centreaddress);




        }


        @Override
        public void onClick(View view) {

        }
    }
}