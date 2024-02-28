package br.com.gbchess.gbchess.model.game;

import br.com.gbchess.gbchess.enums.TeamEnum;
import br.com.gbchess.gbchess.model.*;
import br.com.gbchess.gbchess.model.player.Player;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {
    static final int BOARD_SIZE = 8;
    static final int WHITE_PAWN_ROW = 2;
    static final int BLACK_PAWN_ROW = 6;

    private Piece[][] board = new Piece[BOARD_SIZE][BOARD_SIZE];
    private Player player1;
    private Player player2;

    public void show() {
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                final String color = board[i][j].getTeam() == TeamEnum.NONE
                    ? "\u001B[37m"
                    : (board[i][j].getTeam() == TeamEnum.WHITE ? "\u001B[34m" : "\u001B[31m");

                System.out.print(color + board[i][j].getName() + "\u001B[0m" + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void movePiece(int preX, int preY, int posX, int posY) {
        try {
            Piece piece = board[preX][preY];

            if (validateMoviment(piece, preX, preY, posX, posY)) {
                board[posX][posY] = piece;
                board[preX][preY] = new EmptyPiece();
            }
        } catch (RuntimeException err) {
            err.printStackTrace();
        }
    }

    private boolean validateMoviment(Piece piece, int preX, int preY, int posX, int posY) {
        return piece.validateMove(preX, posX, preY, posY, board, BOARD_SIZE);
    }

    public void initBoard() {
        placeEmptyPieces();
        placePawns();
        placeTowers();
        placeBishops();
        placeHorses();
        placeKings();
        placeQueens();
    }

    private void placeEmptyPieces() {
        for (int i = 2; i <= 5; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = new EmptyPiece();
            }
        }
    }

    private void placeKings() {
        board[0][4] = new King(TeamEnum.BLACK);
        board[BOARD_SIZE - 1][4] = new King(TeamEnum.WHITE);
    }

    private void placeQueens() {
        board[0][3] = new Queen(TeamEnum.BLACK);
        board[BOARD_SIZE - 1][3] = new Queen(TeamEnum.WHITE);
    }

    private void placeHorses() {
        board[0][1] = new Horse(TeamEnum.BLACK);
        board[0][BOARD_SIZE - 2] = new Horse(TeamEnum.BLACK);

        board[BOARD_SIZE - 1][1] = new Horse(TeamEnum.WHITE);
        board[BOARD_SIZE - 1][BOARD_SIZE - 2] = new Horse(TeamEnum.WHITE);
    }

    private void placeBishops() {
        board[0][2] = new Bishop(TeamEnum.BLACK);
        board[0][BOARD_SIZE - 3] = new Bishop(TeamEnum.BLACK);

        board[BOARD_SIZE - 1][2] = new Bishop(TeamEnum.WHITE);
        board[BOARD_SIZE - 1][BOARD_SIZE - 3] = new Bishop(TeamEnum.WHITE);
    }

    private void placeTowers() {
        board[0][0] = new Tower(TeamEnum.BLACK);
        board[0][BOARD_SIZE - 1] = new Tower(TeamEnum.BLACK);

        board[BOARD_SIZE - 1][0] = new Tower(TeamEnum.WHITE);
        board[BOARD_SIZE - 1][BOARD_SIZE - 1] = new Tower(TeamEnum.BLACK);
    }

    private void placePawns() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            board[1][i] = new Pawn(TeamEnum.BLACK);
            board[6][i] = new Pawn(TeamEnum.WHITE);
        }
    }
}
