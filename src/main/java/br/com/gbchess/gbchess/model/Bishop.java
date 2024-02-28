package br.com.gbchess.gbchess.model;

import br.com.gbchess.gbchess.enums.PieceCodeEnum;
import br.com.gbchess.gbchess.enums.TeamEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bishop extends Piece {

    public Bishop(TeamEnum team) {
        this.name = "Bishop";
        this.code = PieceCodeEnum.BISHOP;
        this.team = team;
    }

    @Override
    public boolean validateMove(int preX, int posX, int preY, int posY, Piece[][] board, final int boardSize) {
        return false;
    }
}
