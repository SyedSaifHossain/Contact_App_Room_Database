package com.example.contactapproomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.roomdatabase.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var contactDatabase : ContactDatabase
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.saveBtn.setOnClickListener{
            saveData()
        }

    }

    private fun saveData() {

        val name = binding.editName.text.toString()
        val email = binding.editEmail.text.toString()
        val contact = binding.editContact.text.toString()
        if(name.isNotEmpty() && email.isNotEmpty() && contact.isNotEmpty() ){
            val contact = Contact(null, name,email, contact.toInt())
            GlobalScope.launch (Dispatchers.IO){
                contactDatabase.ContactDao().insert(contact)
            }
            binding.editName.text.clear()
            binding.editEmail.text.clear()
            binding.editContact.text.clear()
            Toast.makeText(this@MainActivity,"Data saved", Toast.LENGTH_SHORT).show()
        }

        else{
            Toast.makeText(this@MainActivity,"Please enter all data", Toast.LENGTH_SHORT).show()
        }
    }
}