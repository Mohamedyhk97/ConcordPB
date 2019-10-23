package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.concodrd.concordpb.R;

import java.util.ArrayList;

import Models.Employes;

public class EmplpyesAdapter extends RecyclerView.Adapter<EmplpyesAdapter.ViewHolder> {


    CustomItemClickListener listener;

    private ArrayList<Employes> employesList = new ArrayList<>();
    private Context mContext;

    public EmplpyesAdapter(Context context, ArrayList<Employes> employesList) {

       this.employesList = employesList;
        mContext = context;
    }


    @Override
    public EmplpyesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employe_row, parent, false);
        final EmplpyesAdapter.ViewHolder holder = new EmplpyesAdapter.ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, holder.getPosition());

            }
        });


        return holder;
    }


    @Override
    public void onBindViewHolder(EmplpyesAdapter.ViewHolder holder, final int position) {

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.concordlogo);
        requestOptions.fitCenter();




        holder.tv_employeName.setText(employesList.get(position).getEmployeName());

        holder.tv_empoyeTitle.setText(employesList.get(position).getEmployeTitle());
    }

    //Set method of OnItemClickListener object
    public void setOnItemClickListener(CustomItemClickListener recyclerViewItemClickListner){
        this.listener=recyclerViewItemClickListner;
    }

    @Override
    public int getItemCount() {
        return employesList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView tv_employeName;
        TextView tv_empoyeTitle;

        public int position=0;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_employeName = itemView.findViewById(R.id.tv_empName);
            tv_empoyeTitle = itemView.findViewById(R.id.textView2);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //When item view is clicked, trigger the itemclicklistener
                    //Because that itemclicklistener is indicated in MainActivity
                    listener.onItemClick(v, position);
                }
            });
        }
    }
}