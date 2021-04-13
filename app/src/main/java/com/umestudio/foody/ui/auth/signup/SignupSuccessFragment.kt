package com.umestudio.foody.ui.auth.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.umestudio.foody.R
import com.umestudio.foody.ui.auth.AuthActivity


class SignupSuccessFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AuthActivity).toolbarInfo("SignUpSuccess")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup_success, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}
