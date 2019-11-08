package com.example.LaFCE.Adapters;




import androidx.fragment.app.Fragment;

//import android.support.v4.app.Fragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class SeccionAdapters extends FragmentStatePagerAdapter {

 private final List<Fragment> ListaFragments = new ArrayList<>();
    private final List<String> ListaTitulos = new ArrayList<>();

    public SeccionAdapters(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment, String titulo){
        ListaFragments.add(fragment);
        ListaTitulos.add(titulo);

    }


    @Override
    public CharSequence getPageTitle(int position) {
        return ListaTitulos.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return ListaFragments.get(position);
    }

    @Override
    public int getCount() {
        return ListaFragments.size();
    }
}
