package com.performgroup.innovation.kickers.ui.dialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.performgroup.innovation.kickers.R;
import com.performgroup.innovation.kickers.application.GameAPI;
import com.performgroup.innovation.kickers.application.KickersApplication;
import com.performgroup.innovation.kickers.core.Player;

import javax.inject.Inject;

public class GoalDialog extends DialogFragment {

    private static final String PLAYER_ARG = "player";

    private View view;
    private Player player;
    private RadioGroup radioGroup;

    @Inject
    GameAPI gameAPI;

    public GoalDialog() {
        // do nothing
    }

    public static GoalDialog createInstance(Player player) {
        GoalDialog dialog = new GoalDialog();

        Bundle arguments = new Bundle();
        arguments.putSerializable(PLAYER_ARG, player);
        dialog.setArguments(arguments);

        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dialog_register_goal, container);

        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        KickersApplication.inject(this);

        Bundle arguments = getArguments();
        player = (Player) arguments.getSerializable(PLAYER_ARG);

        initView();

        return view;
    }

    private void initView() {
        String title = getString(R.string.register_goal_title, player.name);
        ((TextView) view.findViewById(R.id.tv_match_finished_title)).setText(player.name);

        radioGroup = (RadioGroup) view.findViewById(R.id.rg_goal_options);

        view.findViewById(R.id.b_register_goal).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                registerGoal();
                dismiss();
            }

        });
    }

    private void registerGoal() {
        int radioButtonId = radioGroup.getCheckedRadioButtonId();
        View radioButton = radioGroup.findViewById(radioButtonId);

        switch (radioButton.getId()) {
            case R.id.rb_goal:
                gameAPI.registerGoal(player);
                break;
            case R.id.rb_own_goal:
                gameAPI.registerOwnGoal(player);
                break;
            case R.id.rb_delete_goal:
                Toast.makeText(getActivity(), "NOT YET IMPLEMENTED: remove goal", Toast.LENGTH_LONG).show();
                // TO BE IMPLEMENTED
                break;
        }

    }

}
