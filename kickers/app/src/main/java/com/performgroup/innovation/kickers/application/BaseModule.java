package com.performgroup.innovation.kickers.application;

import android.widget.ListView;

import com.performgroup.innovation.kickers.model.rules.GameRules;
import com.performgroup.innovation.kickers.model.rules.StaticTeamGameRules;
import com.performgroup.innovation.kickers.ui.activity.MatchActivity;
import com.performgroup.innovation.kickers.ui.activity.PlayersActivity;
import com.performgroup.innovation.kickers.ui.adapter.AvailablePlayersAdapter;
import com.performgroup.innovation.kickers.ui.adapter.ChosenPlayerAdapter;
import com.performgroup.innovation.kickers.ui.fragment.GameRulesDialog;
import com.performgroup.innovation.kickers.ui.dialog.MatchFinishedDialog;
import com.performgroup.innovation.kickers.ui.fragment.PickPlayerFragment;
import com.squareup.otto.Bus;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(library = true,
        complete = false,
        injects = {
                PlayersActivity.class,
                MatchActivity.class,
                PickPlayerFragment.class,
                AvailablePlayersAdapter.class,
                ChosenPlayerAdapter.class,
                GameAPI.class,
                PickPlayerFragment.class,
                MatchFinishedDialog.class,
                GameRulesDialog.class
        }
)
public class BaseModule {

    @Singleton
    @Provides
    public GameAPI provideMatchApi(Bus bus) {
        List<GameRules> gameRuleses = defineGameRules();
        GameAPI gameAPI = new GameAPI(bus, gameRuleses);
        return gameAPI;
    }

    private List<GameRules> defineGameRules() {
        List<GameRules> gameRuleses = new ArrayList<GameRules>();
        gameRuleses.add(new StaticTeamGameRules(5,5));
        gameRuleses.add(new StaticTeamGameRules(5,8));
        return gameRuleses;
    }

    @Singleton
    @Provides
    public Bus provideBus() {
        return new Bus();
    }



}


