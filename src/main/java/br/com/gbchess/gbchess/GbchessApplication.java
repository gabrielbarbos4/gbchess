package br.com.gbchess.gbchess;

import br.com.gbchess.gbchess.enums.TeamEnum;
import br.com.gbchess.gbchess.model.*;
import br.com.gbchess.gbchess.model.game.Game;
import br.com.gbchess.gbchess.model.player.Player;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GbchessApplication {

	public static void main(String[] args) {
		SpringApplication.run(GbchessApplication.class, args);

		Game game = createGame(
			new Player("Gabriel", 1),
			new Player("Gabriel", 2)
		);

		game.show();
		game.movePiece(1, 1, 3, 1);
		System.out.println();
		game.show();
	}

	public static Game createGame(Player player1, Player player2) {
		Game game = new Game();
		
		game.setPlayer1(player1);
		game.setPlayer2(player2);
		game.initBoard();

		return game;
	}
}
