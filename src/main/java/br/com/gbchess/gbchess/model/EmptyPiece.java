package br.com.gbchess.gbchess.model;

import br.com.gbchess.gbchess.enums.PieceCodeEnum;
import br.com.gbchess.gbchess.enums.TeamEnum;

public class EmptyPiece extends Piece {

    public EmptyPiece() {
        this.code = PieceCodeEnum.EMPTY;
        this.name = "EMPTY";
        this.team = TeamEnum.NONE;
    }


    @Override
    public boolean validateMove(int preX, int posX, int preY, int posY, Piece[][] board, final int boardSize) {
        return false;
    }
}
