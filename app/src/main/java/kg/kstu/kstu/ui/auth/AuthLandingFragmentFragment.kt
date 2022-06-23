package kg.kstu.kstu.ui.auth

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kg.kstu.kstu.core.BaseFragment
import kg.kstu.kstu.databinding.AuthLandingFragmentBinding

class AuthLandingFragmentFragment : BaseFragment<AuthLandingFragmentBinding>() {

    companion object {
        fun newInstance() = AuthLandingFragmentFragment()
    }

    private lateinit var viewModel: AuthLandingViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AuthLandingViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun getViewBinding() = AuthLandingFragmentBinding.inflate(layoutInflater)

    override fun onCreateView(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.next
    }
}
