package kg.kstu.kstu.ui.user_profile_students

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kg.kstu.kstu.core.BaseFragment
import kg.kstu.kstu.databinding.UserProfileFragmentBinding

class UserProfileFragment : BaseFragment<UserProfileFragmentBinding>() {

    companion object {
        fun newInstance() = UserProfileFragment()
    }

    private lateinit var viewModel: UserProfileViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(UserProfileViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun getViewBinding() = UserProfileFragmentBinding.inflate(layoutInflater)

    override fun onCreateView(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
