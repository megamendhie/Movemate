package com.mendhie.movemate.presentation.fragments

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mendhie.movemate.databinding.FragmentCalculatorBinding


class CalculatorFragment : Fragment() {
    private lateinit var binding: FragmentCalculatorBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCalculatorBinding.inflate(inflater)

        binding.btnHome.setOnClickListener {
            findNavController().navigateUp()
        }
        startCountAnimation()
        return binding.root
    }

    private fun startCountAnimation() {
        val animator = ValueAnimator.ofInt(1000, 1460) //0 is min number, 600 is max number
        animator.setDuration(2000) //Duration is in milliseconds
        animator.addUpdateListener { animation -> binding.txtAmount.text = buildString {
            append(animation.animatedValue)
            append(" USD")
        } }
        animator.start()
    }

}