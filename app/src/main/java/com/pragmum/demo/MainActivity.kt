package com.pragmum.demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<DemoAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        demoFab.setOnClickListener {
            Snackbar
                .make(
                    recycler,
                    "FAB was pressed!",
                    Snackbar.LENGTH_LONG
                )
                .setAction("Action", null)
                .show()
        }

        layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        val names = arrayListOf<String>("Alfredo", "Davi", "Ider", "Andrea", "Kelly", "Hugo", "Felipe", "Johan", "Eric")
        val positions = arrayListOf<String>("Full Stack", "Backend", "Frontend", "Devops", "QA Developer", "Project Manager")

        var coworkers: ArrayList<PersonModel> = ArrayList()

        for (i in 1..20) {
            coworkers.add(PersonModel(names.random(), positions.random()))
        }

        recycler.layoutManager = layoutManager
        adapter = DemoAdapter(
            coworkers,
            object : DemoAdapter.ItemInterface {
                override fun onClick(position: Int) {
                    Person.coworker = coworkers[position]

                    val intent = Intent(this@MainActivity, DetailActivity::class.java)
                    startActivity(intent)
                }
            }
        )
        recycler.adapter = adapter
    }
}