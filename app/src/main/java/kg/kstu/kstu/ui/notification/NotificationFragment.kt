package kg.kstu.kstu.ui.notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kg.kstu.kstu.R
import kg.kstu.kstu.core.BaseFragment
import kg.kstu.kstu.databinding.NotificationFragmentBinding
import kg.kstu.kstu.local.NotificatioModelList
import kg.kstu.kstu.ui.notification.adapter.NotificationAdapter

class NotificationFragment : BaseFragment<NotificationFragmentBinding>() {

    companion object {
        val TAG: String = NotificationFragment::class.java.simpleName
        fun newInstance() = NotificationFragment()
    }

    private lateinit var viewModel: NotificationViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NotificationViewModel::class.java)
        // TODO: Use the ViewModel
        setUpAdapter()
    }

    override fun getViewBinding() = NotificationFragmentBinding.inflate(layoutInflater)

    override fun onCreateView(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun setUpAdapter() {
        val adapter = NotificationAdapter(NotificatioModelList.notificationList)
        binding.notificationRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.notificationRecyclerView.adapter = adapter
    }
}
