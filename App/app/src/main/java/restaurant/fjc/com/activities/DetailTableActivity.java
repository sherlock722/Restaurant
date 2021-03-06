package restaurant.fjc.com.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;

import restaurant.fjc.com.model.Menu;
import restaurant.fjc.com.model.MenuContent;
import restaurant.fjc.com.model.Table;
import restaurant.fjc.com.restaurant.R;

public class DetailTableActivity extends AppCompatActivity {

    //Atributo para saber que indice de ciudad están pasando
    public static final String EXTRA_TABLE_INDEX = "restaurant.com.fjc.activities.DetailTableActivity.EXTRA_TABLE_INDEX";
    public static final String EXTRA_TABLE = "restaurant.com.fjc.activities.DetailTableActivity.EXTRA_TABLE";
    public static final int EXTRA_VIEW_MENU = 1;
    private Table mTable;
    private ArrayAdapter<MenuContent> mMenuContentArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_table);

        //Se comprueba que se esta pasando la posición correcta seleccionada
        //int position = getIntent().getExtras().getInt(EXTRA_TABLE_INDEX);
        //Log.d("INTENT", String.valueOf(position));

        //Se recupera la tabla seleccionada en la pantalla anterior
        mTable = (Table) getIntent().getSerializableExtra(EXTRA_TABLE);

        //Boton para añadir un plato del menu
        FloatingActionButton addMenuButton = (FloatingActionButton) findViewById(R.id.add_menu_button);
        addMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addMenu();
            }
        });

    }
    private void addMenu() {
            Intent intent = new Intent(this, MenuListActivity.class);
            intent.putExtra(MenuListActivity.EXTRA_LIST_MENU,mTable.getMenu());
            startActivityForResult(intent, EXTRA_VIEW_MENU);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == EXTRA_VIEW_MENU) {

            if (resultCode == RESULT_OK) {

                //Actualizamos la mesa con el contenido del menu seleccionado
                Menu menu = (Menu) data.getSerializableExtra(EXTRA_TABLE);
                //Log.v("MENU", String.valueOf(menu.getMenuContents().size()));

                //Se añade la seleccion realizada a la  mesa como Menu
                mTable.setMenu(menu);

                //Actualizamos el adaptador para que esté informado
                //mMenuContentArrayAdapter.notifyDataSetChanged();
                Intent intent = new Intent();

                if (mTable != null) {

                    intent.putExtra(TablesActivity.EXTRA_TABLE_UPDATED, mTable);
                    setResult(RESULT_OK, intent);

                } else {

                    setResult(RESULT_CANCELED);
                }
            }
        }
    }

}
