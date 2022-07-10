package kg.kstu.kstu.ui.lecture_schedule

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import kg.kstu.kstu.R
import kg.kstu.kstu.core.BaseFragment
import kg.kstu.kstu.databinding.LectureScheduleFragmentBinding
import kg.kstu.kstu.model.CalendarDateModel
import kg.kstu.kstu.model.LectureModel
import kg.kstu.kstu.ui.lecture_schedule.adapter.CalendarAdapter
import kg.kstu.kstu.ui.lecture_schedule.adapter.LectureAdapter
import kg.kstu.kstu.utils.HorizontalItemDecoration
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class LectureScheduleFragment : BaseFragment<LectureScheduleFragmentBinding>() {
    private val sdf = SimpleDateFormat("MMMM yyyy", Locale.ENGLISH)
    private val cal = Calendar.getInstance(Locale.ENGLISH)
    private val currentDate = Calendar.getInstance(Locale.ENGLISH)
    private val dates = ArrayList<Date>()
    private lateinit var adapter: CalendarAdapter
    private lateinit var adapter2: LectureAdapter
    private val calendarList2 = ArrayList<CalendarDateModel>()
    companion object {
        val TAG: String = LectureScheduleFragment::class.java.simpleName

        fun newInstance() = LectureScheduleFragment()
    }

    private lateinit var viewModel: LectureScheduleViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LectureScheduleViewModel::class.java)
        // TODO: Use the ViewModel
        setUpAdapter()
        setUpClickListener()
        setUpCalendar()
    }

    override fun getViewBinding() = LectureScheduleFragmentBinding.inflate(layoutInflater)
    override fun onCreateView(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    private fun setUpClickListener() {
        binding.ivCalendarNext.setOnClickListener {
            cal.add(Calendar.MONTH, 1)
            setUpCalendar()
        }
        binding.ivCalendarPrevious.setOnClickListener {
            cal.add(Calendar.MONTH, -1)
            if (cal == currentDate)
                setUpCalendar()
            else
                setUpCalendar()
        }
    }

    private fun setUpAdapter() {
        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.single_calendar_margin)
        binding.recyclerView.addItemDecoration(HorizontalItemDecoration(spacingInPixels))
        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.recyclerView)
        adapter = CalendarAdapter { calendarDateModel: CalendarDateModel, position: Int ->
            calendarList2.forEachIndexed { index, calendarModel ->
                calendarModel.isSelected = index == position
            }
            adapter.setData(calendarList2)
            adapter2 = LectureAdapter(calendarDateModel.items)
            binding.itemsRecycler.adapter = adapter2
        }
        binding.recyclerView.adapter = adapter
    }
    private fun setUpCalendar() {
        val calendarList = ArrayList<CalendarDateModel>()
        binding.tvDateMonth.text = sdf.format(cal.time)
        val monthCalendar = cal.clone() as Calendar
        val maxDaysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH)
        dates.clear()
        monthCalendar.set(Calendar.DAY_OF_MONTH, 1)
        while (dates.size < maxDaysInMonth) {
            dates.add(monthCalendar.time)
            calendarList.add(CalendarDateModel(monthCalendar.time, items = arrayListOf(LectureModel(
                "name",
                "groupData",
                "calendarData",
                "dataTime",
                12
            ))))
            monthCalendar.add(Calendar.DAY_OF_MONTH, 1)
        }
        calendarList2.clear()
        calendarList2.addAll(calendarList)
        adapter.setData(calendarList)
    }
}
