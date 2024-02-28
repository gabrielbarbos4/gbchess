package br.com.gbchess.gbchess.model;

import br.com.gbchess.gbchess.enums.PieceCodeEnum;
import br.com.gbchess.gbchess.enums.TeamEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Piece {
    protected String name;
    protected PieceCodeEnum code;
    protected TeamEnum team;

    public abstract boolean validateMove(int preX, int posX, int preY, int posY, Piece[][] board, final int boardSize);
}
