package com.example.foodiepal.contact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodiepal.R
import com.example.foodiepal.databinding.FragmentContactBinding


class ContactFragment : Fragment() {
    var contacts: MutableList<ContactData> = mutableListOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        contacts.add(ContactData("Dr. Vaughn Boyle MD", "daugherty.blaze@example.org", "+1  785-735-2014"))
        contacts.add(ContactData("Tamara Stroman", "emory88@example.org", "+1  812-751-2772"))
        contacts.add(ContactData("Katheryn Bednar", "ulices.gerlach@example.org", "+1  360-465-0035"))

        val binding = FragmentContactBinding.inflate(inflater, container, false)
        val recycleView = binding.contactRecyclerView

        recycleView.layoutManager = LinearLayoutManager(requireContext())
        ContactAdapter(requireContext(), contacts).also { recycleView.adapter = it }

        // Inflate the layout for this fragment
        return binding.root
    }
}