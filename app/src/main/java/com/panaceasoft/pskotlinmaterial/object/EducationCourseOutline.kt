package com.panaceasoft.pskotlinmaterial.`object`

import com.google.gson.annotations.SerializedName

/**
 * Created by Panacea-Soft on 8/24/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class EducationCourseOutline(@field:SerializedName("category_name")
                             var courseName: String, courseList: List<Course>) {

    @SerializedName("course_list")
    var courseList: List<EducationCourseOutline.Course>

    init {
        this.courseList = courseList
    }

    inner class Course {
        @SerializedName("video_name")
        var videoName: String? = null

        @SerializedName("status")
        var status: String? = null
    }

}
