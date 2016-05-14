package restaurant.fjc.com.fragments;


import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

import restaurant.fjc.com.model.MenuContent;

/**
 * Created by javier on 14/5/16.
 */
public class AddContentMenuFragment extends DialogFragment {

    private OnAddDishDialogFragmentListener mListener;

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
            mListener = (OnAddDishDialogFragmentListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " no implementó OnAddDishDialogFragmentListener");
        }
    }

    public interface OnAddDishDialogFragmentListener {
        void onAddDishButtonClick(MenuContent newMenuContent);
        void onCancelButtonClick();
    }

    /*private Dialog createAddDishDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View v = inflater.inflate(R.layout.add_dish_dialog_fragment, null);

        builder.setView(v);

        final MenuContent selectedDish = (MenuContent) getArguments().getSerializable("Dish");

        Button addDish = (Button) v.findViewById(R.id.dish_add_button);
        Button cancel = (Button) v.findViewById(R.id.dish_cancel_button);

        mImage = (ImageView) v.findViewById(R.id.dish_image);
        new LoadImage().execute(selectedDish.getImageURL());
        TextView title = (TextView) v.findViewById(R.id.dish_title_text);
        title.setText(selectedDish.getName());
        TextView description = (TextView) v.findViewById(R.id.dish_description_text);
        description.setText(selectedDish.getDescription());
        Log.v(TAG, selectedDish.getAllergens().toString());

        ImageView crustacean = (ImageView) v.findViewById(R.id.crustacean_icon);
        if (selectedDish.getAllergens().contains("CRUSTACEAN")) { crustacean.setImageAlpha(255); } else { crustacean.setImageAlpha(25); }
        final ImageView egg = (ImageView) v.findViewById(R.id.egg_icon);
        if (selectedDish.getAllergens().contains("EGG")) { egg.setImageAlpha(255); } else { egg.setImageAlpha(25); }
        ImageView fish = (ImageView) v.findViewById(R.id.fish_icon);
        if (selectedDish.getAllergens().toString().contains("FISH")) { fish.setImageAlpha(255); } else { fish.setImageAlpha(25); }
        ImageView milk = (ImageView) v.findViewById(R.id.milk_icon);
        if (selectedDish.getAllergens().contains("MILK")) { milk.setImageAlpha(255); } else { milk.setImageAlpha(25); }
        ImageView peanut = (ImageView) v.findViewById(R.id.peanut_icon);
        if (selectedDish.getAllergens().contains("PEANUT")) { peanut.setImageAlpha(255); } else { peanut.setImageAlpha(25); }
        ImageView soya = (ImageView) v.findViewById(R.id.soya_icon);
        if (selectedDish.getAllergens().contains("SOYA")) { soya.setImageAlpha(255); } else { soya.setImageAlpha(25); }
        ImageView wheat = (ImageView) v.findViewById(R.id.wheat_icon);
        if (selectedDish.getAllergens().contains("WHEAT")) { wheat.setImageAlpha(255); } else { wheat.setImageAlpha(25); }

        final EditText notes = (EditText) v.findViewById(R.id.dish_notes_input);

        addDish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dish newOrder = selectedDish;
                newOrder.setNotes(notes.getText().toString());
                mListener.onAddDishButtonClick(newOrder);
                dismiss();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onCancelButtonClick();
                dismiss();
            }
        });

        return builder.create();

    }*/

}
