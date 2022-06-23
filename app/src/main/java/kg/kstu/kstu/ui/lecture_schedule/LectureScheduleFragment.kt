package kg.kstu.kstu.ui.lecture_schedule

import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearSnapHelper
import kg.kstu.kstu.core.BaseFragment
import kg.kstu.kstu.databinding.LectureScheduleFragmentBinding
import java.util.*
import kotlin.collections.ArrayList

class LectureScheduleFragment : BaseFragment<LectureScheduleFragmentBinding>() {
    private val lastDayInCalendar = Calendar.getInstance(Locale.ENGLISH)
    private val sdf = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        SimpleDateFormat("MMMM yyyy", Locale.ENGLISH)
    } else {
        TODO("VERSION.SDK_INT < N")
    }
    private val cal = Calendar.getInstance(Locale.ENGLISH)

    private val currentDate = Calendar.getInstance(Locale.ENGLISH)
    private val currentDay = currentDate[Calendar.DAY_OF_MONTH]
    private val currentMonth = currentDate[Calendar.MONTH]
    private val currentYear = currentDate[Calendar.YEAR]

    private var selectedDay: Int = currentDay
    private var selectedMonth: Int = currentMonth
    private var selectedYear: Int = currentYear

    private val dates = ArrayList<Date>()
    companion object {
        fun newInstance() = LectureScheduleFragment()
    }

    private lateinit var viewModel: LectureScheduleViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LectureScheduleViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun getViewBinding() = LectureScheduleFragmentBinding.inflate(layoutInflater)

    override fun onCreateView(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.calendarRecyclerView)

        lastDayInCalendar.add(Calendar.MONTH, 6)
    }
    private fun setUpCalendar(changeMonth: Calendar? = null) {
        // first part
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            binding.txtCurrentMonth!!.text = sdf.format(cal.time)
        }
        val monthCalendar = cal.clone() as Calendar
        val maxDaysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH)

        selectedDay =
            when {
                changeMonth != null -> changeMonth.getActualMinimum(Calendar.DAY_OF_MONTH)
                else -> currentDay
            }
        selectedMonth =
            when {
                changeMonth != null -> changeMonth[Calendar.MONTH]
                else -> currentMonth
            }
        selectedYear =
            when {
                changeMonth != null -> changeMonth[Calendar.YEAR]
                else -> currentYear
            }
    }
}
