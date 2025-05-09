package com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2.navigation

import com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2.screen.KEY_ID_BELANJA

sealed class Screen(val route: String) {
    object Home: Screen("mainScreen")
    object FormBaru : Screen("form_baru")
    object FormUbah : Screen("form_ubah/{$KEY_ID_BELANJA}") {
        fun withId(id: Long) = "form_ubah/$id"
    }
   object RecycleBin : Screen("recycle_bin")
}
