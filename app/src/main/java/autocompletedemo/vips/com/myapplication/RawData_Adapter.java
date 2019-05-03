package autocompletedemo.vips.com.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import autocompletedemo.vips.com.myapplication.json_response.MyJsonResponse;

public class RawData_Adapter extends RecyclerView.Adapter<RawData_Adapter.viewHolder> {



    private List<MyJsonResponse> dataList;

    public RawData_Adapter(List<MyJsonResponse> drawerBeanList) {
        this.dataList = drawerBeanList;

    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.raw_data, parent, false);

        return new viewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.tv_data.setText(dataList.get(holder.getAdapterPosition()).getAccount().getType().getName());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    class viewHolder extends RecyclerView.ViewHolder {



        TextView tv_data;

        viewHolder(View itemView) {
            super(itemView);
            tv_data = itemView.findViewById(R.id.tv_data);
        }
    }
}