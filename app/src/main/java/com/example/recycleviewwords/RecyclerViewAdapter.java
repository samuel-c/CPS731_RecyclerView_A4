package com.example.recycleviewwords;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;



/**
 * Created by User on 1/1/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> recipeTitle = new ArrayList<>();
    private ArrayList<String> recipeDesc = new ArrayList<>();
    private ArrayList<String> recipeText = new ArrayList<>();
    private ArrayList<Integer> recipeImage = new ArrayList<>();
    private ArrayList<String> mText = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<String> recipeTitle,
                               ArrayList<String> recipeDesc, ArrayList<String> recipeText,
                               ArrayList<Integer> recipeImage ) {
        this.recipeTitle = recipeTitle;
        this.recipeDesc = recipeDesc;
        this.recipeText = recipeText;
        this.recipeImage = recipeImage;

        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        holder.recipeTitle.setText(recipeTitle.get(position));
        holder.recipeDesc.setText(recipeDesc.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + recipeTitle.get(position));

                Toast.makeText(mContext, recipeTitle.get(position), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, GalleryActivity.class);
                intent.putExtra("image_id", recipeImage.get(position));
                intent.putExtra("recipe_title", recipeTitle.get(position));
                intent.putExtra("recipe_text", recipeText.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return recipeTitle.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView recipeTitle;
        TextView recipeDesc;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            recipeTitle = itemView.findViewById(R.id.recipe_title);
            recipeDesc = itemView.findViewById(R.id.recipe_desc);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}















