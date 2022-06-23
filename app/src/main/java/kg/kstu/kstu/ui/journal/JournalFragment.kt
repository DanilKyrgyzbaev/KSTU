package kg.kstu.kstu.ui.journal

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kg.kstu.kstu.core.BaseFragment
import kg.kstu.kstu.databinding.JournalFragmentBinding

class JournalFragment : BaseFragment<JournalFragmentBinding>() {

    companion object {
        fun newInstance() = JournalFragment()
    }

    private lateinit var viewModel: JournalViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(JournalViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun getViewBinding() = JournalFragmentBinding.inflate(layoutInflater)

    override fun onCreateView(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
