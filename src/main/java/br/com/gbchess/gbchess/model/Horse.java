package br.com.gbchess.gbchess.model;

import br.com.gbchess.gbchess.enums.PieceCodeEnum;
import br.com.gbchess.gbchess.enums.TeamEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Horse extends Piece {

    public Horse(TeamEnum team) {
        this.name = "Horse";
        this.code = PieceCodeEnum.HORSE;
        this.team = team;
    }

    @Override
    public boolean validateMove(int preX, int posX, int preY, int posY, Piece[][] board, final int boardSize) {
        if(preX == 0 || preX == boardSize - 1) {
            return false;
        }

        final boolean validMoviment =
            Math.abs(preX - posX) == 3 && Math.abs(preY - posY) == 1 ||
            Math.abs(preX - posX) == 1 && Math.abs(preY - posY) == 3;
        final boolean validLocation =
            board[posX][posY].getTeam() != team || board[posX][posY].getCode() == PieceCodeEnum.EMPTY;

        return validMoviment && validLocation;
    }
}
