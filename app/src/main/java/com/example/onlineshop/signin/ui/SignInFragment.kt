package com.example.onlineshop.signin.ui

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import com.example.onlineshop.R
import com.example.onlineshop.databinding.FragmentSignInBinding
import com.example.onlineshop.di.App
import com.example.onlineshop.signin.SignInViewModel
import javax.inject.Inject

class SignInFragment : Fragment() {

    @Inject
    lateinit var viewModel: SignInViewModel

    private var _binding: FragmentSignInBinding? = null

    private val binding get() = _binding!!

    private val watcher = object : SimpleTextWatcher() {
        override fun afterTextChanged(p0: Editable?) = viewModel.clearError()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.firstNameEditText.addTextChangedListener(watcher)
        binding.lastNameEditText.addTextChangedListener(watcher)
        binding.emailEditText.addTextChangedListener(watcher)
        binding.logInText.setOnClickListener {
            findNavController(view).navigate(R.id.action_sign_in_user_to_login_user)
        }
        binding.signInButton.setOnClickListener {
            viewModel.signIn(binding.firstNameEditText.text.toString(),
                binding.lastNameEditText.text.toString(), binding.emailEditText.text.toString())
        }
        viewModel.observeStateFirstName(this) {
            it.apply(binding.firstNameTextInputLayout, binding.firstNameEditText)
        }
        viewModel.observeStateLastName(this) {
            it.apply(binding.lastNameTextInputLayout, binding.lastNameEditText)
        }
        viewModel.observeStateEmail(this) {
            it.apply(binding.emailTextInputLayout, binding.emailEditText)
        }
        viewModel.observeLoginSuccess(this) { success ->
            if (success)
                findNavController(view).navigate(R.id.action_sign_in_user_to_navigation_home)
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