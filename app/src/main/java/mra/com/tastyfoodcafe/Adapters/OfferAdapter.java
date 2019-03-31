package mra.com.tastyfoodcafe.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

import mra.com.tastyfoodcafe.New.Bakeryitemss;
import mra.com.tastyfoodcafe.New.SpecialOffers;
import mra.com.tastyfoodcafe.ProductActivity;
import mra.com.tastyfoodcafe.R;

/**
 * Created by mr. A on 25-02-2019.
 */

public class OfferAdapter  extends RecyclerView.Adapter<OfferAdapter.ViewHolder>
{

    private Context mcontext;
    private List<SpecialOffers> items;
    private DatabaseReference reference;
    private FirebaseAuth mAuth;

    public OfferAdapter(Context mcontext, List<SpecialOffers> items)
    {
        this.mcontext=mcontext;
        this.items=items;
    }

    @NonNull
    @Override
    public OfferAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.offercard,parent,false);


        return new OfferAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OfferAdapter.ViewHolder holder, int position)
    {
        final SpecialOffers b=items.get(position);
        holder.prductname.setText(b.getOffername());
        holder.dayoffer.setText(b.getOfferday());

        if (b.getImage().equals("default"))
        {
            holder.productImage.setImageResource(R.mipmap.ic_launcher);
        }
        else
        {
            Glide.with(mcontext).load(b.getImage()).into(holder.productImage);
        }




        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mcontext,"Visit Our Shop To Grab The Offers",Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public int getItemCount() {

        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView prductname,dayoffer;
        ImageView productImage;

        public ViewHolder(View itemView) {
            super(itemView);

            prductname = itemView.findViewById(R.id.im);
            productImage = itemView.findViewById(R.id.productimage);
            dayoffer=itemView.findViewById(R.id.day);


        }
    }
}
