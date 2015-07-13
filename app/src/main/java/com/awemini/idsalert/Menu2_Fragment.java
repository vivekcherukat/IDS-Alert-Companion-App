package com.awemini.idsalert;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static com.awemini.idsalert.R.layout.menu2_layout;


/*
  Created by Vivek on 4/16/2015.
 */
public class Menu2_Fragment extends Fragment {
   View rootview;
    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState){
        rootview = inflater.inflate(menu2_layout, container, false);
        return rootview;
    }

}
