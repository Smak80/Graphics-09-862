package ru.smak.gui.graphics.convertation

/**
 * Класс для осуществления преобразования координат в различных системах
 */
class CoordinatesConverter(
    var realWidth:   Int,
    var realHeight:  Int,
    var xMin: Double,
    var xMax: Double,
    var yMin: Double,
    var yMax: Double
) {

    /**
     * Представляет собой номер последнего пикселя по горизонтали на видимой плоскости
     */
    val width: Int
        get() = realWidth - 1
    /**
     * Представляет собой номер последнего пикселя по вертикали на видимой плоскости
     */
    val height: Int
        get() = realHeight - 1

    /**
     * Плотность точек по горизонтали
     */
    val xDen: Double
        get() = width.toDouble() / (xMax - xMin)

    /**
     * Плотность точек по вертикали
     */
    val yDen: Double
        get() = height.toDouble() / (yMax - yMin)

    /**
     * Преобразование абсциссы из декартовой системы координат в экранную
     *
     * @param x абсцисса точки в декартовой системе координат
     * @param plane плоскость, для которой осуществляется преобразование
     * @return абсцисса точки в экранной системе координат
     */
    fun xCrt2Scr(x: Double): Int {
        var r = (xDen * (x - xMin)).toInt()
        if (r < -width) r = -width
        if (r > 2 * width) r = 2 * width
        return r
    }

    /**
     * Преобразование абсциссы из экранной системы координат в декартовую
     *
     * @param x абсцисса точки в экранной системе координат
     * @param plane плоскость, для которой осуществляется преобразование
     * @return абсцисса точки в декартовой системе координат
     */
    fun xScr2Crt(x: Int): Double {
        var _x = x
        if (_x < -width) _x = -width
        if (_x > 2 * width) _x = 2 * width
        return _x / xDen + xMin
    }

    /**
     * Преобразование ординаты из декартовой системы координат в экранную
     *
     * @param y ордината точки в декартовой системе координат
     * @param plane плоскость, для которой осуществляется преобразование
     * @return ордината точки в экранной системе координат
     */
    fun yCrt2Scr(y: Double): Int {
        var r = (yDen * (yMax - y)).toInt()
        if (r < -height) r = -height
        if (r > 2 * height) r = 2 * height
        return r
    }

    /**
     * Преобразование ординаты из экранной системы координат в декартовую
     *
     * @param y ордината точки в экранной системе координат
     * @param plane плоскость, для которой осуществляется преобразование
     * @return ордината точки в декартовой системе координат
     */
    fun yScr2Crt(y: Int): Double {
        var _y = y
        if (_y < -height) _y = -height
        if (_y > 2 * height) _y = 2 * height
        return yMax - _y / yDen
    }
}