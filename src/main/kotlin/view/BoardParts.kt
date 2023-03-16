package view

import domain.CoordinateState

enum class BoardParts(val value: String) {
    LEFT_TOP("┌"),
    CENTER_TOP("┬"),
    RIGHT_TOP("┐"),
    LEFT_MIDDLE("├"),
    CENTER_MIDDLE("┼"),
    RIGHT_MIDDLE("┤"),
    LEFT_BOTTOM("└"),
    CENTER_BOTTOM("┴"),
    RIGHT_BOTTOM("┘"),
    GENERAL("─"),
    BLACK_STONE("◎"),
    WHITE_STONE("●"), ;

    companion object {
        fun getPart(coordinateState: CoordinateState, x: Int, y: Int): BoardParts {
            return when {
                x == 0 && y == 0 -> LEFT_TOP
                x == 14 && y == 0 -> RIGHT_TOP
                x == 0 && y == 14 -> LEFT_BOTTOM
                x == 14 && y == 14 -> RIGHT_BOTTOM
                x == 0 -> LEFT_MIDDLE
                x == 14 -> RIGHT_MIDDLE
                y == 0 -> CENTER_TOP
                y == 14 -> CENTER_BOTTOM
                else -> CENTER_MIDDLE
            }
        }
    }
}