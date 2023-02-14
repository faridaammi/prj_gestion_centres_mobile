package Controller;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.prj_gestion_centre_mobile.Centre_details_activity;
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
        if (list_centre.get(position).getImgs_centre().size()!=0){
            Bitmap bitmap = BitmapFactory.decodeByteArray(list_centre.get(position).getImgs_centre().get(0), 0, list_centre.get(position).getImgs_centre().get(0).length);
            Drawable drawable = new BitmapDrawable(context.getResources(),bitmap);
            holder.img_centre.setBackground(drawable);
        }
        else {
            holder.img_centre.setBackground(context.getResources().getDrawable(R.drawable.defaultimg));

        }
        holder.txt_nom_centre.setText(list_centre.get(position).getNom_centre());
        holder.txt_adress_centre.setText(list_centre.get(position).getAdresse_centre());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"test test",Toast.LENGTH_LONG).show();
                Log.d("position",String.valueOf(holder.getAdapterPosition()));

                Centre centre =(Centre) list_centre.get(holder.getAdapterPosition());

                Intent intent =new Intent(context, Centre_details_activity.class);
                intent.putExtra("centre",centre);
                context.startActivity(intent);
            }
        });
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