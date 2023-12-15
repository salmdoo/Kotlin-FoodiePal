package com.example.foodiepal.aboutMe

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.PopupWindow
import com.example.foodiepal.R
import com.example.foodiepal.databinding.FragmentAboutMeBinding
import com.example.foodiepal.databinding.PopupAddAboutmeBinding
import com.example.foodiepal.databinding.PopupAddRecipeBinding

class AboutMeFragment : Fragment() {
    var culinaryJourney: String = ""
    var favoriteRecipe: String = ""
    var foodPhilosophy: String = ""
    private lateinit var binding: FragmentAboutMeBinding

    fun loadData(){
        favoriteRecipe = "Signature Dish:\n Develop your signature dish that reflects your personal style and preferences. It can become your go-to recipe for special occasions."
        culinaryJourney = "Explore Diverse Cuisines\nCooking Classes and Workshops"
        foodPhilosophy = "Mindful Eating:\n" + "Practice mindful eating. Take the time to savor and appreciate each bite, fostering a deeper connection with your food."
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadData()

        binding = FragmentAboutMeBinding.inflate(inflater, container, false)
        binding.culinaryJourney.text = culinaryJourney
        binding.favoriteRecipes.text = favoriteRecipe
        binding.foodPhilosophy.text = foodPhilosophy
        binding.addAboutMeBtn.setOnClickListener { addInfo(inflater, container) }
        // Inflate the layout for this fragment
        return binding.root
    }

    fun addInfo(inflater: LayoutInflater, container: ViewGroup?){
        val popupView = PopupAddAboutmeBinding.inflate(inflater, container, false)
        val popupWindow = PopupWindow(popupView.root, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, true)


        popupWindow.setBackgroundDrawable(ColorDrawable(Color.WHITE))

        popupView.addAboutMeBtn.setOnClickListener {
            val culinaryJourneyPopup = popupView.culinaryJourney.text.toString()
            val favoriteRecipePopup = popupView.favoriteRecipes.text.toString()
            val foodPhilosophyPopup = popupView.foodPhilosophy.text.toString()

            culinaryJourney += "\n $culinaryJourneyPopup"
            favoriteRecipe += "\n $favoriteRecipePopup"
            foodPhilosophy += "\n $foodPhilosophyPopup"

            binding.culinaryJourney.text = culinaryJourney
            binding.favoriteRecipes.text = favoriteRecipe
            binding.foodPhilosophy.text = foodPhilosophy

            popupWindow.dismiss()
        }

        popupView.cancelBtn.setOnClickListener {
            popupWindow.dismiss()
        }

        popupWindow.showAtLocation(popupView.root, Gravity.CENTER, 0, 0)

    }

}