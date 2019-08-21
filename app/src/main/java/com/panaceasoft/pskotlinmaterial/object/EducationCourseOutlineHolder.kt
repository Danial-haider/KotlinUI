package com.panaceasoft.pskotlinmaterial.`object`

/**
 * Created by Panacea-Soft on 8/24/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class EducationCourseOutlineHolder {

    var courseName: String
    lateinit var course: EducationCourseOutline.Course
    var isHeader: Boolean = false
    var isTop: Boolean = false
    var isBottom: Boolean = false

    constructor(courseName: String, course: EducationCourseOutline.Course, isHeader: Boolean, isTop: Boolean, isBottom: Boolean) {
        this.courseName = courseName
        this.course = course
        this.isHeader = isHeader
        this.isTop = isTop
        this.isBottom = isBottom
    }

    constructor(courseName: String, isHeader: Boolean) {
        this.courseName = courseName
        this.isHeader = isHeader
    }
}
