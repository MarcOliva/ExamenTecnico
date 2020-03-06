package com.oliva.marc.examentecnico.view.adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import com.oliva.marc.examentecnico.R
import com.oliva.marc.examentecnico.model.Entity.Course
import com.oliva.marc.examentecnico.model.Entity.User
import com.oliva.marc.examentecnico.presenter.CoursePresenter
import com.oliva.marc.examentecnico.presenter.Impl.CoursePresenterImpl
import com.oliva.marc.examentecnico.presenter.Impl.StatePresenterImpl
import com.oliva.marc.examentecnico.presenter.StatePresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    CourseView ,StateView{
    private var coursePresenter : CoursePresenter?=null
    private var statePresenter :StatePresenter? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ui()
        getUserData()
        getState()
        getCourses()
    }

    private fun ui(){
       coursePresenter =
           CoursePresenterImpl(this)
        statePresenter=StatePresenterImpl(this)
    }

    override fun showCourses(courses: ArrayList<Course>) {
        courses_recyclerview.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        courses_recyclerview.adapter =
            CourseRecyclerViewAdapter(
                this@MainActivity,
                courses
            )
    }

    override fun setUserData(user: User) {
        name_student_textview.text = "Alumno : ${user.name}"
        code_student_textview.text = "Código : ${user.code}"
    }

    override fun setState(state: Int?) {
        state_matricula_textview.text= if(state==0){
            "Matricula : inactiva"
        }else{
            "Matricula : activa"
        }
    }

    override fun getUserData() {
        coursePresenter?.getUserData()
    }

    override fun getCourses() {
        coursePresenter?.getCourses()
    }

    override fun getState() {
        statePresenter?.getState()
    }


}
