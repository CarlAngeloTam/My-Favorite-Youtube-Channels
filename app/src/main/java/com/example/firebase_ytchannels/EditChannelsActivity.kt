package com.example.firebase_ytchannels

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.firebase_ytchannels.handlers.ChannelsHandler
import com.example.firebase_ytchannels.models.Channels

class EditChannelsActivity : AppCompatActivity() {
    lateinit var titleEdit: EditText
    lateinit var linkEdit: EditText
    lateinit var rankEditText: EditText
    lateinit var reasonEdit: EditText
    lateinit var confirm_btn: Button
    lateinit var channelHandler: ChannelsHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var channels: Channels = intent.getSerializableExtra("channel") as Channels

        titleEdit = findViewById(R.id.titleET)
        linkEdit = findViewById(R.id.linkET)
        rankEditText = findViewById(R.id.rankET)
        reasonEdit = findViewById(R.id.reasonET)
        confirm_btn = findViewById(R.id.channelEditBtn)
        channelHandler = ChannelsHandler()

        titleEdit.setText(channels.title)
        linkEdit.setText(channels.title)
        rankEditText.setText(channels.title.toString())
        reasonEdit.setText(channels.title)

        confirm_btn.setOnClickListener {
            val pamagat = titleEdit.text.toString()
            val site = linkEdit.text.toString()
            val ranko = rankEditText.text.toString().toInt()
            val reasonFor = reasonEdit.text.toString()

            val channel1 = Channels(id = channels.id, title = pamagat, link = site, rank = ranko, reason = reasonFor)//passing values to the channels model

            if(titleEdit.toString().isNotEmpty() && linkEdit.toString().isNotEmpty() && rankEditText.toString().isNotEmpty()
                && reasonEdit.toString().isNotEmpty())
            {
                channelHandler.update(channel1)
                Toast.makeText(this, "Edited Successfully", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "Something went wrong. Please try again.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
