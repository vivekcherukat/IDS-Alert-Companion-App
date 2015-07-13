package com.awemini.idsalert;

import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;


/*
  Created by Vivek on 4/16/2015.
 */
public class Menu1_Fragment extends Fragment {
   View rootview;
    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState){
        rootview = inflater.inflate(R.layout.menu1_layout, container, false);
        return rootview;
    }

}
