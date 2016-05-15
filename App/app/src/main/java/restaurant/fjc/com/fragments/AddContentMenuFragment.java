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

    private static final String TAG = "OnAddMenuContentDialogFragmentListener";
    private OnAddMenuContentDialogFragmentListener mListener;
    private Bitmap mBitmap;
    private ImageView mImage;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
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
            throw new ClassCastException(activity.toString() + " no implementó OnAddDishDialogFragmentListener");
        }
    }

    private Dialog createAddDishDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View v = inflater.inflate(R.layout.add_menu_dialog_fragment, null);

        builder.setView(v);

        final MenuContent selected = (MenuContent) getArguments().getSerializable("new");

        Button addDish = (Button) v.findViewById(R.id.dish_add_button);
        Button cancel = (Button) v.findViewById(R.id.dish_cancel_button);

        mImage = (ImageView) v.findViewById(R.id.dish_image);
        new LoadImage().execute(selected.getImageURL());
        TextView title = (TextView) v.findViewById(R.id.dish_title_text);
        title.setText(selected.getName());
        TextView description = (TextView) v.findViewById(R.id.dish_description_text);
        description.setText(selected.getDescription());
        //Log.v(TAG, selected.getAllergens().toString());

        ImageView crustacean = (ImageView) v.findViewById(R.id.crustacean_icon);
        if (selected.getAllergens().contains("CRUSTACEAN")) { crustacean.setImageAlpha(255); } else { crustacean.setImageAlpha(25); }
        final ImageView egg = (ImageView) v.findViewById(R.id.egg_icon);
        if (selected.getAllergens().contains("EGG")) { egg.setImageAlpha(255); } else { egg.setImageAlpha(25); }
        ImageView fish = (ImageView) v.findViewById(R.id.fish_icon);
        if (selected.getAllergens().toString().contains("FISH")) { fish.setImageAlpha(255); } else { fish.setImageAlpha(25); }
        ImageView milk = (ImageView) v.findViewById(R.id.milk_icon);
        if (selected.getAllergens().contains("MILK")) { milk.setImageAlpha(255); } else { milk.setImageAlpha(25); }
        ImageView peanut = (ImageView) v.findViewById(R.id.peanut_icon);
        if (selected.getAllergens().contains("PEANUT")) { peanut.setImageAlpha(255); } else { peanut.setImageAlpha(25); }
        ImageView soya = (ImageView) v.findViewById(R.id.soya_icon);
        if (selected.getAllergens().contains("SOYA")) { soya.setImageAlpha(255); } else { soya.setImageAlpha(25); }
        ImageView wheat = (ImageView) v.findViewById(R.id.wheat_icon);
        if (selected.getAllergens().contains("WHEAT")) { wheat.setImageAlpha(255); } else { wheat.setImageAlpha(25); }

        final EditText notes = (EditText) v.findViewById(R.id.dish_notes_input);

        addDish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuContent newOrder = selected;
                //newOrder.setNotes(notes.getText().toString());
                mListener.onAddMenuContentButton(newOrder);
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

    private class LoadImage extends AsyncTask<String, String, Bitmap> {
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
