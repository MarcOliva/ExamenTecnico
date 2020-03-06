package com.oliva.marc.examentecnico.view.adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oliva.marc.examentecnico.R
import com.oliva.marc.examentecnico.model.Course
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    CourseView {

    private var courseAdapter : CourseRecyclerViewAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ui()
    }

    private fun ui(){
        courses_recyclerview.adapter =courseAdapter
    }

    override fun showCourses(courses: ArrayList<Course>) {
        courses_recyclerview.adapter =
            CourseRecyclerViewAdapter(
                courses
            )
    }


}
