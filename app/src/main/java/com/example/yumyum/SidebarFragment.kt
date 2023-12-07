package com.example.yumyum

import android.content.Intent
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

        //레시피
        binding.recipe1.setOnClickListener {
            startActivity(Intent(context, RecipeSearchActivity::class.java))
        }
        binding.recipe2.setOnClickListener {
            startActivity(Intent(context, IngredientSearchActivity::class.java))
        }
        binding.recipe3.setOnClickListener {
            startActivity(Intent(context, RecipeApplicationEnrollActivity::class.java))
        }

        //커뮤니티
        binding.community1.setOnClickListener {
            startActivity(Intent(context, CommunityActivity::class.java))
        }
        binding.community2.setOnClickListener {
            startActivity(Intent(context, CommunityEnrollActivity::class.java))
        }

        //내정보
        binding.my1.setOnClickListener {
            startActivity(Intent(context, MyPageActivity::class.java))
        }
        binding.my2.setOnClickListener {
            startActivity(Intent(context, EditMemberInfoActivity::class.java))
        }

        return view

    }
}