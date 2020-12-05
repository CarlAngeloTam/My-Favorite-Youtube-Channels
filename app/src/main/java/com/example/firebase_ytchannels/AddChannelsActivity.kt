package com.example.firebase_ytchannels

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.firebase_ytchannels.handlers.ChannelsHandler
import com.example.firebase_ytchannels.models.Channels

class AddChannelsActivity : AppCompatActivity() {
    lateinit var titleEdit: EditText
    lateinit var linkEdit: EditText
    lateinit var rankEdit: EditText
    lateinit var reasonEdit: EditText
    lateinit var confirm_btn: Button
    lateinit var channelHandler: ChannelsHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_channels)

        titleEdit = findViewById(R.id.titleET)
        linkEdit = findViewById(R.id.linkET)
        rankEdit = findViewById(R.id.rankET)
        reasonEdit = findViewById(R.id.reasonET)
        confirm_btn = findViewById(R.id.channelAddBtn)
        channelHandler = ChannelsHandler()

        confirm_btn.setOnClickListener {
            val pamagat = titleEdit.text.toString()
            val site1 = linkEdit.text.toString()
            val ranko1 = rankEdit.text.toString().toInt()
            val reasonHill = reasonEdit.text.toString()

            val channel = Channels(title = pamagat, link = site1, rank = ranko1, reason = reasonHill)//passing values to the channels model

            if(titleEdit.toString().isNotEmpty() && linkEdit.toString().isNotEmpty() && rankEdit.toString().isNotEmpty()
                    && reasonEdit.toString().isNotEmpty())
            {
                channelHandler.create(channel)
                Toast.makeText(this,  "Successfully Added", Toast.LENGTH_SHORT).show()
                clearFields()
            }
            else {
                Toast.makeText(this, "Something went wrong. Please try again.", Toast.LENGTH_SHORT).show()
            }
        }

    }

    fun clearFields(){
        titleEdit.text.clear()
        linkEdit.text.clear()
        rankEdit.text.clear()
        reasonEdit.text.clear()
    }
}
