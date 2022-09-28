package dev.ronnie.standardbankpokeapi.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.ronnie.standardbankpokeapi.R
import dev.ronnie.standardbankpokeapi.databinding.DialogThankYouBinding
import dev.ronnie.standardbankpokeapi.viewmodels.ThankYouViewModel
import javax.inject.Inject

/**
 *created by Ronnie Otieno on 13-Feb-21.
 **/
@AndroidEntryPoint
class ThankYouDialog @Inject constructor() : DialogFragment(R.layout.dialog_thank_you) {

    private lateinit var binding: DialogThankYouBinding
    private val viewModel: ThankYouViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        isCancelable = false
        binding = DialogThankYouBinding.bind(view)
        dialog?.window?.attributes?.windowAnimations = R.style.DialogTheme
        viewModel.saveDialogShown()
        binding.confirmButton.setOnClickListener {
            dialog?.dismiss()
        }
    }

}