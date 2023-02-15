package Controller;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prj_gestion_centre_mobile.R;

import java.util.ArrayList;

import Model.Salle;

public class Salle_Controller  extends RecyclerView.Adapter<Salle_Controller.ViewHolder>{
    private Context context;
    ArrayList<Salle> list_salle;
    ArrayList<Salle> select_item_salle=new ArrayList<>();
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
        if (list_salle.get(position).getImage_salle().length!=0){
            Bitmap bitmap = BitmapFactory.decodeByteArray(list_salle.get(position).getImage_salle(), 0, list_salle.get(position).getImage_salle().length);
            Drawable drawable = new BitmapDrawable(context.getResources(),bitmap);
            holder.imgsalle.setBackground(drawable);
        }
        else {
            holder.imgsalle.setBackground(context.getResources().getDrawable(R.drawable.rectangleorange));

        }
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
        private CardView cardView_salle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtcapacite= (TextView) itemView.findViewById(R.id.capacitesalle);
            txtnum= (TextView) itemView.findViewById(R.id.numsalle);
            imgsalle= (LinearLayout) itemView.findViewById(R.id.imgsalle);
            cardView_salle=(CardView) itemView.findViewById(R.id.cardView_salle);

            cardView_salle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!context.getClass().getSimpleName().equals("Centre_details_activity")){
                        if(select_item_salle.contains(list_salle.get(getAdapterPosition()))){
                            itemView.setBackgroundColor(Color.TRANSPARENT);
                            select_item_salle.remove(list_salle.get(getAdapterPosition()));
                        }else{
                            itemView.setBackgroundResource(R.drawable.btn_background3);
                            select_item_salle.add(list_salle.get(getAdapterPosition()));
                        }
                    }

                }
            });
        }


        @Override
        public void onClick(View view) {

        }
    }
}