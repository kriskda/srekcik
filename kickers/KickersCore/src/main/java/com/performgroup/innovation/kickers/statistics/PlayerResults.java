package com.performgroup.innovation.kickers.statistics;

import com.performgroup.innovation.kickers.core.Player;
import com.performgroup.innovation.kickers.core.PlayerRole;

public class PlayerResults {
    public Player player;
    public int goalsAsAttacker;
    public int ownGoalsAsAttacker;
    public int goalsAsDefender;
    public int ownGoalsAsDefender;

    public void addGoal(PlayerRole playerRole, boolean isOwnGoal) {
        if (isOwnGoal) {
            if (playerRole.equals(PlayerRole.ATTACER)) ownGoalsAsAttacker++;
            if (playerRole.equals(PlayerRole.DEFFENDER)) ownGoalsAsDefender++;
        } else {
            if (playerRole.equals(PlayerRole.ATTACER)) goalsAsAttacker++;
            if (playerRole.equals(PlayerRole.DEFFENDER)) goalsAsDefender++;
        }
    }

    public static PlayerResults createFor(Player player) {
        PlayerResults playerResults = new PlayerResults();
        playerResults.player = player;
        return playerResults;
    }
}