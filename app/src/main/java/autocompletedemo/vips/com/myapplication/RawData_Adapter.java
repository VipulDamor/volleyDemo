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



    private List<AccountData>  dataList;

    public RawData_Adapter(List<AccountData> drawerBeanList) {
        this.dataList = drawerBeanList;

    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.raw_data, parent, false);

        return new viewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        AccountData accountData = dataList.get(holder.getAdapterPosition());
        holder.tv_data.setText("Account Name : "+accountData.getAccountName()
        +"\n"+"AccountBalance "+accountData.getFormattedAccountBalance()
        +"\n"+"AvailableBalance "+accountData.getFormattedAvailableBalance()
        +"\n"+"ReservedAmount "+accountData.getFormattedReservedAmount()
        +"\n"+"CreditLimit "+accountData.getFormattedCreditLimit());

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