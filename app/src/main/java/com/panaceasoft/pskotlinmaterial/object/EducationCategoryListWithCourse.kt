package com.panaceasoft.pskotlinmaterial.`object`

import com.google.gson.annotations.SerializedName

/**
 * Created by Panacea-Soft on 8/25/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class EducationCategoryListWithCourse {

    @SerializedName("category_name")
    lateinit var category_name: String

    @SerializedName("course_list")
    lateinit var courseList: List<Course>

    inner class Course {
        @SerializedName("course_name")
        lateinit var courseName: String
    }

}
