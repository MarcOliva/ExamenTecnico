package com.oliva.marc.examentecnico.view.adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oliva.marc.examentecnico.R
import com.oliva.marc.examentecnico.model.Course
import com.oliva.marc.examentecnico.presenter.CoursePresenter
import com.oliva.marc.examentecnico.presenter.CoursePresenterImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    CourseView {
    private var coursePresenter : CoursePresenter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ui()
        getCourses()
    }

    private fun ui(){
       coursePresenter = CoursePresenterImpl(this)
    }

    override fun showCourses(courses: ArrayList<Course>) {
        courses_recyclerview.adapter =
            CourseRecyclerViewAdapter(
                courses
            )
    }

    override fun getCourses() {
        coursePresenter?.getCourses()
    }


}
