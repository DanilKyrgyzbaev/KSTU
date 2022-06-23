package kg.kstu.kstu.ui.lecture_schedule

import android.content.Context
import android.graphics.Color
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kg.kstu.kstu.R
import kg.kstu.kstu.databinding.CustomCalendarDayBinding
import java.util.*
import kotlin.collections.ArrayList

class CalendarAdapter(
    private val context: Context,
    private val data: ArrayList<Date>,
    private val currentDate: Calendar,
    private val changeMonth: Calendar?
) : RecyclerView.Adapter<CalendarAdapter.ViewHolder>() {
    private var mListener: AdapterView.OnItemClickListener? = null
    private var index = -1
    private var selectCurrentDate = true
    private val currentMonth = currentDate[Calendar.MONTH]
    private val currentYear = currentDate[Calendar.YEAR]
    private val currentDay = currentDate[Calendar.DAY_OF_MONTH]
    private val selectedDay =
        when {
            changeMonth != null -> changeMonth.getActualMinimum(Calendar.DAY_OF_MONTH)
            else -> currentDay
        }
    private val selectedMonth =
        when {
            changeMonth != null -> changeMonth[Calendar.MONTH]
            else -> currentMonth
        }
    private val selectedYear =
        when {
            changeMonth != null -> changeMonth[Calendar.YEAR]
            else -> currentYear
        }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val itemBinding = CustomCalendarDayBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding, mListener!!)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sdf = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            SimpleDateFormat("EEE MMM dd HH:mm:ss", Locale.ENGLISH)
        } else {
            TODO("VERSION.SDK_INT < N")
        }
        val cal = Calendar.getInstance()
        cal.time = data[position]

        val displayMonth = cal[Calendar.MONTH]
        val displayYear = cal[Calendar.YEAR]
        val displayDay = cal[Calendar.DAY_OF_MONTH]

        if (displayYear >= currentYear)
            if (displayMonth >= currentMonth || displayYear > currentYear)
                if (displayDay >= currentDay || displayMonth > currentMonth || displayYear > currentYear) {
                    holder.linearLayout!!.setOnClickListener {
                        index = position
                        selectCurrentDate = false
                        holder.listener.onItemClick(position)
                        notifyDataSetChanged()
                    }

                    if (index == position)
                        makeItemSelected(holder)
                    else {
                        if (displayDay == selectedDay
                            && displayMonth == selectedMonth
                            && displayYear == selectedYear
                            && selectCurrentDate)
                            makeItemSelected(holder)
                        else
                            makeItemDefault(holder)
                    }
                } else makeItemDisabled(holder)
            else makeItemDisabled(holder)
        else makeItemDisabled(holder)
        holder.txtDay!!.text = cal[Calendar.DAY_OF_MONTH].toString()
        // we will add onClickListener here
    }

    inner class ViewHolder(itemView: CustomCalendarDayBinding, val listener: AdapterView.OnItemClickListener) : RecyclerView.ViewHolder(itemView.root) {
        var txtDay = itemView.txtDate
        var txtDayInWeek = itemView.txtDate
        var linearLayout = itemView.calendarLinearLayout
    }
    interface OnItemClickListener : AdapterView.OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }

    private fun makeItemDisabled(holder: ViewHolder) {
        holder.txtDay!!.setTextColor(ContextCompat.getColor(context, R.color.purple_200))
        holder.txtDayInWeek!!.setTextColor(ContextCompat.getColor(context, R.color.purple_200))
        holder.linearLayout!!.setBackgroundColor(Color.WHITE)
        holder.linearLayout!!.isEnabled = false
    }

    private fun makeItemSelected(holder: ViewHolder) {
        holder.txtDay!!.setTextColor(Color.parseColor("#FFFFFF"))
        holder.txtDayInWeek!!.setTextColor(Color.parseColor("#FFFFFF"))
        holder.linearLayout!!.setBackgroundColor(ContextCompat.getColor(context, R.color.purple_200))
        holder.linearLayout!!.isEnabled = false
    }

    private fun makeItemDefault(holder: ViewHolder) {
        holder.txtDay!!.setTextColor(Color.BLACK)
        holder.txtDayInWeek!!.setTextColor(Color.BLACK)
        holder.linearLayout!!.setBackgroundColor(Color.WHITE)
        holder.linearLayout!!.isEnabled = true
    }
}
