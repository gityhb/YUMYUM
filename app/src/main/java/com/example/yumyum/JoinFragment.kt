package com.example.yumyum

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.yumyum.databinding.FragmentJoinBinding

/*
}
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding = FragmentJoinBinding.inflate(layoutInflater)
    //setContentView(binding.root) 왜 안되는걸까?
    return binding.root

    TextView warning_name = findViewById(R.id.warning_name)

*/


class JoinFragment : Fragment() {

    lateinit var binding:FragmentJoinBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentJoinBinding.inflate(inflater)
        return binding.root
    }   //onCreate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //갤러리
        val galleryLauncher = registerForActivityResult(ActivityResultContracts.GetContent(),
            object: ActivityResultCallback<Uri?> {
                override fun onActivityResult(result: Uri?) {
                    binding.profileImg.setImageURI(result)
                }
            })

        binding.profileImgBtn.setOnClickListener {
            galleryLauncher.launch("image/*")
        }

        //경고 글
        binding.joinBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val strName = binding.inputName.text.toString().trim()
                val strId = binding.inputId.text.toString().trim()
                val strNkname = binding.inputNkname.text.toString().trim()
                val strPwd = binding.inputPwd.text.toString().trim()
                val strPwd2 = binding.inputPwd2.text.toString().trim()
                val strPhone = binding.inputPhone.text.toString().trim()
                val strEmail = binding.inputEmail.text.toString().trim()

                val warning_name = view.findViewById<TextView>(R.id.warning_name)
                val warning_id = view.findViewById<TextView>(R.id.warning_id)
                val warning_nkname = view.findViewById<TextView>(R.id.warning_nkname)
                val warning_pwd = view.findViewById<TextView>(R.id.warning_pwd)
                val warning_pwd2 = view.findViewById<TextView>(R.id.warning_pwd2)
                val warning_phone = view.findViewById<TextView>(R.id.warning_phone)
                val warning_email = view.findViewById<TextView>(R.id.warning_email)

                if(strName.isEmpty()) {
                    warning_name.setVisibility(View.VISIBLE)
                }
                if(strId.isEmpty()) {
                    warning_id.setVisibility(View.VISIBLE)
                }
                if(strNkname.isEmpty()) {
                    warning_nkname.setVisibility(View.VISIBLE)
                }
                if(strPwd.isEmpty()) {
                    warning_pwd.setVisibility(View.VISIBLE)
                }
                if(strPwd2.isEmpty()) {
                    warning_pwd2.setVisibility(View.VISIBLE)
                }
                if(strPhone.isEmpty()) {
                    warning_phone.setVisibility(View.VISIBLE)
                }
                if(strEmail.isEmpty()) {
                    warning_email.setVisibility(View.VISIBLE)
                }
                /*visibility 출처
                https://heezit.tistory.com/116*/
            }

        })
    }   //onViewCreated
}

/*
package com.example.yumyum.ui.login

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.example.yumyum.databinding.FragmentJoinBinding

import com.example.yumyum.R

class JoinFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel
    private var _binding: FragmentJoinBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentJoinBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginViewModel = ViewModelProvider(this, LoginViewModelFactory())
            .get(LoginViewModel::class.java)

        val usernameEditText = binding.username
        val passwordEditText = binding.password
        val loginButton = binding.login
        val loadingProgressBar = binding.loading

        loginViewModel.loginFormState.observe(viewLifecycleOwner,
            Observer { loginFormState ->
                if (loginFormState == null) {
                    return@Observer
                }
                loginButton.isEnabled = loginFormState.isDataValid
                loginFormState.usernameError?.let {
                    usernameEditText.error = getString(it)
                }
                loginFormState.passwordError?.let {
                    passwordEditText.error = getString(it)
                }
            })

        loginViewModel.loginResult.observe(viewLifecycleOwner,
            Observer { loginResult ->
                loginResult ?: return@Observer
                loadingProgressBar.visibility = View.GONE
                loginResult.error?.let {
                    showLoginFailed(it)
                }
                loginResult.success?.let {
                    updateUiWithUser(it)
                }
            })

        val afterTextChangedListener = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // ignore
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // ignore
            }

            override fun afterTextChanged(s: Editable) {
                loginViewModel.loginDataChanged(
                    usernameEditText.text.toString(),
                    passwordEditText.text.toString()
                )
            }
        }
        usernameEditText.addTextChangedListener(afterTextChangedListener)
        passwordEditText.addTextChangedListener(afterTextChangedListener)
        passwordEditText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                loginViewModel.login(
                    usernameEditText.text.toString(),
                    passwordEditText.text.toString()
                )
            }
            false
        }

        loginButton.setOnClickListener {
            loadingProgressBar.visibility = View.VISIBLE
            loginViewModel.login(
                usernameEditText.text.toString(),
                passwordEditText.text.toString()
            )
        }
    }

    private fun updateUiWithUser(model: LoggedInUserView) {
        val welcome = getString(R.string.welcome) + model.displayName
        // TODO : initiate successful logged in experience
        val appContext = context?.applicationContext ?: return
        Toast.makeText(appContext, welcome, Toast.LENGTH_LONG).show()
    }

    private fun showLoginFailed(@StringRes errorString: Int) {
        val appContext = context?.applicationContext ?: return
        Toast.makeText(appContext, errorString, Toast.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}*/
