package mra.com.tastyfoodcafe.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import mra.com.tastyfoodcafe.Adapters.CartAdapter;
import mra.com.tastyfoodcafe.AddtoCartProduct;
import mra.com.tastyfoodcafe.BuyProductActivity;
import mra.com.tastyfoodcafe.New.Bakeryitemss;
import mra.com.tastyfoodcafe.R;


public class AddedCart extends Fragment {

    RecyclerView recyclerView;
    private List<Bakeryitemss> cart;
    private CartAdapter cartAdapter;
    Button byu;
    TextView t;

    private int total=0;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view=inflater.inflate(R.layout.fragment_added_cart, container, false);
        recyclerView=view.findViewById(R.id.addcartproduct);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        byu=view.findViewById(R.id.buycart);
        t=view.findViewById(R.id.t);

        cart=new ArrayList<>();
        readProduct();
        return view;
    }

    private void readProduct()
    {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("AddToCart").child("data");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cart.clear();

                for(DataSnapshot snapshot:dataSnapshot.getChildren())
                {
                    Bakeryitemss item=snapshot.getValue(Bakeryitemss.class);

                    cart.add(item);
                    int total1=((Integer.valueOf(item.getPrise())));

                    total=total+total1;

                    t.setText("Total Prise- "+String.valueOf(total)+".RS");


                }

                cartAdapter=new CartAdapter(getContext(),cart);
                recyclerView.setAdapter(cartAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {


            }
        });



    }



}
