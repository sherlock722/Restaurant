package restaurant.fjc.com.fragments;


import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import restaurant.fjc.com.model.Table;
import restaurant.fjc.com.model.Tables;
import restaurant.fjc.com.restaurant.R;


public class TablesListFragment extends Fragment {

    //Guardamos una referencia al listener
    private TablesListListener mTablesListListener;
    //private Tables mTables;


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

        //Necesito un modelo con el que darles valores a la vista de la lista
        final Tables tables = new Tables();

        //Las listas se rellenan con un adaptador
        final ArrayAdapter<Table> adapter =
                new ArrayAdapter<Table>(getActivity(), //Contexto
                        android.R.layout.simple_list_item_1, //Como pinta la lista. Cogemos una por defecto que trae android
                        tables.getTables() //Lista de mesas
                );

        //Le asignamos el adaptador a la vista para que pinte las mesas
        list.setAdapter(adapter);

        //Para que la lista se entere de que se ha pulsado una celda me tengo que crear un listener para la lista
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Aviso a mi actividad (listener)
                //Compruebo si mi listener está enganchado a la actividad
                if (mTablesListListener != null) {
                    //Aviso a mi listener
                    //Tengo que sacar la mesa que se ha pulsado
                    Table tableSelected = tables.getTables().get(position);

                    //Se lo paso al listener (llamo al método de la interfaz)
                    mTablesListListener.onTableSelected(tableSelected, position);
                }
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
