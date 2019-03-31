package mra.com.tastyfoodcafe;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import mra.com.tastyfoodcafe.Fragments.AddedCart;
import mra.com.tastyfoodcafe.New.Bakeryitemss;

public class AddtoCartProduct extends AppCompatActivity {

    Button buy;
    ImageButton delete;
    ViewPager viewPager;
    TextView np;
    TextView totalprise;
    Intent intent;
    String id;
    int bigtotal=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addto_cart_product);

        buy=(Button)findViewById(R.id.buycart);
        delete=(ImageButton)findViewById(R.id.delete);
        viewPager=(ViewPager)findViewById(R.id.view_pager);
        np=(TextView)findViewById(R.id.nop);
       // totalprise=(TextView)findViewById(R.id.totalprise);






        //final MainDrawerWindow.ViewPagerAdapter viewPagerAdapter = new AddtoCartProducts().ViewPagerAdapter(getSupportFragmentManager());
        final AddtoCartProduct.ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragment(new AddedCart(), "");

        viewPager.setAdapter(viewPagerAdapter);



        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference reference= FirebaseDatabase.getInstance().getReference("AddToCart").child("data");
                reference.removeValue();
            }
        });

        buttonchek();
       total();



    }

    private void total()
    {
       //intent=getIntent();
        //id=intent.getStringExtra("total");


        String totalamt=getIntent().getStringExtra("total");






    }


    private void buttonchek()
    {
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("AddToCart").child("data");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                Bakeryitemss bakeryitemss=dataSnapshot.getValue(Bakeryitemss.class);

                if(dataSnapshot.exists())
                {
                    buy.setVisibility(View.VISIBLE);
                    np.setVisibility(View.GONE);
                }
                else
                {
                    buy.setVisibility(View.GONE);
                    np.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {
                Toast.makeText(AddtoCartProduct.this,databaseError.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(AddtoCartProduct.this,BuyProductActivity.class));

            }
        });



    }


    class ViewPagerAdapter extends FragmentPagerAdapter
    {

        private ArrayList<Fragment> fragments;
        private ArrayList<String> titles;

        ViewPagerAdapter(FragmentManager fm)
        {
            super(fm);
            this.fragments=new ArrayList<>();
            this.titles=new ArrayList<>();
        }

        @Override
        public Fragment getItem(int position)
        {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
        public void addFragment(Fragment fragment,String title)
        {
            fragments.add(fragment);
            titles.add(title);
        }
        //ctrl+o
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }
}

