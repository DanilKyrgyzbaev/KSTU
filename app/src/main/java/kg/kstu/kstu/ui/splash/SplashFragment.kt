package kg.kstu.kstu.ui.splash

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kg.kstu.kstu.core.BaseFragment
import kg.kstu.kstu.databinding.SplashFragmentBinding

class SplashFragment : BaseFragment<SplashFragmentBinding>() {

    companion object {
        fun newInstance() = SplashFragment()
    }
    private lateinit var viewModel: SplashViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SplashViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun getViewBinding() = SplashFragmentBinding.inflate(layoutInflater)

    override fun onCreateView(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.check()
    }
}
