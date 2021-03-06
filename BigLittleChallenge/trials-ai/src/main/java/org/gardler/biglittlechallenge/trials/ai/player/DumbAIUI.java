package org.gardler.biglittlechallenge.trials.ai.player;

import java.util.Random;
import java.util.Set;

import org.gardler.biglittlechallenge.core.model.Deck;
import org.gardler.biglittlechallenge.core.model.PlayedCards;
import org.gardler.biglittlechallenge.core.model.Player;
import org.gardler.biglittlechallenge.core.model.PlayerStatus;
import org.gardler.biglittlechallenge.core.model.Round;
import org.gardler.biglittlechallenge.core.ui.AbstractUI;
import org.gardler.biglittlechallenge.trials.model.Character;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DumbAIUI extends AbstractUI {
	private static final long serialVersionUID = -3859082547675210829L;
	private static Logger logger = LoggerFactory.getLogger(DumbAIUI.class);
	
	public String name = "Default AI UI";
	
	public DumbAIUI() {
		super();
		logger.info("Created Dumb AI Player UI");
	}

	@Override
	public PlayedCards selectCards(Player player, Round round) {
		Deck deck = (Deck) player.getDeck();
		Set<String> keys = player.getDeck().getCards().keySet();

		Random rand = new Random();
		int idx = rand.nextInt(keys.size());
		String key = (String) keys.toArray()[idx];
		
		PlayedCards cards = new PlayedCards("Cards for " + round.getName());
		cards.addCard(deck.getCard(key));
		return cards;
	}

	@Override
	public org.gardler.biglittlechallenge.core.model.Deck createDeck(Player player) {
		Deck deck = new Deck(player.getName());
    	Character card = new Character("Foo");
    	deck.addCard(card);
    	card = new Character("Potato");
    	deck.addCard(card);
    	return deck;
	}
	
	@Override
	public PlayerStatus startGame(Player player) {
		PlayerStatus state = player.getStatus();
		state.setState(PlayerStatus.State.Playing);
		player.setStatus(state);
		return state;
	}
	
}
