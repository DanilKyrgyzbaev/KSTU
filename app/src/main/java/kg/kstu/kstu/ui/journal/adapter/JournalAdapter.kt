package kg.kstu.kstu.ui.journal.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.kstu.kstu.databinding.ItemJournalBinding
import kg.kstu.kstu.model.JournalModel

class JournalAdapter(val journalList: List<JournalModel>) : RecyclerView.Adapter<JournalAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JournalAdapter.ViewHolder {
        return ViewHolder(ItemJournalBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: JournalAdapter.ViewHolder, position: Int) {
        val journalList = journalList[position]
        holder.bindItem(journalList)
    }

    override fun getItemCount(): Int {
        return journalList.size
    }

    inner class ViewHolder(val itemJournalBinding: ItemJournalBinding) : RecyclerView.ViewHolder(itemJournalBinding.root) {
        fun bindItem(journalModel: JournalModel) {
            itemJournalBinding.title.text = journalModel.tile
            itemJournalBinding.tagStateDescription.text = journalModel.description
        }
    }
}
