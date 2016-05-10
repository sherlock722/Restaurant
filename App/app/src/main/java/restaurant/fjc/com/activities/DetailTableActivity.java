package restaurant.fjc.com.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import restaurant.fjc.com.restaurant.R;

public class DetailTableActivity extends AppCompatActivity {

    //Atributo para saber que indice de ciudad están pasando
    public static final String EXTRA_TABLE_INDEX = "restaurant.com.fjc.activities.DetailTableActivity.EXTRA_CITY_INDEX";
    public static final int VIEW_MENU = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_table);

        //Se comprueba que se esta pasando la posición correcta seleccionada
        //int position = getIntent().getExtras().getInt(EXTRA_TABLE_INDEX);
        //Log.d("INTENT", String.valueOf(position));

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
            //intent.putExtra(MenuListActivity.EXTRA_CURRENT_ORDERS, mTable.getOrders());
            //startActivityForResult(intent, VIEW_MENU);
            startActivity(intent);
    }
}
