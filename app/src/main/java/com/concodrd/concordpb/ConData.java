package com.concodrd.concordpb;

import android.content.Context;

import java.util.ArrayList;

import Models.Employes;

public class ConData {
    Context context;

    public ConData(Context mContext) {
        context = mContext;
    }

    public static ArrayList<Employes> getItEmployes() {
        ArrayList<Employes> ITemployes = new ArrayList<Employes>();
        Employes employes1 = new Employes("1","Eng / Khaled Hanafy","IT Department","B-1","F-0","IT Director","500","itsc@concord-ecc.com","01129180067");
        Employes employes2 = new Employes("1","Eng / Ahmed Abd EL Mohsen","IT Department","B-1","F-0","System Admin","503","itsc@concord-ecc.com","01129180067");
        Employes employes3 = new Employes("1","Eng / Sohib","IT Department","B-1","F-0","System Admin","501","itsc@concord-ecc.com","01129180067");
        Employes employes4 = new Employes("1","Eng / Mostafa kotb","IT Department","B-1","F-0","Technical Support","501","itsc@concord-ecc.com","01129180067");
        ITemployes.add(employes1);
        ITemployes.add(employes2);
        ITemployes.add(employes3);
        ITemployes.add(employes4);
        return ITemployes;
    }


}
