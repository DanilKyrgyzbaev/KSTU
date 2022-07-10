package kg.kstu.kstu.ui.journal

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kg.kstu.kstu.core.BaseFragment
import kg.kstu.kstu.databinding.JournalFragmentBinding
import kg.kstu.kstu.local.JournalList
import kg.kstu.kstu.ui.journal.adapter.JournalAdapter

class JournalFragment : BaseFragment<JournalFragmentBinding>() {

    companion object {
        val TAG: String = JournalFragment::class.java.simpleName

        fun newInstance() = JournalFragment()
    }

    private lateinit var viewModel: JournalViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(JournalViewModel::class.java)
        // TODO: Use the ViewModel
        setUpAdapter()
    }

    override fun getViewBinding() = JournalFragmentBinding.inflate(layoutInflater)

    override fun onCreateView(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun setUpAdapter() {
        val adapter = JournalAdapter(JournalList.journalList)
        binding.recyclerViewJournal.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewJournal.adapter = adapter
    }
}
