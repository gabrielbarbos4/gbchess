package br.com.gbchess.gbchess.model;

import br.com.gbchess.gbchess.enums.PieceCodeEnum;
import br.com.gbchess.gbchess.enums.TeamEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pawn extends Piece {

    private Boolean firstMove;

    public Pawn(TeamEnum team) {
        this.name = "Pawn";
        this.code = PieceCodeEnum.PAWN;
        this.team = team;
        this.firstMove = true;
    }


    @Override
    public boolean validateMove(int preX, int posX, int preY, int posY, Piece[][] board, final int boardSize) {
        if(preX == 0 || preX == boardSize - 1) {
            return false;
        }

        if(preY == posY) {
            if(firstMove) {
                if(Math.abs(preX - posX) == 2) {
                    return
                            board[posX][posY].getCode() == PieceCodeEnum.EMPTY &&
                            board[posX + (team == TeamEnum.WHITE ? +1 : -1)][posY].getCode() == PieceCodeEnum.EMPTY;
                } else {
                    return Math.abs(preX - posX) == 1 && board[posX][posY].getCode() == PieceCodeEnum.EMPTY;
                }
            } else {
                return Math.abs(preX - posX) == 1 && board[posX][posY].getCode() == PieceCodeEnum.EMPTY;
            }
        } else if(Math.abs(preX - posX) == 1 && Math.abs(preY - posY) == 1) {
            return team != board[posX][posY].getTeam();
        }

        return false;
    }
}
