package com.blackjack.model.player;

import com.blackjack.model.Card;
import com.blackjack.model.GameState;
import com.blackjack.service.strategy.AggressiveStrategy;

public class AggressivePlayer extends Player {

    public AggressivePlayer(String name, double money) {
        super(name, money, new AggressiveStrategy());
    }

    @Override
    public boolean decideToHit(Card dealerUpCard, GameState gameState) {
        return getStrategy().shouldHit(
            getHand().getCards(),
            dealerUpCard,
            gameState.getRunningCount(),
            gameState.getDeck().cardsRemaining()
        );
    }
}
