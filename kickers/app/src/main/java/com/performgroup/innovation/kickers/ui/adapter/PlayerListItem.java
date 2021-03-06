package com.performgroup.innovation.kickers.ui.adapter;

import com.performgroup.innovation.kickers.core.Player;

public class PlayerListItem {

    public Player player;
    public boolean isChosen;

    public PlayerListItem(Player player) {
        this(player, false);
    }

    public PlayerListItem(Player player, boolean isChosen) {
        this.player = player;
        this.isChosen = isChosen;
    }

}
