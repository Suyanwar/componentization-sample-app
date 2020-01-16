package com.tunaikumobile.component.atom

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText


/**
 *
 * Created by Suyanwar on 2020-01-17.
 * Android Engineer
 *
 **/
class PrefixEditText @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatEditText(context, attrs, defStyleAttr) {

    private var originalLeftPadding = -1f

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        calculatePrefix()
    }

    private fun calculatePrefix() {
        if (originalLeftPadding == -1f) {
            val prefix = tag as String
            val widths = FloatArray(prefix.length)
            paint.getTextWidths(prefix, widths)
            var textWidth = 0f
            for (w in widths) {
                textWidth += w
            }
            originalLeftPadding = compoundPaddingLeft.toFloat()
            setPadding(
                (textWidth + originalLeftPadding).toInt(),
                paddingRight, paddingTop,
                paddingBottom
            )
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val prefix = tag as String
        canvas?.drawText(prefix, originalLeftPadding, getLineBounds(0, null).toFloat(), paint)
    }
}