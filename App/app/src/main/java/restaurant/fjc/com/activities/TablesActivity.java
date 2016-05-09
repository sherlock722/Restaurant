package restaurant.fjc.com.activities;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import restaurant.fjc.com.fragments.TablesListFragment;
import restaurant.fjc.com.model.Table;
import restaurant.fjc.com.restaurant.R;

public class TablesActivity extends AppCompatActivity implements TablesListFragment.TablesListListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables_list);

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

        /*FragmentManager manager = getFragmentManager();

        TableDetailFragment cityPagerFragment = (TableDetailFragment) manager.findFragmentById(R.id.fragment_city_pager);

        //Tenemos una referencia al pager por lo que no tenemos que cambiar de actividad
        if (cityPagerFragment != null){
            //Le indicamos al fragment que muestre la ciudad de la posición "position"
            //Para ello modificamos el CityPagerFragment y le creamos un método público (showCity) que
            //vaya a la ciudad de la posición "position" y se llamará desde esta actividad
            //Esta es otra forma de comunicar una actividad con un fragment, llamando a
            //métodos públicos del fragment
            cityPagerFragment.showCity(position);

        }else {
            //Llamamos a la actividad del CityPager
            Intent intent = new Intent(this, CityPagerActivity.class);

            //Pasamos los parametros a la actividad del CityPagerActivity
            intent.putExtra(CityPagerActivity.EXTRA_CITY_INDEX, position);
            startActivity(intent);
        }*/

    }



}
