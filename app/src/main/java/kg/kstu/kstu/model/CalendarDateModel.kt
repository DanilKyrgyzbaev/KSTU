package kg.kstu.kstu.model

import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

data class CalendarDateModel(var data: Date, var isSelected: Boolean = false, var items: ArrayList<LectureModel>? = null) {

    val calendarDay: String
        get() = SimpleDateFormat("EE", Locale.getDefault()).format(data)

    val calendarDate: String
        get() {
            val cal = Calendar.getInstance()
            cal.time = data
            return cal[Calendar.DAY_OF_MONTH].toString()
        }


}

