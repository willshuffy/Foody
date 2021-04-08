package com.umestudio.foody.ui.auth

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.umestudio.foody.R
import kotlinx.android.synthetic.main.layout_toolbar.*

class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        initNavigation()
        initStatusBar()
    }

    fun initNavigation(){
        val pageRequest = intent.getIntExtra("page request", 0)
        if (pageRequest == 2){
//            toolbarSignUp()
            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.fragmentSignIn, true)
                .build()

            Navigation.findNavController(findViewById(R.id.authHostFragment))
                .navigate(R.id.action_signup, null, navOptions)
        }
    }

    fun toolbarInfo(activeFragment: String){

        val setToolbar : Toolbar = findViewById(R.id.toolbar)
        setToolbar.navigationIcon = resources.getDrawable(R.drawable.ic_arrow_back_000, null)
        setToolbar.setNavigationOnClickListener{onBackPressed()}
        when(activeFragment){
            "SignUp"->{
                setToolbar.title = "Sign Up"
                setToolbar.subtitle = "Register and eat"
            }
            "SignUpAddress"->{
                setToolbar.title = "Address"
                setToolbar.subtitle = "Make sure it's valid"
            }
            "SignUpSuccess"->{
                setToolbar.visibility =View.GONE
            }
        }
    }

    fun initStatusBar() {
        //statusbar transparant

        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true)
        }
        if (Build.VERSION.SDK_INT >= 19) {
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }

    }

    fun setWindowFlag(bits: Int, on: Boolean) {
        val win = window
        val winParams = win.attributes
        if (on) {
            winParams.flags = winParams.flags or bits
        } else {
            winParams.flags = winParams.flags and bits.inv()
        }
        win.attributes = winParams
    }
}
