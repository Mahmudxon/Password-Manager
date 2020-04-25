package uz.mahmudxon.passwordmanager.ui.base.component.viewpager

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.animation.DecelerateInterpolator
import android.widget.Scroller
import androidx.viewpager.widget.ViewPager


class NonSwipeViewPager(context: Context, attributeSet: AttributeSet) :
    ViewPager(context, attributeSet) {

    private var mynEnabled = false

    init {
        setMyScroller()
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return this.mynEnabled
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return this.mynEnabled
    }


    private fun setMyScroller() {
        try {
            val viewpager = ViewPager::class.java
            val scroller = viewpager.getDeclaredField("mScroller")
            scroller.isAccessible = true
            scroller.set(this, MyScroller(context))
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    inner class MyScroller(context: Context) : Scroller(context, DecelerateInterpolator()) {
        override fun startScroll(startX: Int, startY: Int, dx: Int, dy: Int, duration: Int) {
            super.startScroll(startX, startY, dx, dy, 350)
        }
    }

    override fun setCurrentItem(item: Int) {
        setCurrentItem(item, false)
    }
}