package com.springinaction.knights;

/**
 * Created by sunyinhui on 2017/3/23.
 */
public class BraveKnight implements Knight {

    private Quest quest;

    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    @Override
    public void embarkOnQuest() {
        quest.embark();

    }
}
