package br.com.gbchess.gbchess.model;

import br.com.gbchess.gbchess.enums.PieceCodeEnum;
import br.com.gbchess.gbchess.enums.TeamEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tower extends Piece {

    public Tower(TeamEnum team) {
        this.name = "Tower";
        this.code = PieceCodeEnum.PAWN;
        this.team = team;
    }


    @Override
    public boolean validateMove(int preX, int posX, int preY, int posY, Piece[][] board, final int boardSize) {
        return preY == posY ? moveHorizontally(preX, preY, posX, board) : moveVertically(preX, preY, posY, board);
    }

    private boolean moveHorizontally(int preX, int preY, int posX, Piece[][] board) {
        int start = Math.min(preX, posX);
        int end = Math.max(preX, posX);

        for (int i = start + 1; i < end; i++) {
            if (board[i][preY].getCode() != PieceCodeEnum.EMPTY) {
                return false;
            }
        }

        return board[posX][preY].getTeam() != team;
    }

    private boolean moveVertically(int preX, int preY, int posY, Piece[][] board) {
        int start = Math.min(preY, posY);
        int end = Math.max(preY, posY);

        for (int i = start + 1; i < end; i++) {
            if (board[preX][i].getCode() != PieceCodeEnum.EMPTY) {
                return false;
            }
        }

        return board[preX][posY].getTeam() != team;
    }
}
