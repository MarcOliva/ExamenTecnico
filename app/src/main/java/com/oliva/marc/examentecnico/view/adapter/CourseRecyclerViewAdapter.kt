package com.oliva.marc.examentecnico.view.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.oliva.marc.examentecnico.R
import com.oliva.marc.examentecnico.model.Entity.Course

class CourseRecyclerViewAdapter(val mContext:Context, val courses : ArrayList<Course>) :RecyclerView.Adapter<CourseRecyclerViewAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener{
       private var course :Course ? = null
        private var context:Context?=null
        val nameCourse = itemView.findViewById<TextView>(R.id.course_name_textview)
        val codeCourse = itemView.findViewById<TextView>(R.id.course_code_textview)
        fun setDataCourse(course: Course,context: Context){
            this.course= course
            this.context=context
            nameCourse.text = course.name
            codeCourse.text = course.code
        }
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            val bundle = Bundle()
            bundle.putSerializable("bundle",course)
            val intent = Intent(context,DetailCourseActivity::class.java)
            intent.putExtra("course",bundle)
            context?.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return courses.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setDataCourse(courses[position],mContext)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(mContext).inflate(
                R.layout.item_course,
                parent,
                false
            )
        )
    }
}