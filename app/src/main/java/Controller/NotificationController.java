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

import Model.Reservation;

public class NotificationController extends RecyclerView.Adapter<NotificationController.ViewHolder> {

    private Context context;
    private List<Reservation> reservationList;

    public NotificationController(Context context, List<Reservation> reservationList) {
        this.context = context;
        this.reservationList = reservationList;
    }

    @NonNull
    @Override
    public NotificationController.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.customlist_notifications,parent,false);
        return new NotificationController.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationController.ViewHolder holder, int position) {
        Reservation item=reservationList.get(position);

        holder.txt_etat.setText(item.getEtats_Reservation());
        holder.txt_type.setText(item.getType_reservation());
        holder.txt_date.setText(item.getDate_Reservation().toString());
        if(item.getEtats_Reservation()=="Acceptee"){
            holder.img_etat.setBackground(this.context.getDrawable(R.drawable.icon_etat_acceptee));
        } else if (item.getEtats_Reservation()=="Refusee") {
            holder.img_etat.setBackground(this.context.getDrawable(R.drawable.icon_etat_refusee));
        }else{
            holder.img_etat.setBackground(this.context.getDrawable(R.drawable.icon_etat_encours));
        }
    }

    @Override
    public int getItemCount() {
        return reservationList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_type;
        private TextView txt_etat;
        private TextView txt_date;
        private ImageView img_etat;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_type=itemView.findViewById(R.id.txtType);
            txt_etat=itemView.findViewById(R.id.txtEtat);
            txt_date=itemView.findViewById(R.id.txtdate);
            img_etat=itemView.findViewById(R.id.imgvEtat);
        }
    }
}
