package kg.kstu.kstu.extension

import com.google.android.material.bottomnavigation.BottomNavigationView

fun BottomNavigationView.active(position: Int) {
    menu.getItem(position).isChecked = true
}
