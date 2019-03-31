package mra.com.tastyfoodcafe.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import mra.com.tastyfoodcafe.New.Bakeryitemss;
import mra.com.tastyfoodcafe.ProductActivity;
import mra.com.tastyfoodcafe.R;

/**
 * Created by mr. A on 25-02-2019.
 */

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder>
{
    private Context mcontext;
    private List<Bakeryitemss> items;
    private DatabaseReference reference;
    private FirebaseAuth mAuth;
    int overtotal=0;

    public CartAdapter(Context mcontext, List<Bakeryitemss> items)
    {
        this.mcontext=mcontext;
        this.items=items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.addedcartcard,parent,false);


        return new CartAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        final Bakeryitemss b=items.get(position);
        holder.prductname.setText(b.getPname());
        holder.prise.setText(b.getPrise());



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mcontext,"Proceed to Buy Now",Toast.LENGTH_SHORT).show();

            }
        });






    }

    @Override
    public int getItemCount() {

        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView prductname,prise;
        ImageButton delete;
        Button buy;

        public ViewHolder(View itemView) {
            super(itemView);

            prductname = itemView.findViewById(R.id.im);
            prise=itemView.findViewById(R.id.text2);




        }
    }
}
