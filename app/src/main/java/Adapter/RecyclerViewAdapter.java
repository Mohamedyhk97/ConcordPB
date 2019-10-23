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
import java.util.List;

import Models.Department;
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    CustomItemClickListener listener;

    private ArrayList<Department> depName = new ArrayList<>();
    private ArrayList<Integer> depImage = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<Integer> images,ArrayList<Department> depName) {

        depImage = images;
       this.depName = depName;
        mContext = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dep_row, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, holder.getPosition());

            }
        });


        return holder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.concordlogo);
        requestOptions.fitCenter();


        Glide.with(mContext)
                .load(depImage.get(position)).apply(requestOptions)
                .into(holder.image);

        holder.tv_depName.setText(depName.get(position).getDepartmentName());

    }

    //Set method of OnItemClickListener object
    public void setOnItemClickListener(CustomItemClickListener recyclerViewItemClickListner){
        this.listener=recyclerViewItemClickListner;
    }

    @Override
    public int getItemCount() {
        return depImage.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView tv_depName;
        public int position=0;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);
            tv_depName = itemView.findViewById(R.id.tv_depName);
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