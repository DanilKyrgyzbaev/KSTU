package kg.kstu.kstu.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kg.kstu.kstu.databinding.ActivityMainBinding
import kg.kstu.kstu.extension.active
import kg.kstu.kstu.extension.switchFragment
import kg.kstu.kstu.helper.BottomNavigationPosition
import kg.kstu.kstu.helper.createFragment
import kg.kstu.kstu.helper.findNavigationPositionById
import kg.kstu.kstu.helper.getTag

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var navPosition: BottomNavigationPosition = BottomNavigationPosition.LECTURE

    override fun onCreate(savedInstanceState: Bundle?) {
        restoreSavedInstanceState(savedInstanceState)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.apply {
            // Set a default position
            active(navPosition.position) // Extension function

            // Set a listener for handling selection events on bottom navigation items
            setOnNavigationItemSelectedListener { item ->
                navPosition = findNavigationPositionById(item.itemId)
                switchFragment(navPosition)
            }
        }

        // Add the home fragment
        savedInstanceState ?: switchFragment(BottomNavigationPosition.LECTURE)
    }
    override fun onSaveInstanceState(outState: Bundle) {
        // Store the current navigation position.
        outState.putInt(KEY_POSITION, navPosition.id)
        super.onSaveInstanceState(outState)
    }

    private fun restoreSavedInstanceState(savedInstanceState: Bundle?) {
        // Restore the current navigation position.
        savedInstanceState?.getInt(KEY_POSITION, BottomNavigationPosition.LECTURE.id)?.also {
            navPosition = findNavigationPositionById(it)
        }
    }

    private fun switchFragment(navPosition: BottomNavigationPosition): Boolean {
        return findFragment(navPosition).let {
            supportFragmentManager.switchFragment(it, navPosition.getTag()) // Extension function
        }
    }

    private fun findFragment(position: BottomNavigationPosition): Fragment {
        return supportFragmentManager.findFragmentByTag(position.getTag())
            ?: position.createFragment()
    }

    companion object {
        const val KEY_POSITION = "keyPosition"
    }
}
