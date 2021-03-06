package com.umestudio.foody.ui.auth.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

import com.umestudio.foody.R
import com.umestudio.foody.ui.auth.AuthActivity
import kotlinx.android.synthetic.main.fragment_signup_address.*


class SignupAddressFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AuthActivity).toolbarInfo("SignUpAddress")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup_address, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_signup_now.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_signup_success, null)
        }
    }

}
