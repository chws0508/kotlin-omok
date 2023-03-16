package domain

import domain.CoordinateState.BLACK
import domain.CoordinateState.WHITE

class OmokGame(val board: Board, initTurn: CoordinateState = BLACK) {
    var turn = initTurn
        private set

    fun putStone(position: Position): Boolean {
        if (!board.isEmpty(position)) return false
        if (turn == BLACK) {
            if (isBlackForbidden(position)) return false
        }
        board.addStone(turn, position)
        return true
    }

    fun checkWinner(position: Position): Boolean {
        return when (turn) {
            BLACK -> winProcess(position) { isBlackWin(it) }
            WHITE -> winProcess(position) { isWhiteWin(it) }
            else -> throw IllegalArgumentException()
        }
    }

    fun changeTurn() {
        turn = when (turn) {
            BLACK -> WHITE
            WHITE -> BLACK
            CoordinateState.EMPTY -> throw IllegalArgumentException()
        }
    }

    private fun winProcess(position: Position, isWin: (Position) -> Boolean): Boolean {
        if (isWin(position)) {
            board.addStone(turn, position)
            return true
        }
        return false
    }
    private fun isBlackWin(position: Position): Boolean = board.isExactlyFive(position, turn)

    private fun isWhiteWin(position: Position): Boolean =
        board.isExactlyFive(position, turn) || board.isExceedFive(position, turn)

    private fun isBlackForbidden(position: Position): Boolean =
        board.isForbiddenThree(position) or board.isForbiddenFour(position) or board.isExceedFive(position, turn)
}