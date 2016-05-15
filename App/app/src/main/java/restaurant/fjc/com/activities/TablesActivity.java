package restaurant.fjc.com.activities;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import restaurant.fjc.com.fragments.TablesListFragment;
import restaurant.fjc.com.model.Table;
import restaurant.fjc.com.restaurant.R;

public class TablesActivity extends AppCompatActivity implements TablesListFragment.TablesListListener{


    public static int SELECTED_TABLE = 1;
    public static final String EXTRA_TABLE_UPDATED = "restaurant.com.fjc.activities.TablesActivity.EXTRA_TABLE_UPDATED";
    //private Tables mTables;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables_list);

        //Creo un Tables
        //mTables = new Tables();

        //Como construir un fragment de manera dinámica
        FragmentManager fm = getFragmentManager();

        //Vamos a preguntar si el interfaz que hemos cargado tiene hueco para el TablesListFragment
        if (findViewById(R.id.fragment_tables_list)!= null) {

            //Pues si que tenemos hueco, por lo que vamos a cargar el fragment del list si no esta cargado
            if (fm.findFragmentById(R.id.fragment_tables_list)==null) {

                fm.beginTransaction()
                        .add(R.id.fragment_tables_list, new TablesListFragment())
                        .commit();

            }
        }
    }
    //Aquí va el método del listener que tiene que implementar esta clase
    @Override
    public void onTableSelected(Table table, int position) {

           //Table tableSelected = mTables.getTables().get(position);
            //Se llama a la actividad DetailTableActivity
            Intent intent = new Intent(this, DetailTableActivity.class);

            //Se pasan como parametros la posición y la mesa seleccionada
            intent.putExtra(DetailTableActivity.EXTRA_TABLE_INDEX, position);
            intent.putExtra(DetailTableActivity.EXTRA_TABLE,table);
            startActivity(intent);
        }

}
