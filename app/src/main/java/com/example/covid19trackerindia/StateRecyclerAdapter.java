package com.example.covid19trackerindia;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StateRecyclerAdapter extends RecyclerView.Adapter<StateRecyclerAdapter.StateView> {
    Context context;
    List<StateWiseData.Statewise> list;

    public StateRecyclerAdapter(Context context, List<StateWiseData.Statewise> list) {
        this.context = context;
        this.list = list;
        Log.i("dsfsfs", "StateRecyclerAdapter: "+list.toString());
    }

    @NonNull
    @Override
    public StateView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.state, parent, false);
        return new StateView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StateView holder, int position) {

        holder.state.setText(list.get(position).getState());
        holder. confirmedcase.setText(list.get(position).getConfirmed());
        holder.active.setText(list.get(position).getActive());
        holder.deceasedcase.setText(list.get(position).getDeaths());
        holder.recoverdcase.setText(list.get(position).getRecovered());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class StateView extends RecyclerView.ViewHolder {
        TextView confirmedcase,active,recoverdcase,deceasedcase,state;

        public StateView(@NonNull View itemView) {
            super(itemView);
            confirmedcase=itemView.findViewById(R.id.confirmedcase);
            active=itemView.findViewById(R.id.active);
            recoverdcase=itemView.findViewById(R.id.recoverdcase);
            deceasedcase=itemView.findViewById(R.id.deceasedcase);
            state=itemView.findViewById(R.id.state);
        }
    }
}
