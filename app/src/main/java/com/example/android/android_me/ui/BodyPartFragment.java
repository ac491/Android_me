package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Sneha on 7/25/2017.
 */

public class BodyPartFragment extends Fragment {
   private List<Integer> mlist;
    private int index;
    final private String IMAGE_ID_LIST="image_ids";
    final private String LIST_INDEX="list_index";

    public BodyPartFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(savedInstanceState!=null){
            mlist=savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            index=savedInstanceState.getInt(LIST_INDEX);
        }


      final View rootView = inflater.inflate(R.layout.fragment_bodypart,container,false);

        final ImageView image= (ImageView) rootView.findViewById(R.id.bodypart_image_view);
        image.setImageResource(mlist.get(index));

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index<mlist.size()-1){
                    index++;
                }
                else {
                    index=0;
                }
                image.setImageResource(mlist.get(index));
            }
        });


return rootView;


    }

    public void setImageList(List<Integer> imageId){
        mlist=imageId;
    }

    public void setIndex(int i){
        index=i;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

  outState.putIntegerArrayList(IMAGE_ID_LIST,(ArrayList<Integer>)mlist);
        outState.putInt(LIST_INDEX,index);

    }
}
