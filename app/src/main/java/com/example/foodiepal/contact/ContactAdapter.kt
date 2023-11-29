package com.example.foodiepal.contact

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodiepal.databinding.ContactItemBinding

class ContactAdapter(private val context: Context, val contacts: MutableList<ContactData>): RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {
    inner class ContactViewHolder(private val binding: ContactItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind (contact: ContactData) {
            binding.contactName.text = contact.name
            binding.phoneBtn.setOnClickListener { dial(contact.phone) }
            binding.emailBtn.setOnClickListener { sendEmail(contact.email) }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContactAdapter.ContactViewHolder {
        val binding = ContactItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactAdapter.ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bind(contact)
    }

    override fun getItemCount(): Int = contacts.size

    fun dial(tel: String) {
        val i = Intent()
        i.action = Intent.ACTION_DIAL
        i.data = Uri.parse("tel:" + tel)
        context.startActivity(i)
    }
    fun sendEmail(email: String) {
        Log.d("email", email)
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, email)
        }
        context.startActivity(intent)
    }
}