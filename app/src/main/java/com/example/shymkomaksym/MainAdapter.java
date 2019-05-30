package com.example.shymkomaksym;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.shymkomaksym.Model.Model;
import java.util.ArrayList;
import java.util.List;
import static com.example.shymkomaksym.Model.Model.ONE_TYPE;
import static com.example.shymkomaksym.Model.Model.THREE_TYPE;
import static com.example.shymkomaksym.Model.Model.TWO_TYPE;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

private List<Model> messageList = new ArrayList<>();
private MainContract mainContract;
private Context context;

    public MainAdapter(List<Model> messageList, Context context, MainContract mainContract) {
        this.messageList = messageList;
        this.context = context;
        this.mainContract = mainContract;
    }

    @Override
    public int getItemViewType(int position) {

        Model model = messageList.get(position);

        if(model != null){
            return model.getType();
        }
        return 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;

        switch (i){
            case ONE_TYPE:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_layout_one, viewGroup, false);
                return new OneViewHolder(view);
            case TWO_TYPE:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_layout_two, viewGroup, false);
                return new TwoViewHolder(view);
            case THREE_TYPE:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_layout_three, viewGroup, false);
                return new ThreeViewHolder(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {

        final Model model = messageList.get(i);

        switch (model.getType()){
            case ONE_TYPE:
                ((OneViewHolder) viewHolder).message.setText(model.getMessage());
                ((OneViewHolder) viewHolder).date.setText(model.getDate());
                break;
            case TWO_TYPE:
                ((TwoViewHolder) viewHolder).message.setText(model.getMessage());
                ((TwoViewHolder) viewHolder).date.setText(model.getDate());
                break;
            case  THREE_TYPE:
                ((ThreeViewHolder) viewHolder).message.setText(model.getMessage());
                ((ThreeViewHolder) viewHolder).sponsored.setText(model.getDate());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    class OneViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView message;
        TextView date;

        public OneViewHolder(@NonNull View itemView) {
            super(itemView);
            message = itemView.findViewById(R.id.messageOne);
            date = itemView.findViewById(R.id.dateOne);
            cardView = itemView.findViewById(R.id.messageCardView);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainContract.showMessage((String) message.getText());
                }
            });
        }
    }

    class TwoViewHolder extends RecyclerView.ViewHolder {

        TextView message;
        TextView date;

        public TwoViewHolder(@NonNull View itemView) {
            super(itemView);
            message = itemView.findViewById(R.id.messageTwo);
            date = itemView.findViewById(R.id.dateTwo);
        }
    }

    class ThreeViewHolder extends RecyclerView.ViewHolder{

        TextView message;
        TextView sponsored;

        public ThreeViewHolder(@NonNull View itemView) {
            super(itemView);
            message = itemView.findViewById(R.id.messageThree);
            sponsored = itemView.findViewById(R.id.sponsored);
        }
    }
}
