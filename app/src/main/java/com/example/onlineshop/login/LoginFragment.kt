package com.example.onlineshop.login

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.onlineshop.R
import com.example.onlineshop.databinding.FragmentLoginBinding
import com.example.onlineshop.di.App
import javax.inject.Inject

class LoginFragment : Fragment() {

    @Inject
    lateinit var viewModel: LoginViewModel

    private var _binding: FragmentLoginBinding? = null

    private val binding get() = _binding!!

    private val watcher = object : LoginFragment.SimpleTextWatcher() {
        override fun afterTextChanged(p0: Editable?) = viewModel.clearError()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.firstNameEditText.addTextChangedListener(watcher)
        binding.passwordEditText.addTextChangedListener(watcher)
        binding.loginButton.setOnClickListener {
             viewModel.login(binding.firstNameEditText.text.toString(),
                    binding.passwordEditText.text.toString())
        }
        viewModel.observeStateFirstName(this) {
            it.apply(binding.firstNameLoginTextInputLayout, binding.firstNameEditText)
        }
        viewModel.observeStatePassword(this) {
            it.apply(binding.passwordTextInputLayout, binding.passwordEditText)
        }

        viewModel.observeLoginSuccess(this) {success->
            if (success)
                Navigation.findNavController(view).navigate(R.id.action_login_user_to_navigation_home)
        }
    }

    override fun onResume() {
        super.onResume()
        val bottomNavigationView = requireActivity()?.findViewById<CardView>(R.id.cardView)
        bottomNavigationView.visibility = View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    abstract class SimpleTextWatcher : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit
        override fun afterTextChanged(p0: Editable?) = Unit
    }
}