package kg.kstu.kstu.ui.lecture_schedule.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.kstu.kstu.databinding.ItemGroupBinding
import kg.kstu.kstu.model.LectureModel

class LectureAdapter(private val lectureModelList: List<LectureModel>) : RecyclerView.Adapter<LectureAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemGroupBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lectureModelList = lectureModelList[position]
        holder.bindItem(lectureModelList)
    }

    override fun getItemCount(): Int {
        return lectureModelList.size
    }
    inner class ViewHolder(val itemBinding: ItemGroupBinding) : RecyclerView.ViewHolder(itemBinding.root){
        fun bindItem(lectureModel: LectureModel) {
            itemBinding.lectureName.text = lectureModel.lecture_name
            itemBinding.groupData.text = lectureModel.group_data
            itemBinding.cafedraData.text = lectureModel.cafedra_data
            itemBinding.dataTimeLecture.text = lectureModel.data_time_lecture
        }
    }
}


