package com.example.whatsappchat
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.whatsappchat.databinding.LayoutReceiveMessageBinding
import com.example.whatsappchat.databinding.LayoutSendMessageBinding


class WhatsappAdapter(val message: List<WhatsappMessage>):RecyclerView.Adapter<ViewHolder>() {
    private val VIEW_SENDER = 0
    private val VIEW_RECEIVER = 1


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      return if(viewType==VIEW_RECEIVER){
          val view = LayoutReceiveMessageBinding.inflate(LayoutInflater.from(parent.context),parent,false)
          ReceiverHolder(view)
      }else{
          val view = LayoutSendMessageBinding.inflate(LayoutInflater.from(parent.context),parent,false)
          SenderHolder(view)
      }
    }

    override fun getItemCount(): Int {
        return message.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val currentMessage = message[position]
        if(holder is ReceiverHolder){
            return holder.bind(currentMessage)

        }else if(holder is SenderHolder){
            return holder.bind(currentMessage)
        }

    }

    override fun getItemViewType(position: Int): Int {
        return if(message[position].isSender) VIEW_SENDER else VIEW_RECEIVER
    }

    inner class SenderHolder(private val binding:LayoutSendMessageBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(current:WhatsappMessage){
            binding.txtSend.text = current.message
        }
    }

    inner class ReceiverHolder(private val binding: LayoutReceiveMessageBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(current: WhatsappMessage){
            binding.txtReceive.text = current.message
        }
    }

}