package ru.smak.graphics_09_862.ui.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CartesianView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    constructor(context: Context) : this(context, null)

    val paintBG: Paint = Paint()
    val paintFG: Paint = Paint()

    var showRect = false
        set(value){
            field = value
            invalidate()
        }

    var function: ((Float)->Float)? = null
        set(value){
            field = value
            invalidate()
        }

    init{
        paintBG.color = 0xfffffff5.toInt()
        paintFG.color = 0xff0000ff.toInt()
    }

    override fun onDraw(canvas: Canvas?){
        super.onDraw(canvas)
        canvas?.apply {
            drawPaint(paintBG)
            drawLine(0F, 0F, width.toFloat(), height.toFloat(), paintFG)

            if (showRect){
                drawRect(10F, 10F, 200F, 500F, paintFG)
            }

            function?.let{
                // Построение графика ф-ии.
            }
        }
    }


}