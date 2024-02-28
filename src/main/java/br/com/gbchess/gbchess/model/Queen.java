package br.com.gbchess.gbchess.model;

import br.com.gbchess.gbchess.enums.PieceCodeEnum;
import br.com.gbchess.gbchess.enums.TeamEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Queen extends Piece {

    public Queen(TeamEnum team) {
        this.name = "Queen";
        this.code = PieceCodeEnum.QUEEN;
        this.team = team;
    }


    @Override
    public boolean validateMove(int preX, int posX, int preY, int posY, Piece[][] board, final int boardSize) {
        return false;
    }
}
