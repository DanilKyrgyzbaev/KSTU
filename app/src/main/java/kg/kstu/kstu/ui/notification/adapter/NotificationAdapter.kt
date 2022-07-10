package kg.kstu.kstu.ui.notification.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.kstu.kstu.databinding.ItemNotificationBinding
import kg.kstu.kstu.model.NotificationModel

class NotificationAdapter(val notificationModelList: List<NotificationModel>) : RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemNotificationBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val notificationModelList = notificationModelList[position]
        holder.bindItem(notificationModelList)
    }

    override fun getItemCount(): Int {
        return notificationModelList.size
    }
    inner class ViewHolder(val itemNotificationBinding: ItemNotificationBinding) : RecyclerView.ViewHolder(itemNotificationBinding.root) {
        fun bindItem(notificationModel: NotificationModel) {
            itemNotificationBinding.title.text = notificationModel.title
            itemNotificationBinding.tagStateDescription.text = notificationModel.tag_state_description
        }
    }
}
