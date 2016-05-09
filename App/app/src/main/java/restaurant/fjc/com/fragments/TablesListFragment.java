package restaurant.fjc.com.fragments;


import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import restaurant.fjc.com.model.Table;
import restaurant.fjc.com.restaurant.R;


public class TablesListFragment extends Fragment {

    //Guardamos una referencia al listener
    private TablesListListener mTablesListListener;


    public TablesListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_tables_list, container, false);

        //Accedo al ListView
        ListView list = (ListView) root.findViewById(R.id.list_tables);

        //Las listas se rellenan con un adaptador
        /*ArrayAdapter<Tables> adapter =
                new ArrayAdapter<Tables>(getActivity(), //Contexto
                        android.R.layout.simple_list_item_1, //Como pinta la lista. Cogemos una por defecto que trae android
                        null //Lista de mesas
                );*/


        //Hacemos algo con el FloatingActionButton
        FloatingActionButton addButton = (FloatingActionButton) root.findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Creo un SnackBar
                Snackbar.make(getView(), "FAB Pulsado", Snackbar.LENGTH_LONG).show();
            }
        });
        return root;

    }

    //En el método OnAttach este fragment está "enganchado" a la actividad
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        //Mi listener es la actividad (TablesActivity)
        mTablesListListener = (TablesListListener) activity;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        //Mi listener es la actividad (TablesActivity)
        mTablesListListener = (TablesListListener) getActivity();
    }

    //En el método OnDetach este fragment no está "enganchado" a la actividad
    @Override
    public void onDetach() {
        super.onDetach();

        mTablesListListener = null;
    }


    //Creo una interfaz para comunicarme con la actividad que contienen a este fragment (TablesActivity)
    //Esta interfaz la implementa la actividad que es quien se quiere enterar de que se ha pulsado la lista
    public interface TablesListListener {

        void onTableSelected (Table table, int position);

    }

}
