package com.vaddy.pceterpapp.mainUI

import com.vaddy.pceterpapp.R

data class ModuleNames(
    var name : String,
    var icon : Int,
)

var ModuleList = listOf(
    ModuleNames("Academics", R.drawable.academics),
    ModuleNames("Accounts", R.drawable.fees),
    ModuleNames("Certificate", R.drawable.certificate),
    ModuleNames("Examination", R.drawable.lms),
    ModuleNames("Feedback", R.drawable.feedback),
    ModuleNames("Hostel", R.drawable.hostel),
    ModuleNames("My Guardian", R.drawable.guardian),
    ModuleNames("My Time Table", R.drawable.mytimetable),
    ModuleNames("Subject Registration", R.drawable.subjectregistration),
)
