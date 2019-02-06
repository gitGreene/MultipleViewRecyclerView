package codemaestro.co.multipleviewrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<Object> mItems;
    private static final int CARD_LAYOUT_ONE = 1;
    private static final int CARD_LAYOUT_TWO = 2;

    public RecyclerViewAdapter(Context context, List<Object> items) {
        this.context = context;
        this.mItems = items;
    }

    @Override
    public int getItemCount() {
        int itemsArraySize = mItems.size();
        return itemsArraySize;
    }

    @Override
    public int getItemViewType(int position) {
        if(mItems.get(position) instanceof String) {
            return CARD_LAYOUT_ONE;
        } else {
            return CARD_LAYOUT_TWO;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflator = LayoutInflater.from(context);

        switch(viewType) {
            case CARD_LAYOUT_ONE:
                View view1 = inflator.inflate(R.layout.card_layout_one, viewGroup, false);
                viewHolder = new CardOneViewHolder(view1);
                break;
            case CARD_LAYOUT_TWO:
                View view2 = inflator.inflate(R.layout.card_layout_two, viewGroup, false);
                viewHolder = new CardTwoViewHolder(view2);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int position) {
        switch (viewHolder.getItemViewType()) {
            case CARD_LAYOUT_ONE:
                CardOneViewHolder viewHolder1 = (CardOneViewHolder) viewHolder;
                viewHolder1.cardOneTextView.setText("Card One");
                break;
            case CARD_LAYOUT_TWO:
                CardTwoViewHolder viewHolder2 = (CardTwoViewHolder) viewHolder;
                viewHolder2.cardTwoTextView.setText("Card Two");
                break;
        }
    }


    private static class CardOneViewHolder extends RecyclerView.ViewHolder {
        TextView cardOneTextView;

        public CardOneViewHolder(@NonNull View itemView) {
            super(itemView);
            cardOneTextView = itemView.findViewById(R.id.card_one_text_view);
        }
    }

    private static class CardTwoViewHolder extends RecyclerView.ViewHolder {
        TextView cardTwoTextView;

        public CardTwoViewHolder(@NonNull View itemView) {
            super(itemView);
            cardTwoTextView = itemView.findViewById(R.id.card_two_text_view);
        }
    }
}
