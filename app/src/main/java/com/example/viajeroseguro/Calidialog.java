package com.example.viajeroseguro;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;



import androidx.fragment.app.DialogFragment;

public class Calidialog  extends DialogFragment {

    public static final String ARGUMENTO_TITLE ="Title";
    public static final String ARGUMENTO_FULL_SNIPPET ="FULL_SNIPPET";

    private String title;
    private String fullsnupet;

    public static  Calidialog newInstance(String title, String fullsnupet)

    {
        Calidialog  fragment = new Calidialog();
        Bundle b = new Bundle();
        b.putString(ARGUMENTO_TITLE,title);
        b.putString(ARGUMENTO_FULL_SNIPPET,fullsnupet);
        fragment.setArguments(b);
        return fragment;

    }



    public void Oncreate(Bundle savedInstante)

    {
        super.onCreate(savedInstante);
        Bundle args =getArguments();

        title =args.getString(ARGUMENTO_TITLE);
        fullsnupet =args.getString(ARGUMENTO_FULL_SNIPPET);


    }
    public Dialog  OncreateDialog(Bundle savedInstante)

    {
        Dialog dialog = new AlertDialog.Builder(getActivity())
        .setTitle(title)
        .setMessage(fullsnupet)
        .create();

        return dialog;

    }
}
