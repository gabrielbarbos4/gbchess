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
        return false;
    }
}
