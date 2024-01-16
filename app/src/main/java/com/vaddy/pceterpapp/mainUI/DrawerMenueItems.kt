package com.vaddy.pceterpapp.mainUI

import com.vaddy.pceterpapp.R

data class DrawerMenueItems(
    var item: String,
    var icon: Int,
    )

var MenueList = listOf(

    DrawerMenueItems("Home", R.drawable.home),
    DrawerMenueItems("User Profile", R.drawable.profileavatar),
    DrawerMenueItems("Change Password", R.drawable.resetpassword),
    DrawerMenueItems("Virtual ID Card", R.drawable.idcard),
    DrawerMenueItems("Notification", R.drawable.notification),
    DrawerMenueItems("Help", R.drawable.help),
    DrawerMenueItems("Log Out", R.drawable.logout),
)