package com.mocoven.slice

import android.app.PendingIntent
import android.content.Intent
import android.net.Uri
import androidx.core.graphics.drawable.IconCompat
import androidx.slice.Slice
import androidx.slice.SliceProvider
import androidx.slice.builders.ListBuilder
import androidx.slice.builders.ListBuilder.ICON_IMAGE
import androidx.slice.builders.SliceAction

class MySliceProvider : SliceProvider() {

    override fun onBindSlice(sliceUri: Uri): Slice {
        return when (sliceUri.path) {
            "/slice" -> createDemo(sliceUri)
            else -> createDemo(sliceUri)
        }
    }

    private fun createDemo(sliceUri: Uri): Slice {
        return ListBuilder(context, sliceUri, ListBuilder.INFINITY)
                .addRow {
                    it.setTitle("Hello Slice")
                    it.setSubtitle("Click me to launch your app")
                }
                .addAction(SliceAction(getIntent(), IconCompat.createWithResource(context, R.drawable.abc_btn_check_material), ICON_IMAGE, "s"))
                .build()
    }

    override fun onCreateSliceProvider(): Boolean {
        return true
    }

    private fun getIntent(): PendingIntent {
        return PendingIntent.getActivity(context, 0, Intent(context, ScrollingActivity::class.java), 0)
    }
}