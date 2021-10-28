package `in`.xparticle.test_app

import `in`.xparticle.test_app.adapter.TodoAdapter
import `in`.xparticle.test_app.model.Todo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.AbsListView
import android.widget.TextView
import androidx.transition.Fade
import androidx.transition.Transition
import androidx.transition.TransitionManager
import android.view.ViewGroup
import androidx.transition.Slide


class RecyclerviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        var list = mutableListOf(
            Todo("android",true),
            Todo("banana",false),
            Todo("pineapple",false),
            Todo("kaddu",true),
            Todo("gobhi",false),
            Todo("pineapple",false),
            Todo("pineapple",false),
            Todo("pineapple",false),
            Todo("pineapple",false),
            Todo("pineapple",false),
            Todo("kaddu",true),
            Todo("gobhi",false),
            Todo("android",true),
            Todo("banana",false),
            Todo("pineapple",false),
            Todo("kaddu",true),
            Todo("gobhi",false),
            Todo("pineapple",false),
            Todo("pineapple",false),
            Todo("pineapple",false),
            Todo("pineapple",false),
            Todo("pineapple",false),
            Todo("kaddu",true),
            Todo("gobhi",false),
            Todo("android",true),
            Todo("banana",false),
            Todo("pineapple",false),
            Todo("kaddu",true),
            Todo("gobhi",false),
            Todo("pineapple",false),
            Todo("pineapple",false),
            Todo("pineapple",false),
            Todo("pineapple",false),
            Todo("pineapple",false),
            Todo("kaddu",true),
            Todo("gobhi",false),
            Todo("android",true),
            Todo("banana",false),
            Todo("pineapple",false),
            Todo("kaddu",true),
            Todo("gobhi",false),
            Todo("pineapple",false),
            Todo("pineapple",false),
            Todo("pineapple",false),
            Todo("pineapple",false),
            Todo("pineapple",false),
            Todo("kaddu",true),
            Todo("gobhi",false),
        )

        val adapter = TodoAdapter(list)
        val image = findViewById<TextView>(R.id.textView)


        val recylerview =findViewById<RecyclerView>(R.id.rvTodo)

        recylerview.adapter = adapter
        recylerview.layoutManager = LinearLayoutManager(this@RecyclerviewActivity)

        findViewById<Button>(R.id.btnAddTodo).setOnClickListener {
            val title = findViewById<EditText>(R.id.etTodo).text.toString()
            val todo = Todo(title,false)
            list.add(todo)
            adapter.notifyItemInserted(list.size -1)
        }


        recylerview.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0) {
                    // Scrolling up
                    val transition: Transition = Fade()
                    transition.duration = 100;

                    val view = findViewById<View>(android.R.id.content) as ViewGroup

                    transition.addTarget(R.id.textView);
                    TransitionManager.beginDelayedTransition(view, transition);
                    image.visibility = View.GONE
                } else {
                    // Scrolling down
                    val transition: Transition = Fade()
                    transition.duration = 100;

                    val view = findViewById<View>(android.R.id.content) as ViewGroup
                    transition.addTarget(R.id.textView);
                    TransitionManager.beginDelayedTransition(view, transition);
                    image.visibility = View.VISIBLE
                }
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_FLING) {
                    // Do something
                } else if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    // Do something
                } else {
                    // Do something
                }
            }
        })
    }
}