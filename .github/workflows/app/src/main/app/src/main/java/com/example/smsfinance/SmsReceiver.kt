package com.example.smsfinance

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.widget.Toast

class SmsReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Telephony.Sms.Intents.SMS_RECEIVED_ACTION) {
            val messages = Telephony.Sms.Intents.getMessagesFromIntent(intent)
            for (sms in messages) {
                val text = sms.displayMessageBody ?: continue
                
                // پردازش پیامک بانکی
                if (text.contains("بانک") || text.contains("واریز") || text.contains("برداشت") || text.contains("مانده")) {
                    Toast.makeText(context, "پیامک بانکی دریافت و خوانده شد!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
