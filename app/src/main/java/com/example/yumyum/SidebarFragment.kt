package com.example.yumyum

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.yumyum.databinding.FragmentSidebarBinding

class SidebarFragment : Fragment() {
    lateinit var binding : FragmentSidebarBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSidebarBinding.inflate(inflater, container, false)
        val view = binding.root

        val dbHelper = DBHelper(requireContext())
        val db = dbHelper.readableDatabase

        if(dbHelper.isUserLoggedIn()) {
            val userInfo = dbHelper.getUserInfo(db)

            if(userInfo != null) { // 사용자 정보가 있는 경우
                binding.userNk.text = "${userInfo?.nickname}"
            }
            db.close()
        }

        binding.cancelImg.setOnClickListener {
            val parentLayout = requireView().parent as? ViewGroup
            parentLayout?.visibility = View.GONE
        }


        return view

    }
}