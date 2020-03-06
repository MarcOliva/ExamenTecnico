package com.oliva.marc.examentecnico.view.adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.oliva.marc.examentecnico.R
import com.oliva.marc.examentecnico.model.Entity.Course
import com.oliva.marc.examentecnico.presenter.DetailCoursePresenter
import com.oliva.marc.examentecnico.presenter.Impl.DetailCoursePresenterImpl
import com.oliva.marc.examentecnico.presenter.Impl.StatePresenterImpl
import com.oliva.marc.examentecnico.presenter.StatePresenter
import kotlinx.android.synthetic.main.activity_detail_course.*

class DetailCourseActivity : AppCompatActivity(),DetailCourseView ,StateView{
    private var course:Course?=null
    private var detailCoursePresenter:DetailCoursePresenter?=null
    private var statePresenter :StatePresenter? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_course)

        setUpData()
        ui()

    }
    private fun setUpData(){
        detailCoursePresenter = DetailCoursePresenterImpl(this)
        statePresenter = StatePresenterImpl(this)
        val value = intent.extras?.getBundle("course")?.getSerializable("bundle")
        course= value as Course
        getDetailCourse(course!!)
        getState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun ui(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = course?.name
    }

    override fun getDetailCourse(course: Course) {
       detailCoursePresenter?.getDetailCourse(course)
    }

    override fun setUpCourse(course: Course) {
        description_course_textview.text= course.description
    }

    override fun setState(state: Int?) {
        state_matricula_textview.text= if(state==0){
            "Matricula : inactiva"
        }else{
            "Matricula : activa"
        }
    }

    override fun getState() {
        statePresenter?.getState()
    }

}
