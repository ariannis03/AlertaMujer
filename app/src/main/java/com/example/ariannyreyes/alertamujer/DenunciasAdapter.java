package com.example.ariannyreyes.alertamujer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DenunciasAdapter extends ArrayAdapter<Denuncia>{

    public DenunciasAdapter(Context context, ArrayList<Denuncia> items){
        super(context, 0, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Get the data item for this position
        Denuncia denuncia = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.denuncias, parent, false);
        }

        ((TextView) convertView.findViewById(R.id.textViewDenuncia)).setText(denuncia.getNombre());

        // Return the completed view to render on screen
        return convertView;
    }
}
