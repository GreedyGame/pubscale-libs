package com.pubscale.caterpillar.samples.analytics

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.caterpillar.libs.analytics.client.main.AnalyticsModule

class MainActivity : AppCompatActivity() {

    private val analyticsModule by lazy {
        AnalyticsModule.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnInit).setOnClickListener {
            AnalyticsModule.init(application)
            Toast.makeText(this, "Library initialized", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.btnLogEvent).setOnClickListener {
            analyticsModule?.logEvent(
                "test_event",
                bundleOf()
            )
            Toast.makeText(this, "Event logged", Toast.LENGTH_SHORT).show()
        }
    }
}