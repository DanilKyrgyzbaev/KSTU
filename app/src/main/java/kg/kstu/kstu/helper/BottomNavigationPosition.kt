package kg.kstu.kstu.helper

import androidx.fragment.app.Fragment
import kg.kstu.kstu.R
import kg.kstu.kstu.ui.journal.JournalFragment
import kg.kstu.kstu.ui.lecture_schedule.LectureScheduleFragment
import kg.kstu.kstu.ui.notification.NotificationFragment
import kg.kstu.kstu.ui.user_profile_students.UserProfileFragment

enum class BottomNavigationPosition(val position: Int, val id: Int) {
    LECTURE(0, R.id.lecture_schedule),
    GROUP(1, R.id.group_univer),
    NOTIFICATION(2, R.id.notifications),
    PROFILE(3, R.id.profile)
}

fun findNavigationPositionById(id: Int): BottomNavigationPosition = when (id) {
    BottomNavigationPosition.LECTURE.id -> BottomNavigationPosition.LECTURE
    BottomNavigationPosition.GROUP.id -> BottomNavigationPosition.GROUP
    BottomNavigationPosition.NOTIFICATION.id -> BottomNavigationPosition.NOTIFICATION
    BottomNavigationPosition.PROFILE.id -> BottomNavigationPosition.PROFILE
    else -> BottomNavigationPosition.LECTURE
}

fun BottomNavigationPosition.createFragment(): Fragment = when (this) {
    BottomNavigationPosition.LECTURE -> LectureScheduleFragment.newInstance()
    BottomNavigationPosition.GROUP -> JournalFragment.newInstance()
    BottomNavigationPosition.NOTIFICATION -> NotificationFragment.newInstance()
    BottomNavigationPosition.PROFILE -> UserProfileFragment.newInstance()
}

fun BottomNavigationPosition.getTag(): String = when (this) {
    BottomNavigationPosition.LECTURE -> LectureScheduleFragment.TAG
    BottomNavigationPosition.GROUP -> JournalFragment.TAG
    BottomNavigationPosition.NOTIFICATION -> NotificationFragment.TAG
    BottomNavigationPosition.PROFILE -> UserProfileFragment.TAG
}

