package com.example.whatsappchat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whatsappchat.databinding.ActivityWhatsappBinding



class WhatsappActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWhatsappBinding
    private lateinit var messages: MutableList<WhatsappMessage>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWhatsappBinding.inflate(layoutInflater)
        setContentView(binding.root)

        messages = mutableListOf(
            WhatsappMessage("Hello! How are you"),
            WhatsappMessage("I wanted to ask you a question"),
            WhatsappMessage("Hi there! What's up?", true),
            WhatsappMessage("Sure, go ahead and ask your question. I'm here to help.",true),
            WhatsappMessage("I'm doing great, thanks! How about you?"),
            WhatsappMessage("Not much, just chilling" , true),
            WhatsappMessage("I'm having a busy day at work, but it's going well."),
            WhatsappMessage("I was wondering if you could help me with a coding problem."),
            WhatsappMessage("Of course! I'll do my best to help. What's the problem?",true),
            WhatsappMessage("Great! It's related to Kotlin programming."),
            WhatsappMessage("I'm all ears. Please describe the problem, and I'll assist you.",true),
            WhatsappMessage("Awesome, thank you! I'll provide the code and error message."),
            WhatsappMessage("I am going to paste it here, and we'll figure it out together."),
            WhatsappMessage("That's great to hear! Keep up the good work.", true),
            WhatsappMessage("Kotlin is a great choice! How's the development going?", true),
            WhatsappMessage("I'm here to help you with any challenges you encounter.", true)

        )


        binding.btnSend.setOnClickListener {
            val messageText = binding.edtSend.text.toString().trim()
            if (messageText.isNotEmpty()) {
                val newMessage = WhatsappMessage(messageText, true)
                messages.add(newMessage)
                binding.whatsappRecyclerView.scrollToPosition(messages.size - 1)
                binding.edtSend.text.clear()
            }
        }
        binding.whatsappRecyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = WhatsappAdapter(messages)
        binding.whatsappRecyclerView.adapter = adapter
    }
}