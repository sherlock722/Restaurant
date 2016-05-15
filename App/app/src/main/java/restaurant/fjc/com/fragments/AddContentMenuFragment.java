package restaurant.fjc.com.fragments;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;

import restaurant.fjc.com.model.MenuContent;
import restaurant.fjc.com.restaurant.R;

/**
 * Created by javier on 14/5/16.
 */
public class AddContentMenuFragment extends DialogFragment {

    private OnAddMenuContentDialogFragmentListener mListener;
    private Bitmap mBitmap;
    private ImageView mImage;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        return createAddMenuContentDialog();
    }

    public static AddContentMenuFragment newInstance(Bundle arguments) {

        AddContentMenuFragment fragment = new AddContentMenuFragment();
        if (arguments != null) {
            fragment.setArguments(arguments);
        }

        return fragment;
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mListener = (OnAddMenuContentDialogFragmentListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString());
        }
    }

    private Dialog createAddMenuContentDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View v = inflater.inflate(R.layout.add_menu_dialog_fragment, null);

        builder.setView(v);

        final MenuContent selected = (MenuContent) getArguments().getSerializable("contentMenu");

        Button addDish = (Button) v.findViewById(R.id.add_button);
        Button cancel = (Button) v.findViewById(R.id.cancel_button);

        //Se carga la imagen
        mImage = (ImageView) v.findViewById(R.id.contentMenu_image);
        new MergeImage().execute(selected.getImageURL());

        //Se carga el nombre del plato
        TextView name = (TextView) v.findViewById(R.id.menuContent_text);
        name.setText(selected.getName());

        //Se carga la descripcion
        TextView description = (TextView) v.findViewById(R.id.menuContent_description);
        description.setText(selected.getDescription());

        //Campo para las notas
        final EditText notes = (EditText) v.findViewById(R.id.menuContent_notes);

        addDish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuContent menuContent = selected;
                mListener.onAddMenuContentButton(menuContent);
                dismiss();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onCancelButton();
                dismiss();
            }
        });

        return builder.create();
    }

    public interface OnAddMenuContentDialogFragmentListener {
        void onAddMenuContentButton(MenuContent newMenuContent);
        void onCancelButton();
    }

    //Clase para cargar la imagen
    private class MergeImage extends AsyncTask<String, String, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }
        protected Bitmap doInBackground(String... args) {
            try {
                mBitmap = BitmapFactory.decodeStream((InputStream) new URL(args[0]).getContent());

            } catch (Exception e) {
                e.printStackTrace();
            }
            return mBitmap;
        }

        protected void onPostExecute(Bitmap image) {

            if(image != null){
                mImage.setImageBitmap(image);

            }
        }
    }
}
