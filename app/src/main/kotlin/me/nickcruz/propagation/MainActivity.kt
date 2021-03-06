package me.nickcruz.propagation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.Fade
import android.transition.Slide
import android.transition.TransitionSet
import android.view.Gravity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Flight Details"

        // These are inside a refresh layout so we can easily "refresh" and see the transition again.
        swipeRefreshLayout.setOnRefreshListener {
            PropagatingTransition(sceneRoot = constraintLayout,
                    startingView = imageIcon,
                    transition = TransitionSet()
                            .addTransition(Fade(Fade.IN)
                                    .setInterpolator { (it - 0.5f) * 2 })
                            .addTransition(Slide(Gravity.BOTTOM))
                    )
                    .start()
            swipeRefreshLayout.isRefreshing = false
        }
    }
}
