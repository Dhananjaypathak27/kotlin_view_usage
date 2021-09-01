package `in`.xparticle.test_app

import `in`.xparticle.test_app.adapter.TodoAdapter
import `in`.xparticle.test_app.model.Todo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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
        )

        val adapter = TodoAdapter(list)

        val recylerview =findViewById<RecyclerView>(R.id.rvTodo)

        recylerview.adapter = adapter
        recylerview.layoutManager = LinearLayoutManager(this@RecyclerviewActivity)

        findViewById<Button>(R.id.btnAddTodo).setOnClickListener {
            val title = findViewById<EditText>(R.id.etTodo).text.toString()
            val todo = Todo(title,false)
            list.add(todo)
            adapter.notifyItemInserted(list.size -1)
        }


    }
}