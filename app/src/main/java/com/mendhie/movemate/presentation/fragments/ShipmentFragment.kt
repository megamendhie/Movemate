package com.mendhie.movemate.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.viewpager.widget.ViewPager
import com.mendhie.movemate.R
import com.mendhie.movemate.databinding.FragmentShipmentBinding
import com.mendhie.movemate.presentation.adapters.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ShipmentFragment : Fragment() {
    private lateinit var binding: FragmentShipmentBinding
    var tabTitle = arrayOf("All", "Completed", "In Progress", "Pending", "Cancelled")
    var unreadCount = arrayOf(12, 5, 3, 4, 0)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentShipmentBinding.inflate(inflater)
        binding.toolbar.apply {
            //set default toolbar title and navigationIcon click
            setNavigationOnClickListener{findNavController().navigateUp()}
        }

        setupViewPager(binding.viewPagerHome)
        binding.tabShipment.setupWithViewPager(binding.viewPagerHome)
        setupTabIcons()


        return binding.root
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(HistoryAllFragment(), "All")
        adapter.addFragment(HistoryAllFragment("loading"), "Completed")
        adapter.addFragment(HistoryAllFragment("in-progress"), "In Progress")
        adapter.addFragment(HistoryAllFragment("pending"), "Pending")
        adapter.addFragment(HistoryAllFragment("cancelled"), "Cancelled")
        viewPager.adapter = adapter
    }

    private fun prepareTabView(pos: Int): View {
        val view: View = layoutInflater.inflate(R.layout.custom_tab, null)
        val tv_title = view.findViewById<View>(R.id.tv_title) as TextView
        val tv_count = view.findViewById<View>(R.id.tv_count) as TextView
        tv_title.text = tabTitle[pos]
        if (unreadCount[pos] > 0) {
            tv_count.visibility = View.VISIBLE
            tv_count.text = "${unreadCount[pos]}"
        } else tv_count.visibility = View.GONE
        return view
    }

    private fun setupTabIcons() {
        for (i in 0 until tabTitle.size) {
            /*TabLayout.Tab tabitem = tabLayout.newTab();
            tabitem.setCustomView(prepareTabView(i));
            tabLayout.addTab(tabitem);*/
            binding.tabShipment.getTabAt(i)?.setCustomView(prepareTabView(i))
        }
    }


}