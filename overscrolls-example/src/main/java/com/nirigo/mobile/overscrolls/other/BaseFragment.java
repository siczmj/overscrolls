package com.nirigo.mobile.overscrolls.other;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Sicz-Mesziár János on 2015.08.06..
 */
public class BaseFragment extends Fragment {

    protected View view;

    protected View inflateFragmentLayout(LayoutInflater inflater, ViewGroup container, int fragmentLayout){
        if(view == null){
            view = inflater.inflate(fragmentLayout, container, false);
        }else {
            removeParent(view);
        }
        return view;
    }

    protected void removeParent(View view){
        if(view == null || view.getParent() == null) return;
        ((ViewGroup)view.getParent()).removeView(view);
    }

    public BaseActivity getBaseActivity(){
        if(getActivity() != null && getActivity() instanceof BaseActivity)
            return (BaseActivity) getActivity();
        return null;
    }

    public void hideScrollInfo(){
        if(getBaseActivity() != null)
            getBaseActivity().hideScrollInfo();
    }

    public void showScrollInfo(String text){
        if(getBaseActivity() != null)
            getBaseActivity().showScrollInfo(text);
    }


}