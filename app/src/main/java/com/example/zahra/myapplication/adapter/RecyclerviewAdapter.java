package com.example.zahra.myapplication.adapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zahra.myapplication.R;
import com.example.zahra.myapplication.app.ShowActivity;
import com.example.zahra.myapplication.model.Landscape;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by Fotoroos on 05/06/2018.
 */

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder> {
    private List<Landscape> mData;
    private LayoutInflater mInflater;
    private Context context;
    public LayoutInflater getmInflater() {
        return mInflater;
    }

    public RecyclerviewAdapter(Context context, List<Landscape> mData) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = mData;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.cardview, parent, false);
        MyViewHolder myHolderView = new MyViewHolder(view, context);
        return myHolderView;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Landscape landscape; landscape = mData.get(position);
        holder.setData(landscape, position);
        holder.lisener();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent payam=new Intent(v.getContext(), ShowActivity.class);
                payam.putExtra("image",landscape.getImageId());
                payam.putExtra("title",landscape.getTitle());
                payam.putExtra("group",landscape.getGruop());
                LinkedList<Integer> imageLink=landscape.getGallery();
                 ArrayList<Integer> imageList = new ArrayList<>();
                for (int i = 0; i < imageLink.size(); i++) {
                    imageList.add(imageLink.get(i));
                }
                payam.putIntegerArrayListExtra("imageList",imageList);
                context.startActivity(payam);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title, gruop;
        ImageView image, galleryImage, mapImage;
        int position;
        Landscape landscape;
        Context context;

        public MyViewHolder(View view, Context context) {
            super(view);
            this.context = context;
            this.mapImage = (ImageView) view.findViewById(R.id.map);
            this.galleryImage = (ImageView) view.findViewById(R.id.gallery);
            this.image = (ImageView) view.findViewById(R.id.image);
            this.title = (TextView) view.findViewById(R.id.title);
            this.gruop = (TextView) view.findViewById(R.id.gruop);
        }

        public void setData(Landscape data, int position) {
            this.image.setImageResource(data.getImageId());
            this.title.setText(data.getTitle());
            this.gruop.setText(data.getGruop());
            this.position = position;
            landscape = data;
        }

        public void lisener() {
            mapImage.setOnClickListener(MyViewHolder.this);
            galleryImage.setOnClickListener(MyViewHolder.this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.map:
                    Toast.makeText(context, landscape.getAddress() + "", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.gallery:
                    landscape.getGallery().addLast(landscape.getImageId());
                    int nId=landscape.getGallery().getFirst();
                    landscape.getGallery().removeFirst();
                    landscape.setImageId(nId);
                    this.image.setImageResource(landscape.getImageId());
                    break;
            }
        }
    }
}
