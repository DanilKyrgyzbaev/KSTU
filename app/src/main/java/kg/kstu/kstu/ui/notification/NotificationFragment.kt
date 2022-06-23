package kg.kstu.kstu.ui.notification

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kg.kstu.kstu.core.BaseFragment
import kg.kstu.kstu.databinding.NotificationFragmentBinding

class NotificationFragment : BaseFragment<NotificationFragmentBinding>() {

    companion object {
        fun newInstance() = NotificationFragment()
    }

    private lateinit var viewModel: NotificationViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NotificationViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun getViewBinding() = NotificationFragmentBinding.inflate(layoutInflater)

    override fun onCreateView(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
